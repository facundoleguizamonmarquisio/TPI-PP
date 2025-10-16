public class TipoDeCuenta {
    protected String nombre;
    protected String descripcion;

    public TipoDeCuenta() {
    }

    public TipoDeCuenta(String nombre,String descripcion) {
        this.nombre=nombre;
        this.descripcion=descripcion;
    }

    public void tomarNombre(String nombre) {
        this.nombre=nombre;
    }

    public void tomarDescripcion(String descripcion) {
        this.descripcion=descripcion;
    }

    public String mostrarNombre() {
        return nombre;
    }

    public String mostrarDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre+
               "\nDescripción: "+descripcion;
    }
}

