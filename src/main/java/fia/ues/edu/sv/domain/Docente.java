package fia.ues.edu.sv.domain;
// Generated 09-nov-2016 0:58:20 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Docente generated by hbm2java
 */
@Entity
@Table(name="docente"
    ,schema="public"
)
public class Docente  implements java.io.Serializable {


     private int iddocente;
     private Usuario usuario;
     private String nombredocente;
     private String apellidodocente;
     private Set<Materia> materias = new HashSet<Materia>(0);
     private Set<Grado> grados = new HashSet<Grado>(0);

    public Docente() {
    }

	
    public Docente(int iddocente) {
        this.iddocente = iddocente;
    }
    public Docente(int iddocente, Usuario usuario, String nombredocente, String apellidodocente, Set<Materia> materias, Set<Grado> grados) {
       this.iddocente = iddocente;
       this.usuario = usuario;
       this.nombredocente = nombredocente;
       this.apellidodocente = apellidodocente;
       this.materias = materias;
       this.grados = grados;
    }
   
     @Id 

    
    @Column(name="iddocente", unique=true, nullable=false)
    public int getIddocente() {
        return this.iddocente;
    }
    
    public void setIddocente(int iddocente) {
        this.iddocente = iddocente;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idusuario")
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    @Column(name="nombredocente", length=50)
    public String getNombredocente() {
        return this.nombredocente;
    }
    
    public void setNombredocente(String nombredocente) {
        this.nombredocente = nombredocente;
    }

    
    @Column(name="apellidodocente", length=50)
    public String getApellidodocente() {
        return this.apellidodocente;
    }
    
    public void setApellidodocente(String apellidodocente) {
        this.apellidodocente = apellidodocente;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="docentes_dan_materias", schema="public", joinColumns = { 
        @JoinColumn(name="iddocente", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="idmateria", nullable=false, updatable=false) })
    public Set<Materia> getMaterias() {
        return this.materias;
    }
    
    public void setMaterias(Set<Materia> materias) {
        this.materias = materias;
    }

@ManyToMany(fetch=FetchType.LAZY, mappedBy="docentes")
    public Set<Grado> getGrados() {
        return this.grados;
    }
    
    public void setGrados(Set<Grado> grados) {
        this.grados = grados;
    }




}

