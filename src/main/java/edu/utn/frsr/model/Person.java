package edu.utn.frsr.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "people")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dni")
    private String dni;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "nacimiento")
    private Date nacimiento;

    @ManyToOne
    private Department department;

    @OneToMany(mappedBy = "person",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Device> devices = new ArrayList<>();

    public void addDevice(Device device){
        devices.add(device);
        device.setPerson(this);
    }

    public void remveDevice(Device device){
        devices.remove(device);
        device.setPerson(null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nacimiento=" + nacimiento +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id) &&
                dni.equals(person.dni) &&
                nombre.equals(person.nombre) &&
                apellido.equals(person.apellido) &&
                nacimiento.equals(person.nacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dni, nombre, apellido, nacimiento);
    }
}
