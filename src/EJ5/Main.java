package EJ5;

import Utils.HibernateUtils;
import primero.Asignatura;
import primero.Profesor;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*Utilizando uniqueResult(), muestra los datos de una asignatura de dos maneras:
        a)Solicitando el código y utilizando parámetros ?
        b)Solicitando el nombre y utilizando parámetros con nombre*/
        String nomAsig = "Sistemas de gestión empresarial", codAsig = "SGE";
        Asignatura asig;
        String asigName = "nomAsig";
        String hql = "from Asignatura a WHERE a.nombre = :nomAsig";
        ArrayList<String> identifiers = new ArrayList<>();

        HibernateUtils.openSesionConection();
        // -------------------------- hql
        HibernateUtils.openSesionConection();
        identifiers.add(asigName);
        asig = (Asignatura) HibernateUtils.getHQLUniqueResult(hql,identifiers, nomAsig);
        if(asig != null){
            System.out.printf("ASignatura obtenida: %s;", asig.getNombre());
        }
        HibernateUtils.closeSesionConection();
    }
}
