package EJ3;

import Utils.HibernateUtils;
import primero.Profesor;

import java.util.ArrayList;

public class MainHQL {
    public static void main(String[] args) {
        String codProf = "BGG", newName = "Profe actualizado";
        Profesor prof, result;
        String idName = "name", idId = "id", codProfId = "codProf";
        String hql = "UPDATE Profesor p set p.nombre = :name WHERE p.id = :id";
        String hqlInsert = "INSERT INTO HistoricoProfesor(codProf, nombre, apellidos, fechaAlta)" +
                " SELECT codProf, nombre, apellidos, fechaAlta FROM Profesor WHERE codProf = :codProf";
        String deleteHQL = "DELETE from Profesor where codProf = :codProf";
        ArrayList<String> identifiers = new ArrayList<>();
        // todo end
        HibernateUtils.openSesionConection();
        identifiers.add(idName);
        identifiers.add(idId);
        HibernateUtils.updateHQL(hql,identifiers,newName,codProf);

        identifiers.clear();
        identifiers.add(codProfId);

        HibernateUtils.updateHQL(hqlInsert, identifiers, codProf);
        HibernateUtils.updateHQL(deleteHQL, identifiers, codProf);
        HibernateUtils.closeSesionConection();
    }
}
