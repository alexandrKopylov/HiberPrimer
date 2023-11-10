package com.app.pojo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class MappingHBN {
    public static void main(String[] args) {

        Adress adress = new Adress("City", "Street", "00111");
        Adress adress2 = new Adress("City2222", "Street2222", "001112222");

        Emplloyee emp = new Emplloyee();
        emp.setFirstName("Sasa");
        emp.setLastName("Kop");
        emp.setAge(42);

        adress.setEmplloyee(emp);
        adress2.setEmplloyee(emp);


        List<Adress> adresses = new ArrayList<>();
        adresses.add(adress);
        adresses.add(adress2);

        emp.setAdresses(adresses);








        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        // create
        Session sessionCreate = sessionFactory.openSession();
        Transaction trCreate = sessionCreate.beginTransaction();

        sessionCreate.save(adress);
        sessionCreate.save(adress2);
        sessionCreate.save(emp);

        trCreate.commit();
        sessionCreate.close();
    }
}
