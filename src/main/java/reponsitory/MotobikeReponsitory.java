package reponsitory;
import java.util.List;

import model.Motobike;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import util.HibernateUtil;

public class MotobikeReponsitory {

	static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public static List<Motobike> getAllMotobike() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Query<Motobike> query = session.createQuery("FROM Motobike e");
		List<Motobike> Motobikes = query.getResultList();
		return Motobikes;
	}

	public static void addMotobike(Motobike Motobike) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(Motobike);
		session.flush();
		transaction.commit();
	}

	public static void updateMotobike(Motobike Motobike) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(Motobike);
		session.flush();
		transaction.commit();
	}

	public static void deleteMotobike(int id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Motobike Motobike = session.load(Motobike.class, id);
			session.delete(Motobike);
			session.getTransaction().commit();
			System.out.println("detete success!");
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public static Motobike findById(int id) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		Motobike Motobike = session.find(Motobike.class, id);
		return Motobike;
	}

	public static List<Motobike> getIdMotobike(int cid) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Query<Motobike> query = session.createQuery("SELECT e.Motobike FROM Category e where e.id = :cid");
		query.setParameter("cid", cid);
		List<Motobike> Motobikes = query.getResultList();
		return Motobikes;
	}

	public static List<Motobike> searchByName(String name) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Query<Motobike> query = session.createQuery("select e FROM Motobike e WHERE e.name LIKE :name");
		query.setParameter("name", "%" + name + "%");
		List<Motobike> Motobikes = query.getResultList();
		return Motobikes;
	}

}
