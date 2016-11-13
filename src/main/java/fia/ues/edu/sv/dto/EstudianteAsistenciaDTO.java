package fia.ues.edu.sv.dto;
import java.math.BigDecimal;

/**
 * Created by ivan on 11-12-16.
 */
public class EstudianteAsistenciaDTO {

    private int idestudiante;
    private String apellidos;
    private String nombres;
    private BigDecimal notaAsistencia;


    public EstudianteAsistenciaDTO(int idestudiante, String apellidos, String nombres, BigDecimal notaAsistencia) {
        this.idestudiante = idestudiante;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.notaAsistencia = notaAsistencia;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public BigDecimal getNotaAsistencia() {
        return notaAsistencia;
    }

    public void setNotaAsistencia(BigDecimal notaAsistencia) {
        this.notaAsistencia = notaAsistencia;
    }

    public int getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(int idestudiante) {
        this.idestudiante = idestudiante;
    }

    @Override
    public String toString() {
        return "EstudianteAsistenciaDTO{" +
                "apellidos='" + apellidos + '\'' +
                ", nombres='" + nombres + '\'' +
                ", notaAsistencia=" + notaAsistencia +
                '}';
    }
}
