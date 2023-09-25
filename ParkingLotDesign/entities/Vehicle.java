package ParkingLotDesign.entities;

import ParkingLotDesign.enums.VehicleType;

public class Vehicle {
    VehicleType vehicleType;
    String registrationNo;
    String color;
    String ticket;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Vehicle(VehicleType vehicleType, String registrationNo, String color) {
        this.vehicleType = vehicleType;
        this.registrationNo = registrationNo;
        this.color = color;
    }
}
