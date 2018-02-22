package EJ3;

import Utils.HibernateUtils;
import primero.HistoricoProfesor;
import primero.Profesor;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        /* Crea en MySql una tabla de histórico de profesores y mapéala en tu proyecto. Borra el
        nuevo profesor y para no perder sus datos, almacénalo antes en el histórico. Hacerlo de dos
        maneras:
        a) Con la session
        b) Con hql */

        // ------------------- SESSION
        Date fechaAlta = new Date();
        String codProf = "BGG", newName = "Bryan Guips";
        HistoricoProfesor historicoProf;
        Profesor prof;
        String idName = "name", idId = "id";

        HibernateUtils.openSesionConection();
        // Obtenemos el profesor
        prof = HibernateUtils.loadData(Profesor.class,codProf);
        historicoProf = new HistoricoProfesor(prof.getCodProf(),prof.getNombre(),prof.getApellidos(),
                prof.getFechaAlta(),null,null);
        // Lo agregamos al histórico
        HibernateUtils.insertSession(historicoProf);
        // Borramos el profesor
        HibernateUtils.deleteData(prof);
        HibernateUtils.closeSesionConection();
    }
}
