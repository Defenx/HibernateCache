package org.example;

import org.example.entities.Human;
import org.example.entities.Person;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;


public class TestHibernateCache {

	public static void main(String[] args) {
		
//		SessionFactory factory = HibernateUtil.getSessionFactory();
//		Session session1 = factory.openSession();
//		session1.beginTransaction();
//
//		session1.get(Human.class, 1);
//
//
//		session1.getTransaction().commit();
//		session1.close();

//		Session session2 = factory.openSession();
//		session2.beginTransaction();
//
//		session2.get(Human.class, 1);
//		session2.getTransaction().commit();
//		session2.close();
//		factory.close();


//		SessionFactory factory = HibernateUtil.getSessionFactory();
//		Session session1 = factory.openSession();
//		session1.beginTransaction();
//
//		session1.get(Person.class, 1);
//		session1.getTransaction().commit();
//		session1.close();
//
//		Session session2 = factory.openSession();
//		session2.beginTransaction();
//
//		session2.get(Person.class, 1);
//		session2.getTransaction().commit();
//		session2.close();
//		factory.close();


		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session1 = factory.openSession();
		session1.beginTransaction();

		Query<Human> query1 = session1.createQuery("SELECT h FROM Human h WHERE name = :name",
				Human.class);
		query1.setParameter("name", "Roma");
		query1.setHint("org.hibernate.cacheable", true);
		List<Human> name1 = query1.getResultList();
		System.out.println(name1);
		session1.close();

		Session session2 = factory.openSession();
		session2.beginTransaction();

		Query<Human> query2 = session2.createQuery("SELECT h FROM Human h WHERE name = :name",
				Human.class);
		query2.setParameter("name", "Roma");
		query2.setHint("org.hibernate.cacheable", true);
		List<Human> name2 = query2.getResultList();
		System.out.println(name2);
		session2.getTransaction().commit();
		session2.close();
		factory.close();
	}

}
