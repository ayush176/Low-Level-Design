package ParkingLotDesign.services;

import ParkingLotDesign.entities.ParkingFloor;
import ParkingLotDesign.entities.ParkingLot;
import ParkingLotDesign.entities.ParkingSlot;
import ParkingLotDesign.entities.Vehicle;
import ParkingLotDesign.enums.DisplayType;
import ParkingLotDesign.enums.VehicleType;
import ParkingLotDesign.repositories.ParkingDataRepository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingLotService {
    ParkingLot parkingLot;
    HashMap<String, Vehicle> vehicleHashMap;
    ParkingDataRepository parkingDataRepository;

    public void createParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        vehicleHashMap = new HashMap<>();
        parkingDataRepository = new ParkingDataRepository();
        parkingLot.setParkingFloors(
                parkingDataRepository.initializeFloor(parkingLot.getNoOfFloors(), parkingLot.getNoOfSlotsPerFloor())
        );
        System.out.println("Created parking lot with " + parkingLot.getNoOfFloors()
                + " floors and " + parkingLot.getNoOfSlotsPerFloor() + " slots per floor");
    }

    public void display(DisplayType displayType, VehicleType vehicleType) {
        switch (displayType) {
            case FREE_COUNT:
                getSlotsCount(vehicleType);
                break;
            case FREE_SLOTS:
                getFreeSlots(vehicleType);
                break;
            case OCCUPIED_SLOTS:
                getOccupiedSlots(vehicleType);
                break;

        }
    }

    private void getSlotsCount(VehicleType vehicleType) {
        for (int i = 0; i < parkingLot.getParkingFloors().size(); i++) {
            ParkingFloor parkingFloor = parkingLot.getParkingFloors().get(i);
            long count = parkingFloor.getParkingSlots().stream()
                    .filter(parkingSlot -> parkingSlot.isFree() && parkingSlot.getVehicleType().equals(vehicleType)).count();
            System.out.println("No. of free slots for CAR on Floor " + (i + 1) + ": " + count);
        }
    }

    private void getFreeSlots(VehicleType vehicleType) {
        for (int i = 0; i < parkingLot.getParkingFloors().size(); i++) {
            ParkingFloor parkingFloor = parkingLot.getParkingFloors().get(i);
            List<Integer> list = parkingFloor.getParkingSlots().stream()
                    .filter(parkingSlot -> parkingSlot.isFree() && parkingSlot.getVehicleType().equals(vehicleType))
                    .map(e -> e.getSlotNo() + 1)
                    .collect(Collectors.toList());
            StringBuilder sb = new StringBuilder("No. of free slots for CAR on Floor " + (i + 1) + ": ");
            for (int j = 0; j < list.size(); j++) {
                sb.append(list.get(j));
                if (j < list.size() - 1) sb.append(",");
            }
            System.out.println(sb);
        }
    }

    private void getOccupiedSlots(VehicleType vehicleType) {
        for (int i = 0; i < parkingLot.getParkingFloors().size(); i++) {
            ParkingFloor parkingFloor = parkingLot.getParkingFloors().get(i);
            List<Integer> list = parkingFloor.getParkingSlots().stream()
                    .filter(parkingSlot -> !parkingSlot.isFree() && parkingSlot.getVehicleType().equals(vehicleType))
                    .map(e -> e.getSlotNo() + 1)
                    .collect(Collectors.toList());
            StringBuilder sb = new StringBuilder("No. of occupied slots for CAR on Floor " + (i + 1) + ": ");
            for (int j = 0; j < list.size(); j++) {
                sb.append(list.get(j));
                if (j < list.size() - 1) sb.append(",");
            }
            System.out.println(sb);
        }
    }

    public void parkVehicle(VehicleType vehicleType, String regNo, String color) {
        ParkingSlot freeSlot = getNearestFreeSlot(vehicleType);

        if (freeSlot == null) {
            System.out.println("Parking Lot Full");
        } else {
            freeSlot.setFree(false);
            Vehicle vehicle = new Vehicle(vehicleType, regNo, color);
            String ticket = generateTicket(freeSlot);
            vehicle.setTicket(ticket);
            vehicleHashMap.put(ticket, vehicle);
            System.out.println("Parked vehicle. Ticket ID: " + ticket);
        }
    }

    private String generateTicket(ParkingSlot freeSlot) {
        return parkingLot.getParkingLotId() + "_" + (freeSlot.getFloorNo() + 1) + "_" + (freeSlot.getSlotNo() + 1);
    }

    private ParkingSlot getNearestFreeSlot(VehicleType vehicleType) {
        for (int i = 0; i < parkingLot.getParkingFloors().size(); i++) {
            ParkingFloor parkingFloor = parkingLot.getParkingFloors().get(i);
            for (int j = 0; j < parkingFloor.getParkingSlots().size(); j++) {
                ParkingSlot parkingSlot = parkingFloor.getParkingSlots().get(j);
                if (parkingSlot.isFree() && parkingSlot.getVehicleType().equals(vehicleType)) {
                    return parkingSlot;
                }
            }
        }
        return null;
    }

    public void unParkVehicle(String ticket) {
        if (vehicleHashMap.get(ticket) == null) {
            System.out.println("Invalid Ticket");
        } else {
            Vehicle vehicle = vehicleHashMap.get(ticket);
            int floorNo = Integer.parseInt(ticket.split("_")[1]);
            int slotNo = Integer.parseInt(ticket.split("_")[2]);
            ParkingSlot parkingSlot = parkingLot.getParkingFloors().get(floorNo - 1).getParkingSlots().get(slotNo - 1);
            parkingSlot.setFree(true);
            parkingSlot.setVehicle(null);
            vehicleHashMap.remove(ticket);
            System.out.println("Unparked vehicle with Registration Number:" + vehicle.getRegistrationNo() +
                    "and Color:" + vehicle.getColor());
        }
    }
}