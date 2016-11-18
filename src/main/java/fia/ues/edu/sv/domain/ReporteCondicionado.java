package fia.ues.edu.sv.domain;

import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by ivan on 11-17-16.
 */
@Entity
@Subselect("SELECT\n" +
        "n.idestudiante AS idestudiante,\n" +
        "NOMBREESTUDIANTE,APELLLIDOSESTUDIANTE,\n" +
        "e.idgrado AS GRADO,\n" +
        "TRUNC(AVG(CALIFICACION),2) AS CALIFICACION\n" +
        "FROM NOTA N\n" +
        "JOIN ESTUDIANTE E ON N.IDESTUDIANTE=E.IDESTUDIANTE\n" +
        "AND IDMATERIA=14 -- MATERIA CONDUCTA O ACTITUD\n" +
        "GROUP BY NOMBREESTUDIANTE,APELLLIDOSESTUDIANTE,N.IDESTUDIANTE,IDMATERIA,GRADO\n" +
        "HAVING TRUNC(AVG(CALIFICACION),2)<=6.0\n" +
        "ORDER BY NOMBREESTUDIANTE||' '||APELLLIDOSESTUDIANTE ASC ")
public class ReporteCondicionado {

    @Id
    @Column(name = "idestudiante")
    int idestudiante;

    @Column(name = "nombreestudiante")
    String nombre;

    @Column(name = "apelllidosestudiante")
    String apellido;

    @Column(name = "calificacion")
    BigDecimal calificacion;

    @Column(name = "grado")
    int idgrado;

    public ReporteCondicionado() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public BigDecimal getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(BigDecimal calificacion) {
        this.calificacion = calificacion;
    }

    public int getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(int idestudiante) {
        this.idestudiante = idestudiante;
    }

    public int getIdgrado() {
        return idgrado;
    }

    public void setIdgrado(int idgrado) {
        this.idgrado = idgrado;
    }
}
