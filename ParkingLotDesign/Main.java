package ParkingLotDesign;

import ParkingLotDesign.entities.ParkingLot;
import ParkingLotDesign.entities.Vehicle;
import ParkingLotDesign.enums.Command;
import ParkingLotDesign.enums.DisplayType;
import ParkingLotDesign.enums.VehicleType;
import ParkingLotDesign.services.ParkingLotService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParkingLotService parkingLotService = new ParkingLotService();
        while (true) {
            Scanner sc = new Scanner(System.in);
            Command command = Command.getCommandByValue(sc.next());
            switch (command) {
                case CREATE_PARKING_LOT:
                    parkingLotService.createParkingLot(new ParkingLot(sc.next(), sc.nextInt(), sc.nextInt()));
                    break;
                case DISPLAY:
                    parkingLotService.display(DisplayType.getDisplayTypeByValue(sc.next()), VehicleType.valueOf(sc.next()));
                    break;
                case PARK_VEHICLE:
                    parkingLotService.parkVehicle(VehicleType.valueOf(sc.next()),sc.next(),sc.next());
                    break;
                case UNPARK_VEHICLE:
                    parkingLotService.unParkVehicle(sc.next());
                    break;
                case EXIT:
                    return;
            }
        }
    }
}
// LINK TO THE QUESTION-- https://workat.tech/machine-coding/practice/design-parking-lot-qm6hwq4wkhp8
//    create_parking_lot PR1234 2 6
//        Created parking lot with 2 floors and 6 slots per floor
//        park_vehicle CAR KA-01-DB-1234 black
//        Parked vehicle. Ticket ID: PR1234_1_4
//        unpark_vehicle PR1234_2_5
//        display free_count CAR
//          display free_slots CAR
////        park_vehicle BIKE KA-05-HJ-8432 white
