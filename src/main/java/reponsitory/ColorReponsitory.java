package reponsitory;
import model.MotobikeColor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class ColorReponsitory {

    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static List<MotobikeColor> getAllColor(){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Query<MotobikeColor> query = session.createQuery("FROM MotobikeColor ", MotobikeColor.class);
        List<MotobikeColor> color = query.getResultList();
        return color;
    }
}
