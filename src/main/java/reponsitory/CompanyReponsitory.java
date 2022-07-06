package reponsitory;
import model.MotobikeCompany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class CompanyReponsitory {

    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static List<MotobikeCompany> getAllCompany(){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Query<MotobikeCompany> query = session.createQuery("FROM MotobikeCompany ", MotobikeCompany.class);
        List<MotobikeCompany> categorys = query.getResultList();
        return categorys;
    }
    public static void addCategory(MotobikeCompany motobikeCompany) {
        SessionFactory factory = util.HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(motobikeCompany);
        transaction.commit();
    }
    public static void updateCategory(MotobikeCompany motobikeCompany) {
        SessionFactory factory = util.HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(motobikeCompany);
        transaction.commit();
    }
    public static void deleteCategory(int id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            MotobikeCompany lsp = session.load(MotobikeCompany.class, id) ;
            session.delete(lsp);
            session.getTransaction().commit();
            System.out.println("detete success!");
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public static MotobikeCompany findById(int id) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tran = session.beginTransaction();
        MotobikeCompany category = session.find(MotobikeCompany.class, id);
        System.out.println(category);
        return category;
    }

}
