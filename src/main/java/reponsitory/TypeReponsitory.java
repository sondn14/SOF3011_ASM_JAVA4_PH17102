package reponsitory;
import model.MotobikeType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import util.HibernateUtil;
import java.util.List;

public class TypeReponsitory {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static List<MotobikeType> getAllType(){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Query<MotobikeType> query = session.createQuery("FROM MotobikeType ", MotobikeType.class);
        List<MotobikeType> type = query.getResultList();
        return type;
    }
}
