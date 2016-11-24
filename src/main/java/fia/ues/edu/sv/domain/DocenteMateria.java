package fia.ues.edu.sv.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Monica on 23/11/2016.
 */

@Embeddable
public class DocenteMateria implements java.io.Serializable {

    @Column (name = "iddocente")
    private int iddocente;
    @Column (name = "idmateria")
    private int idmateria;

    public DocenteMateria(int iddocente, int idmateria) {
        this.iddocente = iddocente;
        this.idmateria = idmateria;
    }

    public DocenteMateria(){

    }

    public int getIddocente() {
        return iddocente;
    }

    public void setIddocente(int iddocente) {
        this.iddocente = iddocente;
    }

    public int getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(int idmateria) {
        this.idmateria = idmateria;
    }
}
