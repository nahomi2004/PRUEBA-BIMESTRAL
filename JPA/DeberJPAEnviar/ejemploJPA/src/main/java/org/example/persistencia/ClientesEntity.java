package org.example.persistencia;

import java.util.Collection;
import java.util.Iterator;

public class ClientesEntity {
    private int idCliente;
    private String cedula;
    private String nombres;
    private String apellidos;
    private Collection<DireccionesEntity> direccionesByIdCliente = new Collection<DireccionesEntity>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<DireccionesEntity> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(DireccionesEntity direccionesEntity) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends DireccionesEntity> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }
    };
    private Collection<EsposasEntity> esposasByIdCliente = new Collection<EsposasEntity>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<EsposasEntity> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(EsposasEntity esposasEntity) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends EsposasEntity> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }
    };

    public ClientesEntity(int idCliente, String cedula, String nombres, String apellidos) {
        this.idCliente = idCliente;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public ClientesEntity() {

    }

    public ClientesEntity(int idCliente, String cedula, String nombres, String apellidos, Collection<DireccionesEntity> direccionesByIdCliente) {
        this.idCliente = idCliente;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccionesByIdCliente = direccionesByIdCliente;
    }
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientesEntity that = (ClientesEntity) o;

        if (idCliente != that.idCliente) return false;
        if (cedula != null ? !cedula.equals(that.cedula) : that.cedula != null) return false;
        if (nombres != null ? !nombres.equals(that.nombres) : that.nombres != null) return false;
        if (apellidos != null ? !apellidos.equals(that.apellidos) : that.apellidos != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCliente;
        result = 31 * result + (cedula != null ? cedula.hashCode() : 0);
        result = 31 * result + (nombres != null ? nombres.hashCode() : 0);
        result = 31 * result + (apellidos != null ? apellidos.hashCode() : 0);
        return result;
    }

    public Collection<DireccionesEntity> getDireccionesByIdCliente() {
        return direccionesByIdCliente;
    }

    public void setDireccionesByIdCliente(Collection<DireccionesEntity> direccionesByIdCliente) {
        this.direccionesByIdCliente = direccionesByIdCliente;
    }

    public Collection<EsposasEntity> getEsposasByIdCliente() {
        return esposasByIdCliente;
    }

    public void setEsposasByIdCliente(Collection<EsposasEntity> esposasByIdCliente) {
        this.esposasByIdCliente = esposasByIdCliente;
    }

    @Override
    public String toString() {
        return "Datos Cliente\n" +
                "ID:" + idCliente +
                "\nCedula:" + cedula +
                "\nNombres:" + nombres +
                "\nApellidos:" + apellidos /*+
                "\nDirecciones:" + direccionesByIdCliente*/;
    }
}
