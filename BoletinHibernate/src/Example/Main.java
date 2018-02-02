package Example;

import java.sql.Date;
import java.util.logging.Level;

import hibernateUtils.Asignatura;
import hibernateUtils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {

    public static void main(String[] args) {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        // obtener la sesion actual
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        // crear la sesion
        Session session = sesion.openSession();
        // crear una transaccion de la sesion
        Transaction tx = session.beginTransaction();

        System.out.println("Inserto una fila en la tabla asignatura");

        Asignatura asig = new Asignatura();
        asig.setCodAsig("CJPK");
        asig.setNombre("Carmen es la mejor4");

        session.save(asig);
        tx.commit();
        session.close();
        System.exit(0);


    }

}

