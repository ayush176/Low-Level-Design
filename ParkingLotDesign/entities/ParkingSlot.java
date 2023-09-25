package ParkingLotDesign.entities;

import ParkingLotDesign.enums.VehicleType;

public class ParkingSlot {
    VehicleType vehicleType;
    boolean isFree;
    Vehicle vehicle;
    int floorNo;
    int slotNo;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(int slotNo) {
        this.slotNo = slotNo;
    }

    public ParkingSlot(VehicleType vehicleType, boolean isFree, int floorNo, int slotNo) {
        this.vehicleType = vehicleType;
        this.isFree = isFree;
        this.floorNo = floorNo;
        this.slotNo = slotNo;
    }
}
