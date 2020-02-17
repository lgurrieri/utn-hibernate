package edu.utn.frsr.model;

import javax.persistence.*;

@Entity
public class Device {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;

    private String catalogName;

    @Enumerated(EnumType.ORDINAL)
    private DeviceType deviceType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", catalogName='" + catalogName + '\'' +
                ", deviceType=" + deviceType +
                '}';
    }
}
