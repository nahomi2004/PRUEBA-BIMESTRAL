package org.example.entidadesPersistencia;

public class MatriculaEntity {
    private int idMat;
    private String carrera;
    private Integer ciclo;
    private String anio;
    private int estudianteIdEstudiante;
    private EstudianteEntity estudianteByEstudianteIdEstudiante;

    public int getIdMat() {
        return idMat;
    }

    public void setIdMat(int idMat) {
        this.idMat = idMat;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Integer getCiclo() {
        return ciclo;
    }

    public void setCiclo(Integer ciclo) {
        this.ciclo = ciclo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public int getEstudianteIdEstudiante() {
        return estudianteIdEstudiante;
    }

    public void setEstudianteIdEstudiante(int estudianteIdEstudiante) {
        this.estudianteIdEstudiante = estudianteIdEstudiante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MatriculaEntity that = (MatriculaEntity) o;

        if (idMat != that.idMat) return false;
        if (estudianteIdEstudiante != that.estudianteIdEstudiante) return false;
        if (carrera != null ? !carrera.equals(that.carrera) : that.carrera != null) return false;
        if (ciclo != null ? !ciclo.equals(that.ciclo) : that.ciclo != null) return false;
        if (anio != null ? !anio.equals(that.anio) : that.anio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMat;
        result = 31 * result + (carrera != null ? carrera.hashCode() : 0);
        result = 31 * result + (ciclo != null ? ciclo.hashCode() : 0);
        result = 31 * result + (anio != null ? anio.hashCode() : 0);
        result = 31 * result + estudianteIdEstudiante;
        return result;
    }

    public EstudianteEntity getEstudianteByEstudianteIdEstudiante() {
        return estudianteByEstudianteIdEstudiante;
    }

    public void setEstudianteByEstudianteIdEstudiante(EstudianteEntity estudianteByEstudianteIdEstudiante) {
        this.estudianteByEstudianteIdEstudiante = estudianteByEstudianteIdEstudiante;
    }
}
