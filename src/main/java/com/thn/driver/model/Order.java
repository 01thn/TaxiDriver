package com.thn.driver.model;

public class Order {
    private Integer id;
    private String placeFrom;
    private String placeTo;
    private boolean isActive;
    private String clientName;
    private Integer driverId;

    public Order(Integer id, String placeFrom, String placeTo, boolean isActive, String clientName) {
        this.id = id;
        this.placeFrom = placeFrom;
        this.placeTo = placeTo;
        this.isActive = isActive;
        this.clientName = clientName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaceFrom() {
        return placeFrom;
    }

    public void setPlaceFrom(String placeFrom) {
        this.placeFrom = placeFrom;
    }

    public String getPlaceTo() {
        return placeTo;
    }

    public void setPlaceTo(String placeTo) {
        this.placeTo = placeTo;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", placeFrom='" + placeFrom + '\'' +
                ", placeTo='" + placeTo + '\'' +
                ", isActive=" + isActive +
                ", clientName='" + clientName + '\'' +
                ", driverId=" + driverId +
                '}';
    }
}
