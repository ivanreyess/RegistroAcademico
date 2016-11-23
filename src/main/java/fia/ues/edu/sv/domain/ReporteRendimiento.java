package fia.ues.edu.sv.domain;

import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by ivan on 11-21-16.
 */
@Entity
@Subselect("SELECT \n" +
        "\tIDMATERIA,\n" +
        "\tNOMBREMATERIA,\n" +
        "\tIDGRADO,\n" +
        "\tNUMEROPERIODO,\n" +
        "\tCOUNT(CASE WHEN  NOTAFINAL_MATERIA>6.0 THEN 1 END) AS APROBADOS,\n" +
        "\tCOUNT(CASE WHEN NOTAFINAL_MATERIA<6.0 THEN 1 END) AS REPROBADOS,\n" +
        "\tCOUNT(IDMATERIA) AS TOTAL\n" +
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
        "WHERE NUMEROPERIODO=4 AND E.IDGRADO=1\n" +
        "GROUP BY N.IDMATERIA, N.IDPERIODO,M.NOMBREMATERIA,NUMEROPERIODO,N.IDESTUDIANTE,E.IDGRADO,NOMBREESTUDIANTE,APELLLIDOSESTUDIANTE,GRADO,DESCRIPCIONGRADO\n" +
        "ORDER BY IDPERIODO,N.IDESTUDIANTE ASC\n" +
        ")A\n" +
        "GROUP BY NOMBREMATERIA,IDMATERIA,IDGRADO,NUMEROPERIODO")
public class ReporteRendimiento {

    @Id
    @Column(name = "idmateria")
    private int idmateria;

    @Column(name = "nombremateria")
    private String nombremateria;

    @Column(name = "idgrado")
    private int idgrado;

    @Column(name = "numeroperiodo")
    private int numeroperiodo;

    @Column(name = "aprobados")
    private int aprobados;

    @Column(name = "reprobados")
    private int reprobados;

    @Column(name = "total")
    private int total;

    public ReporteRendimiento() {
    }

    @Override
    public String toString() {
        return "ReporteRendimiento{" +
                "idmateria=" + idmateria +
                ", nombremateria='" + nombremateria + '\'' +
                ", idgrado=" + idgrado +
                ", aprobados=" + aprobados +
                ", reprobados=" + reprobados +
                ", total=" + total +
                '}';
    }

    public int getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(int idmateria) {
        this.idmateria = idmateria;
    }

    public String getNombremateria() {
        return nombremateria;
    }

    public void setNombremateria(String nombremateria) {
        this.nombremateria = nombremateria;
    }

    public int getIdgrado() {
        return idgrado;
    }

    public void setIdgrado(int idgrado) {
        this.idgrado = idgrado;
    }

    public int getAprobados() {
        return aprobados;
    }

    public void setAprobados(int aprobados) {
        this.aprobados = aprobados;
    }

    public int getReprobados() {
        return reprobados;
    }

    public void setReprobados(int reprobados) {
        this.reprobados = reprobados;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getNumeroperiodo() {
        return numeroperiodo;
    }

    public void setNumeroperiodo(int numeroperiodo) {
        this.numeroperiodo = numeroperiodo;
    }
}
