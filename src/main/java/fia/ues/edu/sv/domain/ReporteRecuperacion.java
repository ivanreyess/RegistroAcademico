package fia.ues.edu.sv.domain;

import org.hibernate.annotations.Subselect;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by ivan on 11-13-16.
 */
@Entity
@Subselect("SELECT  \n" +
        "\n" +
        "\tIDGRADO,\n" +
        "\n" +
        "\tDESCRIPCIONGRADO,\n" +
        "\n" +
        "\tTRUNC(AVG(NOTAFINAL_MATERIA),2) AS NF_PERIODO_CUATRO,\n" +
        "\n" +
        "\tNOMBREESTUDIANTE || ' ' ||APELLLIDOSESTUDIANTE AS ESTUDIANTE,\n" +
        "\n" +
        "\tIDESTUDIANTE,\n" +
        "\n" +
        "\tNOMBREMATERIA AS MATERIA_REPROBADA\n" +
        "\n" +
        "\t\n" +
        "\n" +
        "FROM (\n" +
        "\n" +
        "--NOTAS FINALES POR GRADO Y MATERIA \n" +
        "\n" +
        "SELECT \n" +
        "\n" +
        "\tGRADO,\n" +
        "\n" +
        "\tDESCRIPCIONGRADO,\n" +
        "\n" +
        "\tE.IDGRADO,\t\n" +
        "\n" +
        "\tN.IDESTUDIANTE,\n" +
        "\n" +
        "\tNOMBREESTUDIANTE,\n" +
        "\n" +
        "\tAPELLLIDOSESTUDIANTE,\n" +
        "\n" +
        "\tNUMEROPERIODO,\n" +
        "\n" +
        "\tN.IDPERIODO,\n" +
        "\n" +
        "\tN.IDMATERIA,\n" +
        "\n" +
        "\tNOMBREMATERIA,\n" +
        "\n" +
        "\tTRUNC(SUM(CALIFICACION*PONDERACION),2) AS NOTAFINAL_MATERIA\n" +
        "\n" +
        "FROM NOTA  N \n" +
        "\n" +
        "JOIN ACTIVIDADES A ON A.IDACTIVIDADES=N.IDACTIVIDADES\n" +
        "\n" +
        "JOIN MATERIA M ON M.IDMATERIA=N.IDMATERIA\n" +
        "\n" +
        "JOIN PERIODO P ON N.IDPERIODO=P.IDPERIODO\n" +
        "\n" +
        "JOIN ESTUDIANTE E ON E.IDESTUDIANTE=N.IDESTUDIANTE\n" +
        "\n" +
        "JOIN GRADO G ON G.IDGRADO=E.IDGRADO\n" +
        "\n" +
        "WHERE NUMEROPERIODO=4\n" +
        "\n" +
        "GROUP BY N.IDMATERIA, N.IDPERIODO,M.NOMBREMATERIA,NUMEROPERIODO,N.IDESTUDIANTE,E.IDGRADO,NOMBREESTUDIANTE,APELLLIDOSESTUDIANTE,GRADO,DESCRIPCIONGRADO\n" +
        "\n" +
        "ORDER BY IDPERIODO,N.IDESTUDIANTE ASC\n" +
        "\n" +
        ") A\n" +
        "\n" +
        "GROUP BY NOMBREESTUDIANTE||' ' ||APELLLIDOSESTUDIANTE,IDGRADO,NOMBREMATERIA,DESCRIPCIONGRADO,IDESTUDIANTE\n" +
        "\n" +
        "HAVING TRUNC(AVG(NOTAFINAL_MATERIA),2) <6.0")
public class ReporteRecuperacion {
    private int grado;
    private String descripciongrado;
    private BigDecimal nfPeriodoCuatro;
    private String estudiante;
    private Integer idestudiante;
    private String materiaReprobada;

    @Basic
    @Column(name = "idgrado")
    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    @Basic
    @Column(name = "descripciongrado")
    public String getDescripciongrado() {
        return descripciongrado;
    }

    public void setDescripciongrado(String descripciongrado) {
        this.descripciongrado = descripciongrado;
    }

    @Basic
    @Column(name = "nf_periodo_cuatro")
    public BigDecimal getNfPeriodoCuatro() {
        return nfPeriodoCuatro;
    }

    public void setNfPeriodoCuatro(BigDecimal nfPeriodoCuatro) {
        this.nfPeriodoCuatro = nfPeriodoCuatro;
    }

    @Basic
    @Column(name = "estudiante")
    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    @Id
    @Basic
    @Column(name = "idestudiante")
    public Integer getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(Integer idestudiante) {
        this.idestudiante = idestudiante;
    }

    @Basic
    @Column(name = "materia_reprobada")
    public String getMateriaReprobada() {
        return materiaReprobada;
    }

    public void setMateriaReprobada(String materiaReprobada) {
        this.materiaReprobada = materiaReprobada;
    }




}

