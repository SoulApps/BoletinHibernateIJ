package EJ1;

import Utils.HibernateUtils;
import primero.HibernateUtil;
import primero.Profesor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*Inserta un nuevo profesor.*/
        Date fechaAlta = new Date();
        String nomProf = "GG" ,apellidos = "Llegate Ligero"
                ,codProf = "BGG";
        Profesor prof;

        prof = new Profesor(codProf,nomProf,apellidos,fechaAlta,null,null);

        HibernateUtils.openSesionConection();
        HibernateUtils.insertSession(prof);
        HibernateUtils.closeSesionConection();
        System.exit(1);
    }
}
