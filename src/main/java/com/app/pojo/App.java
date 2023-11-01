package com.app.pojo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class App {
    public static void main(String[] args) {
        Student bob = new Student();
        bob.setName("Bob");
        bob.setAge(10);

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

       // create
        Session sessionCreate = sessionFactory.openSession();
        Transaction trCreate = sessionCreate.beginTransaction();
        sessionCreate.save(bob);
        trCreate.commit();
        sessionCreate.close();

        // Read
        Session sessionRead= sessionFactory.openSession();
        Transaction trRead = sessionRead.beginTransaction();

        Student stud = sessionRead.find(Student.class, 1);
        System.out.println(stud);

        trRead.commit();
        sessionRead.close();

        // Update
        Session sessionUpdate= sessionFactory.openSession();
        Transaction trUpdate = sessionUpdate.beginTransaction();

        Student stud2 = sessionUpdate.find(Student.class, 1);
        stud2.setName("Vaflya");
        stud2.setAge(33);
        sessionUpdate.update(stud2);

        trUpdate.commit();
        sessionUpdate.close();

        //Delete
        Session sessionDelete= sessionFactory.openSession();
        Transaction trDelete = sessionDelete.beginTransaction();


        sessionDelete.delete(stud2);

        trDelete.commit();
        sessionDelete.close();

    }
}