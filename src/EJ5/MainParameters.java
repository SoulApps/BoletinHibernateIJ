package EJ5;

import Utils.HibernateUtils;
import primero.Asignatura;

import java.util.ArrayList;

public class MainParameters {
    public static void main(String[] args) {
        /*Utilizando uniqueResult(), muestra los datos de una asignatura de dos maneras:
        a)Solicitando el código y utilizando parámetros ?
        b)Solicitando el nombre y utilizando parámetros con nombre*/
        String nomAsig = "Sistemas de gestión empresarial", codAsig = "SGE";
        Asignatura asig;
        String asigName = "nomAsig";
        String hql = "from Asignatura a WHERE a.nombre = ?";
        ArrayList<String> identifiers = new ArrayList<>();

        HibernateUtils.openSesionConection();
        // -------------------------- hql
        HibernateUtils.openSesionConection();
        asig = (Asignatura) HibernateUtils.getHQLUniqueResultParams(hql, nomAsig);
        if(asig != null){
            System.out.printf("ASignatura obtenida: %s;", asig.getNombre());
        }
        HibernateUtils.closeSesionConection();
    }
}
