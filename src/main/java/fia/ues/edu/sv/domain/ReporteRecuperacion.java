package fia.ues.edu.sv.domain;

import org.hibernate.annotations.Subselect;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by ivan on 11-13-16.
 */
@Entity
@Subselect("SELECT \n" +
        "\tGRADO,\n" +
        "\tDESCRIPCIONGRADO,\n" +
        "\tTRUNC(AVG(NOTAFINAL_MATERIA),2) AS NF_PERIODO_CUATRO,\n" +
        "\tNOMBREESTUDIANTE || ' ' ||APELLLIDOSESTUDIANTE AS ESTUDIANTE,\n" +
        "\tIDESTUDIANTE,\n" +
        "\tNOMBREMATERIA AS MATERIA_REPROBADA\n" +
        "\t\n" +
        "FROM (\n" +
        "--NOTAS FINALES POR GRADO Y MATERIA \n" +
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
        "WHERE NUMEROPERIODO=4\n" +
        "GROUP BY N.IDMATERIA, N.IDPERIODO,M.NOMBREMATERIA,NUMEROPERIODO,N.IDESTUDIANTE,E.IDGRADO,NOMBREESTUDIANTE,APELLLIDOSESTUDIANTE,GRADO,DESCRIPCIONGRADO\n" +
        "ORDER BY IDPERIODO,N.IDESTUDIANTE ASC\n" +
        ") A\n" +
        "GROUP BY NOMBREESTUDIANTE||' ' ||APELLLIDOSESTUDIANTE,GRADO,NOMBREMATERIA,DESCRIPCIONGRADO,IDESTUDIANTE\n" +
        "HAVING TRUNC(AVG(NOTAFINAL_MATERIA),2) <6.0")
public class ReporteRecuperacion {
    private String grado;
    private String descripciongrado;
    private BigDecimal nfPeriodoCuatro;
    private String estudiante;
    private Integer idestudiante;
    private String materiaReprobada;

    @Basic
    @Column(name = "grado")
    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReporteRecuperacion that = (ReporteRecuperacion) o;

        if (grado != null ? !grado.equals(that.grado) : that.grado != null) return false;
        if (descripciongrado != null ? !descripciongrado.equals(that.descripciongrado) : that.descripciongrado != null)
            return false;
        if (nfPeriodoCuatro != null ? !nfPeriodoCuatro.equals(that.nfPeriodoCuatro) : that.nfPeriodoCuatro != null)
            return false;
        if (estudiante != null ? !estudiante.equals(that.estudiante) : that.estudiante != null) return false;
        if (idestudiante != null ? !idestudiante.equals(that.idestudiante) : that.idestudiante != null) return false;
        if (materiaReprobada != null ? !materiaReprobada.equals(that.materiaReprobada) : that.materiaReprobada != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = grado != null ? grado.hashCode() : 0;
        result = 31 * result + (descripciongrado != null ? descripciongrado.hashCode() : 0);
        result = 31 * result + (nfPeriodoCuatro != null ? nfPeriodoCuatro.hashCode() : 0);
        result = 31 * result + (estudiante != null ? estudiante.hashCode() : 0);
        result = 31 * result + (idestudiante != null ? idestudiante.hashCode() : 0);
        result = 31 * result + (materiaReprobada != null ? materiaReprobada.hashCode() : 0);
        return result;
    }
}

