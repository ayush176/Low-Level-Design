package ParkingLotDesign.enums;

import java.util.HashMap;

public enum Command {
    CREATE_PARKING_LOT("create_parking_lot"),
    DISPLAY("display"),
    PARK_VEHICLE("park_vehicle"),
    UNPARK_VEHICLE("unpark_vehicle"),
    EXIT("exit");

    private final String command;

    Command(String s) {
        command = s;
    }

    private static final HashMap<String, Command> map = new HashMap<>();

    static {
        for (Command c : values()){
            map.put(c.command,c);
        }
    }

    public static Command getCommandByValue(String s){
        return map.get(s);
    }
}
