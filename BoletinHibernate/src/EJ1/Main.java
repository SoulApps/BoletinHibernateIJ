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
        String nomProf = "Baldomero" ,apellidos = "Llegate Ligero"
                ,codProf = "BLL";
        List<Object> list = new ArrayList<>();

        list.add(codProf);
        list.add(nomProf);
        list.add(apellidos);
        list.add(fechaAlta);

        HibernateUtils.openSesionConection();
        HibernateUtils.insertSession("profesor", list);
        HibernateUtils.closeSesionConection();
    }
}
