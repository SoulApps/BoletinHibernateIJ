package EJ6;

import Utils.HibernateUtils;
import primero.Asignatura;
import primero.Profesor;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        /* Muestra aquellas asignaturas que tengan 3,4 ó 6 horas semanales. Utilizar setParameterList.*/
        String hql = "from Asignatura a WHERE a.horasSemanales IN (:hoursList) ORDER BY a.nombre";
        String hourList = "hoursList";
        Iterator iterator;
        ArrayList<Byte> hours = new ArrayList<>();
        ArrayList<String> parameters = new ArrayList<>();
        ArrayList<Asignatura> asigList;
        HibernateUtils.openSesionConection();
        // -------------------------- hql
        HibernateUtils.openSesionConection();
        parameters.add(hourList);
        hours.add((byte) 3);
        hours.add((byte) 4);
        hours.add((byte) 6);
        iterator = HibernateUtils.getHQLParameterList(hql, parameters, hours);

        while (iterator.hasNext()) {
            Asignatura asig = (Asignatura) iterator.next();
            System.out.printf("Código de la asignatura: %s;%nNombre %s;%n" +
                            "Horas semanales: %s;%n Horas totales: %s;%n", asig.getCodAsig(),
                    asig.getNombre(), asig.getHorasSemanales(), asig.getHorasTotales());
            System.out.printf("-----------------------------------%n");
        }

        HibernateUtils.closeSesionConection();
    }
}
