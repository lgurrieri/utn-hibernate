package edu.utn.frsr.model;

public enum DeviceType {
    MOBILE_DEVICE("Mobile Phone"),
    DESKTOP_COMPUTER("Computadora de escritorio"),
    NOTEBOOK("Notebook"),
    TABLET("Tablet");

    private String name;

    private DeviceType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
