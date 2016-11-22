package fia.ues.edu.sv.domain;

import org.hibernate.annotations.Subselect;

import javax.ejb.EJB;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by MariaJose on 20/11/2016.
 */
@Entity
@Subselect("SELECT MA.IDACTIVIDADES AS IDACTIVIDADES,MA.IDMATERIA AS IDMATERIA,NOMBREACTIVIDAD AS NOMBREACTIVIDAD," +
        "NOMBREMATERIA AS NOMBREMATERIA FROM ACTIVIDADES  A \n" +
        "JOIN MATERIA_TIENE_ACTIVIDADES MA ON A.IDACTIVIDADES=MA.IDACTIVIDADES " +
        "JOIN MATERIA M ON M.IDMATERIA=MA.IDMATERIA")
public class IngresoNota {
    @Id
    @Column(name = "idmateria")
    int idmateria;
    @Column(name = "idactividades")
    int idactividades;
    @Column(name = "nombreactividad")
    String nombreactividad;
    @Column(name = "nombremateria")
    String nombremateria;

    public String getNombremateria() {
        return nombremateria;
    }

    public void setNombremateria(String nombremateria) {
        this.nombremateria = nombremateria;
    }

    public IngresoNota(){
    }

    public int getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(int idmateria) {
        this.idmateria = idmateria;
    }

    public int getIdactividades() {
        return idactividades;
    }

    public void setIdactividades(int idactividades) {
        this.idactividades = idactividades;
    }

    public String getNombreactividad() {
        return nombreactividad;
    }

    public void setNombreactividad(String nombreactividad) {
        this.nombreactividad = nombreactividad;
    }
}
