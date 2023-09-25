package ParkingLotDesign.repositories;

import ParkingLotDesign.entities.ParkingFloor;
import ParkingLotDesign.entities.ParkingSlot;
import ParkingLotDesign.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingDataRepository {
    List<ParkingSlot> parkingSlotData;
    List<ParkingFloor> parkingFloors;

    public List<ParkingFloor> initializeFloor(int noOfFloors, int noOfSlotsPerFloor){
        parkingFloors = new ArrayList<>();
        parkingSlotData = new ArrayList<>();
        for (int i=0;i<noOfFloors;i++){
            initializeParkingSlot(i,noOfSlotsPerFloor);
            ParkingFloor parkingFloor = new ParkingFloor(getAllParkingSlotsOfFloorNo(i));
            parkingFloors.add(parkingFloor);
        }
        return parkingFloors;
    }

    public void initializeParkingSlot(int floorNo,int noOfSlots){
        for(int i=0;i<noOfSlots;i++){
            if(i==0){
                parkingSlotData.add(new ParkingSlot(VehicleType.TRUCK,true,floorNo,i));
            } else if (i<3) {
                parkingSlotData.add(new ParkingSlot(VehicleType.BIKE,true,floorNo,i));
            } else {
                parkingSlotData.add(new ParkingSlot(VehicleType.CAR,true,floorNo,i));
            }
        }
    }

    private List<ParkingSlot> getAllParkingSlotsOfFloorNo(int floorNo){
        return parkingSlotData.stream().filter(parkingSlot -> parkingSlot.getFloorNo()==floorNo).collect(Collectors.toList());
    }
}
