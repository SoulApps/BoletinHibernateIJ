package EJ4;

import Utils.HibernateUtils;
import primero.Profesor;

import java.util.Iterator;
import java.util.List;

public class MainIterate {
    public static void main(String[] args) {
        /*Muestra el código y nombre de todos los profesores. Hazlo de dos maneras:
        a)Con list()
        b)Con iterate() recuperando tres registros en cada acceso a la base de datos. */
        String query = "from Profesor";
        final int FETCH_SIZE = 3;
        Iterator iterator;
        HibernateUtils.openSesionConection();
        // obtenemos el iterator
        iterator = HibernateUtils.getIterateData(query, FETCH_SIZE);
        while (iterator.hasNext()){
            Profesor prof = (Profesor) iterator.next();
            System.out.printf("Código del profesor: %s;%nNombre: %s %s;%n", prof.getCodProf(),
                    prof.getNombre(), prof.getApellidos());
            System.out.printf("-----------------------------------%n");
        }
        HibernateUtils.closeSesionConection();
    }
}
