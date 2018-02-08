package Utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import primero.HibernateUtil;
import primero.Profesor;

import java.util.Date;
import java.util.List;

public class HibernateUtils {
    private static SessionFactory sessionFactory;
    private static Session session;
    private HibernateUtils() {
    }

    public static void openSesionConection(){
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
    }

    public static void insertSession(String type, List<Object> data){
        Transaction transaction = session.beginTransaction();
        switch (type){
            case "profesor":
               Profesor prof = new Profesor();
               prof.setCodProf(data.get(0).toString());
               prof.setNombre(data.get(1).toString());
               prof.setApellidos(data.get(2).toString());
               prof.setFechaAlta((Date)data.get(3));
               session.save(prof);
               break;
        }
        transaction.commit();
    }

    public static void closeSesionConection(){
        session.close();
    }
}
