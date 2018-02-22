package EJ1;

import Utils.HibernateUtils;
import primero.Profesor;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        /*Inserta un nuevo profesor.*/
        Date fechaAlta = new Date();
        String nomProf = "GGF" ,apellidos = "Llegate Ligero"
                ,codProf = "BPS";
        Profesor prof;

        prof = new Profesor(codProf,nomProf,apellidos,fechaAlta,null,null);

        HibernateUtils.openSesionConection();
        HibernateUtils.insertSession(prof);
        HibernateUtils.closeSesionConection();
        System.exit(1);
    }
}
