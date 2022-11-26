package org.example;

import org.example.entities.Human;
import org.example.entities.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SetupCacheMain {
    public static void main(String[] args) {
        Human valera = new Human();
        valera.setAge(50);
        valera.setName("Valera");

        Human roma = new Human();
        roma.setAge(40);
        roma.setName("Roma");

        Person valerap = new Person();
        valerap.setAge(50);
        valerap.setName("Valera");

        Person romap = new Person();
        romap.setAge(40);
        romap.setName("Roma");

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(valera);
        session.save(roma);
        session.save(romap);
        session.save(valerap);
        transaction.commit();
        session.close();
        System.exit(1);

    }
}
