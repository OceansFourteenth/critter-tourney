package dao.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class JpaUtil {

	private static final String UNIT_NAME = "critter-tourney";

	private static EntityManagerFactory entityManagerFactory;

	private static EntityManager entityManager = createEntityManager();

	private static EntityTransaction entityTransaction;

	private static EntityManager createEntityManager() {
		return createEntityManager(false);
	}

	private static EntityManager createEntityManager(boolean enableTransaction) {
		entityManagerFactory = Persistence.createEntityManagerFactory(UNIT_NAME);
		entityManager = entityManagerFactory.createEntityManager();

		if (enableTransaction)
			beginTransaction();

		return entityManager;
	}

	public static EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * 
	 * @see javax.persistence.EntityTransaction#begin()
	 */
	public static void beginTransaction() {
		entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
	}

	/**
	 * 
	 * @see javax.persistence.EntityTransaction#commit()
	 */
	public static void commit() {
		entityTransaction.commit();
	}

	/**
	 * 
	 * @see javax.persistence.EntityTransaction#rollback()
	 */
	public static void rollback() {
		entityTransaction.rollback();
	}

	public static void close() {
		entityManager.close();
		entityManagerFactory.close();
	}

}
