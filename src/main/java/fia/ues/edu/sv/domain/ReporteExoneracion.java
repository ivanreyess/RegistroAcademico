package fia.ues.edu.sv.domain;

import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by ivan on 11-14-16.
 */
@Entity
@Subselect("SELECT \n" +
        "\tESTUDIANTE,\n" +
        "\tIDESTUDIANTE,\n" +
        "\tTRUNC(AVG(NOTAFINAL_MATERIA),2) AS NOTA_DE_EXONERACION,\n" +
        "\tIDMATERIA,\n" +
        "\tIDGRADO,\n" +
        "\tMATERIA AS MATERIA_EXONERADA\n" +
        "\t\n" +
        "FROM(\n" +
        "\t--NOTAS FINALES PARA CADA MATERIA DE UN ESTUDIANTE EN TODOS LOS PERIODOS QUE HA CURSADO\n" +
        "\tSELECT \n" +
        "\tGRADO,\n" +
        "\tE.IDGRADO,\t\n" +
        "\tN.IDESTUDIANTE,\n" +
        "\tNOMBREESTUDIANTE ||' '|| APELLLIDOSESTUDIANTE AS ESTUDIANTE,\n" +
        "\tNUMEROPERIODO,\n" +
        "\tN.IDPERIODO,\n" +
        "\tN.IDMATERIA,\n" +
        "\tNOMBREMATERIA  AS MATERIA,\n" +
        "\tTRUNC(SUM(CALIFICACION*PONDERACION),2) AS NOTAFINAL_MATERIA\n" +
        "\tFROM NOTA  N \n" +
        "\tJOIN ACTIVIDADES A ON A.IDACTIVIDADES=N.IDACTIVIDADES\n" +
        "\tJOIN MATERIA M ON M.IDMATERIA=N.IDMATERIA\n" +
        "\tJOIN PERIODO P ON N.IDPERIODO=P.IDPERIODO\n" +
        "\tJOIN ESTUDIANTE E ON E.IDESTUDIANTE=N.IDESTUDIANTE\n" +
        "\tJOIN GRADO G ON G.IDGRADO=E.IDGRADO\n" +
        "\tWHERE NUMEROPERIODO=1 OR NUMEROPERIODO=2 OR NUMEROPERIODO=3\n" +
        "\tGROUP BY N.IDMATERIA, N.IDPERIODO,M.NOMBREMATERIA,NUMEROPERIODO,N.IDESTUDIANTE,E.IDGRADO,NOMBREESTUDIANTE,APELLLIDOSESTUDIANTE,GRADO\n" +
        "\tORDER BY IDPERIODO,N.IDESTUDIANTE ASC\n" +
        ") A\n" +
        "---- SE RECIBE COMO PAREMTETRO POR EJEMPLO: \"PRIMER GRADO SECCION A\"\n" +
        "GROUP BY ESTUDIANTE,MATERIA,IDESTUDIANTE,IDMATERIA,IDGRADO\n" +
        "HAVING TRUNC(AVG(NOTAFINAL_MATERIA),2)>8.0\n" +
        "ORDER BY ESTUDIANTE ASC")
public class ReporteExoneracion implements java.io.Serializable{

    @EmbeddedId
    private MateriaEstudiante materiaEstudiante;
    @Column(name = "estudiante")
    private String estudiante;
    @Column(name = "nota_de_exoneracion")
    private BigDecimal nota;
    @Column(name = "materia_exonerada")
    private String materia;
    @Column(name = "idgrado")
    private int idgrado;

    public int getIdgrado() {
        return idgrado;
    }

    public void setIdgrado(int idgrado) {
        this.idgrado = idgrado;
    }

    public MateriaEstudiante getMateriaEstudiante() {
        return materiaEstudiante;
    }

    public void setMateriaEstudiante(MateriaEstudiante materiaEstudiante) {
        this.materiaEstudiante = materiaEstudiante;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
}
