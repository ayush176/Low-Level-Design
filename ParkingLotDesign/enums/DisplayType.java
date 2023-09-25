package ParkingLotDesign.enums;

import java.util.HashMap;

public enum DisplayType {
    FREE_COUNT("free_count"),
    FREE_SLOTS("free_slots"),
    OCCUPIED_SLOTS("occupied_slots");

    private final String display;

    DisplayType(String s) {
        display = s;
    }

    private static final HashMap<String,DisplayType> map = new HashMap<>();

    static {
        for (DisplayType displayType : values()){
            map.put(displayType.display,displayType);
        }
    }

    public static DisplayType getDisplayTypeByValue(String s) {
        return map.get(s);
    }

}