public class Project {
    private String nombre;
    private String status;

    public Project(String nombre, String status) {
        this.nombre = nombre;
        this.status = status;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre +
                ", status=" + status ;
    }
@Override
    public boolean equals(Object object) {
        Project aux = (Project) object;
        if (object instanceof Project && aux.getNombre() == this.nombre) return true;
        return false;
    }



}

