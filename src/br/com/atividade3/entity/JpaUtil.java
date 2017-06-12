package br.com.atividade3.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("AtividadeExtra3_JPAUtil");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	public void close(EntityManager em) {
		em.close();
	}	
}
