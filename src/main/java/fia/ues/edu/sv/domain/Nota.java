package fia.ues.edu.sv.domain;
// Generated 09-nov-2016 0:58:20 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Nota generated by hbm2java
 */
@Entity
@Table(name="nota"
    ,schema="public"
)
public class Nota  implements java.io.Serializable {


     private int idnota;
     private Actividades actividades;
     private Estudiante estudiante;
     private Materia materia;
     private Periodo periodo;
     private BigDecimal calificacion;

    public Nota() {
    }

	
    public Nota(int idnota) {
        this.idnota = idnota;
    }
    public Nota(int idnota, Actividades actividades, Estudiante estudiante, Materia materia, Periodo periodo, BigDecimal calificacion) {
       this.idnota = idnota;
       this.actividades = actividades;
       this.estudiante = estudiante;
       this.materia = materia;
       this.periodo = periodo;
       this.calificacion = calificacion;
    }
   
     @Id 

    
    @Column(name="idnota", unique=true, nullable=false)
    public int getIdnota() {
        return this.idnota;
    }
    
    public void setIdnota(int idnota) {
        this.idnota = idnota;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idactividades")
    public Actividades getActividades() {
        return this.actividades;
    }
    
    public void setActividades(Actividades actividades) {
        this.actividades = actividades;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idestudiante")
    public Estudiante getEstudiante() {
        return this.estudiante;
    }
    
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idmateria")
    public Materia getMateria() {
        return this.materia;
    }
    
    public void setMateria(Materia materia) {
        this.materia = materia;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idperiodo")
    public Periodo getPeriodo() {
        return this.periodo;
    }
    
    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    
    @Column(name="calificacion", precision=4)
    public BigDecimal getCalificacion() {
        return this.calificacion;
    }
    
    public void setCalificacion(BigDecimal calificacion) {
        this.calificacion = calificacion;
    }




}


