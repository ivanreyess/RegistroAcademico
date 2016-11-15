package fia.ues.edu.sv.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by ivan on 11-14-16.
 */
@Embeddable
public class MateriaEstudiante implements  java.io.Serializable{
    @Column(name = "idestudiante")
    private int idestudiante;

    @Column(name = "idmateria")
    private int idmateria;

    public MateriaEstudiante(int idestudiante, int idmateria) {
        this.idestudiante = idestudiante;
        this.idmateria = idmateria;
    }

    public MateriaEstudiante(){

    }

    public int getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(int idestudiante) {
        this.idestudiante = idestudiante;
    }

    public int getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(int idmateria) {
        this.idmateria = idmateria;
    }
}
