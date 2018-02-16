package EJ2;

// import static Utils.HibernateUtils.*;
import Utils.HibernateUtils;
import org.hibernate.query.Query;
import primero.Profesor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /* 2. Cámbiale el nombre al profesor añadido en el ejercicio anterior. Hacerlo de dos maneras:
            a) Con la session
            b) Con hql */
        // ------------------- SESSION
        String codProf = "BGG", newName = "Bryan Guips";
        Profesor prof;
        String idName = "name", idId = "id";
        String hql = "UPDATE Profesor set nombre = :name WHERE id = :id";
        ArrayList<String> identifiers = new ArrayList<>();

        HibernateUtils.openSesionConection();
        prof = HibernateUtils.loadData(Profesor.class, "BGG");
        prof.setNombre("German Gines");
        HibernateUtils.updateData(prof);

        // -------------------------- hql
        HibernateUtils.openSesionConection();
        identifiers.add(idName);
        identifiers.add(idId);
        HibernateUtils.updateHQL(hql,identifiers,newName,codProf);
        HibernateUtils.closeSesionConection();
    }
}
