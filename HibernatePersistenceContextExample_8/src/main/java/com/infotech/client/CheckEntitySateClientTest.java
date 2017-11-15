package com.infotech.client;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.infotech.entities.Person;
import com.infotech.util.HibernateUtil;

public class CheckEntitySateClientTest {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			long personId = 1L;
			Person person = session.byId(Person.class).load(personId);
			
			boolean contains = session.contains(person);
			System.out.println("Is Person avaibale in hibernate context:"+contains);
			
			System.out.println("-------------------------------------------------------");
			boolean initialized = Hibernate.isInitialized(person);
			System.out.println("Is person is Initialized:"+initialized);
			
			boolean initialized2 = Hibernate.isInitialized(person.getBooks());
			System.out.println("Is list of book Initialized:"+initialized2);
			
			boolean propertyInitialized = Hibernate.isPropertyInitialized(person, "name");
			System.out.println("Is person name is Initialized:"+propertyInitialized);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
