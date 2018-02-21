package EJ3;

import Utils.HibernateUtils;
import primero.Profesor;

import java.util.ArrayList;

public class MainHQL {
    public static void main(String[] args) {
        String codProf = "BGG", newName = "Profe actualizado";
        Profesor prof;
        String idName = "name", idId = "id";
        String hql = "UPDATE Profesor p set p.nombre = :name WHERE p.id = :id";
        ArrayList<String> identifiers = new ArrayList<>();

        HibernateUtils.openSesionConection();
        identifiers.add(idName);
        identifiers.add(idId);
        HibernateUtils.updateHQL(hql,identifiers,newName,codProf);
        HibernateUtils.closeSesionConection();
    }
}
