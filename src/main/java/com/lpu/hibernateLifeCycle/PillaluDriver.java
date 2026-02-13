package com.lpu.hibernateLifeCycle;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PillaluDriver {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Pillalu p = new Pillalu();
		//p.setId(12);
		//p.setName("Donkey");

		et.begin();
		//em.persist(p);  //Persistent
		em.detach(p);
		//em.merge(p);
		em.remove(p);   //remove called after detach, so wont work
		et.commit();
	}
}
