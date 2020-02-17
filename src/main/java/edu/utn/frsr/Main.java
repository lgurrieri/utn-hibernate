package edu.utn.frsr;

import edu.utn.frsr.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.time.LocalDate;

public class Main {

    public static void  bootStrap(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("utn-persistence-unit");


        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Device phone01 = new Device();
        phone01.setCatalogName("MP-01");
        phone01.setDeviceType(DeviceType.MOBILE_DEVICE);
        phone01.setSerialNumber("012688889999");

        Device pc01 = new Device();
        pc01.setCatalogName("PC-01");
        pc01.setDeviceType(DeviceType.DESKTOP_COMPUTER);
        pc01.setSerialNumber("298443387654");

        Person juan = new Person();
        juan.setDni("32987999");
        juan.setNombre("Juan");
        juan.setApellido("Perez");
        juan.setNacimiento(Date.valueOf(LocalDate.of(1996, 6, 25)));
        ContactData contactoJuan = new ContactData();
        contactoJuan.setEmail("jperez@mail.com");
        contactoJuan.setPhone("2604555678");
        contactoJuan.setPerson(juan);
        Department recruiting = new Department();
        recruiting.setName("Recruiting");
        entityManager.persist(recruiting);
        juan.setDepartment(recruiting);
        juan.addDevice(phone01);
        juan.addDevice(pc01);
        entityManager.persist(contactoJuan);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


    public static void getDevice(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("utn-persistence-unit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        //Device mobilePhone = entityManager.find(Device.class, 1L);
        Device mobilePhone = entityManager.createQuery(
                "SELECT d FROM Device d join fetch d.person WHERE d.id=:id",
                Device.class)
                .setParameter("id", 1L).getSingleResult();
        Person p = mobilePhone.getPerson();
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(mobilePhone);
        System.out.println(p);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hibernate");
        if(args[0].equals("bootstrap")){
            bootStrap();
        }else{
            getDevice();
        }


    }
}
