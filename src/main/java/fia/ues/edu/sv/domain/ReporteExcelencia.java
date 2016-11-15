package fia.ues.edu.sv.domain;

import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by ivan on 11-14-16.
 */
@Entity
@Subselect("SELECT \n" +
        "\tGRADO,\n" +
        "\tIDGRADO,\n" +
        "\tDESCRIPCIONGRADO,\n" +
        "\tTRUNC(AVG(NOTAFINAL_MATERIA),2) AS NF_TODOSPERIODOS,\n" +
        "\tIDESTUDIANTE,\n" +
        "\tNOMBREESTUDIANTE || ' ' ||APELLLIDOSESTUDIANTE AS ESTUDIANTE\n" +
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
        "GROUP BY N.IDMATERIA, N.IDPERIODO,M.NOMBREMATERIA,NUMEROPERIODO,N.IDESTUDIANTE,E.IDGRADO,NOMBREESTUDIANTE,APELLLIDOSESTUDIANTE,GRADO,DESCRIPCIONGRADO\n" +
        "ORDER BY N.IDESTUDIANTE,IDPERIODO ASC\n" +
        ") A\n" +
        "GROUP BY NOMBREESTUDIANTE||' ' ||APELLLIDOSESTUDIANTE,GRADO,IDGRADO,IDESTUDIANTE,DESCRIPCIONGRADO\n" +
        "HAVING TRUNC(AVG(NOTAFINAL_MATERIA),2) >9.0")
public class ReporteExcelencia {

    @Column(name = "grado")
    String grado;
    @Column(name = "idgrado")
    int idgrado;
    @Column(name = "descripciongrado")
    String descripciongrado;
    @Column(name = "nf_todosperiodos")
    BigDecimal nf_todosperiodos;
    @Id
    @Column(name = "idestudiante")
    int idestudiante;
    @Column(name = "estudiante")
    String estudiante;

    public ReporteExcelencia() {
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

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

    public BigDecimal getNf_todosperiodos() {
        return nf_todosperiodos;
    }

    public void setNf_todosperiodos(BigDecimal nf_todosperiodos) {
        this.nf_todosperiodos = nf_todosperiodos;
    }

    public int getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(int idestudiante) {
        this.idestudiante = idestudiante;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }
}
