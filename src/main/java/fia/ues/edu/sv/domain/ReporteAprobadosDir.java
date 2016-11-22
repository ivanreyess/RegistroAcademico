package fia.ues.edu.sv.domain;

import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Monica on 22/11/2016.
 */
@Entity
@Subselect("SELECT \n" +
        "\tIDGRADO,\n" +
        "\tNUMEROPERIODO,\n" +
        "\tDESCRIPCIONGRADO,\n" +
        "\tCOUNT(CASE WHEN  NOTAFINAL_MATERIA>6.0 THEN 1 END) AS APROBADOS,\n" +
        "        COUNT(NUMEROPERIODO) AS TOTAL\n" +
        "\t\n" +
        "FROM (\n" +
        "SELECT \n" +
        "\tGRADO,\n" +
        "\tDESCRIPCIONGRADO,\n" +
        "\tE.IDGRADO,\t\n" +
        "\tN.IDESTUDIANTE,\n" +
        "\tNOMBREESTUDIANTE,\n" +
        "\tAPELLLIDOSESTUDIANTE,\n" +
        "\tNUMEROPERIODO,\n" +
        "\tN.IDPERIODO,\n" +
        "\tN.IDMATERIA,\n" +
        "\tNOMBREMATERIA,\n" +
        "\tTRUNC(SUM(CALIFICACION*PONDERACION),2) AS NOTAFINAL_MATERIA\n" +
        "FROM NOTA  N \n" +
        "JOIN ACTIVIDADES A ON A.IDACTIVIDADES=N.IDACTIVIDADES\n" +
        "JOIN MATERIA M ON M.IDMATERIA=N.IDMATERIA\n" +
        "JOIN PERIODO P ON N.IDPERIODO=P.IDPERIODO\n" +
        "JOIN ESTUDIANTE E ON E.IDESTUDIANTE=N.IDESTUDIANTE\n" +
        "JOIN GRADO G ON G.IDGRADO=E.IDGRADO\n" +
        "GROUP BY N.IDMATERIA, N.IDPERIODO,M.NOMBREMATERIA,NUMEROPERIODO,N.IDESTUDIANTE,E.IDGRADO,NOMBREESTUDIANTE,APELLLIDOSESTUDIANTE,GRADO,DESCRIPCIONGRADO\n" +
        "ORDER BY IDPERIODO,N.IDESTUDIANTE ASC\n" +
        ")A\n" +
        "GROUP BY IDGRADO,DESCRIPCIONGRADO,NUMEROPERIODO\n" +
        "ORDER BY DESCRIPCIONGRADO ASC")
public class ReporteAprobadosDir implements java.io.Serializable {
    @Id
    @Column(name = "idgrado")
    private int idgrado;
    @Column(name= "numeroperiodo")
    private int numeroperiodo;
    @Column(name = "descripciongrado")
    private String descripciongrado;
    @Column(name = "aprobados")
    private int numaprobados;
    @Column(name = "total")
    private int totalalumnos;

    public int getIdgrado() {
        return idgrado;
    }

    public void setIdgrado(int idgrado) {
        this.idgrado = idgrado;
    }

    public String getDescripciongrado() {
        return descripciongrado;
    }

    public void setDescripciongrado(String descripciongrado) {
        this.descripciongrado = descripciongrado;
    }

    public int getNumaprobados() {
        return numaprobados;
    }

    public void setNumaprobados(int numaprobados) {
        this.numaprobados = numaprobados;
    }

    public int getTotalalumnos() {
        return totalalumnos;
    }

    public void setTotalalumnos(int totalalumnos) {
        this.totalalumnos = totalalumnos;
    }

    public int getNumeroperiodo() {
        return numeroperiodo;
    }

    public void setNumeroperiodo(int numeroperiodo) {
        this.numeroperiodo = numeroperiodo;
    }
}
