package EJ4;

import Utils.HibernateUtils;
import primero.HibernateUtil;
import primero.Profesor;

import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*Muestra el código y nombre de todos los profesores. Hazlo de dos maneras:
        a)Con list()
        b)Con iterate() recuperando tres registros en cada acceso a la base de datos. */
        String query = "from Profesor";
        Iterator <Profesor> iterator;
        Iterator <Profesor> iterator2;
        List<Profesor> profesorList;
        // ----------------LIST
        // Obtenemos la lista de profesores
        HibernateUtils.openSesionConection();
        profesorList = HibernateUtils.getQueryList(query);
        // obtenemos el iterator
        iterator = profesorList.iterator();
        while (iterator.hasNext()){
            Profesor prof = iterator.next();
            System.out.printf("Código del profesor: %s;%nNombre: %s %s;%n", prof.getCodProf(),
                    prof.getNombre(), prof.getApellidos());
            System.out.printf("-----------------------------------%n");
        }
        HibernateUtils.closeSesionConection();
    }
}
