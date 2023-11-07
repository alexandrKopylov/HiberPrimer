package com.app.pojo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class MappingHBN {
    public static void main(String[] args) {

        Adress adress = new Adress("City", "Street","00111");
        Emplloyee emp  = new Emplloyee("Sasa", "kop", 42 , adress);

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        // create
        Session sessionCreate = sessionFactory.openSession();
        Transaction trCreate = sessionCreate.beginTransaction();
        sessionCreate.save(adress);
        sessionCreate.save(emp);
        trCreate.commit();
        sessionCreate.close();
    }
}
