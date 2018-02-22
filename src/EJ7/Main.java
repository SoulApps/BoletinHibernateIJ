package EJ7;

import Utils.HibernateUtils;

import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       /*7. Mostrar los datos de todas las ofertas educativas y todos los datos de sus cursos.
       Si la oferta educativa no tiene ningún curso, indicarlo. */
        String hql = "SELECT oe.codOe, oe.nombre, oe.descripcion, oe.tipo, oe.fechaLey, c.id.codCurso, " +
                "c.profesor.codProf, c.profesor.nombre, " +
                "c.profesor.apellidos FROM Ofertaeducativa oe LEFT JOIN oe.cursos c";
        List<Object> dataList;
        HibernateUtils.openSesionConection();
        dataList = HibernateUtils.getQueryList(hql);
        // Mostramos los datos
        for(int i = 0; i < dataList.size(); i++){
            Object[] result = (Object[]) dataList.get(i);
            System.out.printf("-----------------------------------------%n");
            System.out.printf("CodOE: %s%nNombre: %s%nDescripcion: %s%nTipo%s%nFecha de Ley: " +
                    "%s%nID Curso: %s%nCodigo del rofesor: %s%nNombre: %s %s%n", result[0], result[1],
            result[2],result[3],result[4],result[5],result[6],result[7],result[8]);
        }
        HibernateUtils.closeSesionConection();
    }
}
