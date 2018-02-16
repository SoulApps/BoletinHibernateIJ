package EJ3;

import Utils.HibernateUtils;
import primero.Profesor;

import java.util.ArrayList;

public class MainHQL {
    public static void main(String[] args) {
        // ------------------- SESSION
        String codProf = "BGG", newName = "Bryan Guips";
        Profesor prof;
        String idName = "name", idId = "id";
        String hql = "UPDATE Profesor set nombre = :name WHERE id = :id";
        ArrayList<String> identifiers = new ArrayList<>();

        HibernateUtils.openSesionConection();
        prof = HibernateUtils.loadData(Profesor.class, "BLL");
        prof.setNombre("German Gines");
        HibernateUtils.updateData(prof);

        // -------------------------- hql
        identifiers.add(idName);
        identifiers.add(idId);
        HibernateUtils.updateHQL(hql,identifiers,newName,codProf);
        HibernateUtils.closeSesionConection();
    }
}
