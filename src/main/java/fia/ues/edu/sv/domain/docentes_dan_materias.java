package fia.ues.edu.sv.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Monica on 23/11/2016.
 */
@Entity
@Table(name="docentes_dan_materias"
        ,schema="public"
)
public class docentes_dan_materias {
    @EmbeddedId
    private DocenteMateria docenteMateria;

    public DocenteMateria getDocenteMateria() {
        return docenteMateria;
    }

    public void setDocenteMateria(DocenteMateria docenteMateria) {
        this.docenteMateria = docenteMateria;
    }
}
