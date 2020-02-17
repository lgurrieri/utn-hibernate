package edu.utn.frsr.model;

import javax.persistence.*;

@Entity
@Table(name="contact_data")
public class ContactData {
    @Id
    private Long id;
    private String email;
    private String phone;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
