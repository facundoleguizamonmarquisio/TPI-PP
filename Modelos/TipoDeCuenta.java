package modelos;

public class TipoDeCuenta {
    protected String nombre;
    protected String descripcion;

    public TipoDeCuenta(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public TipoDeCuenta(String nombre) {
        this.nombre = nombre;
    }

    // Setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getter
    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    // ToString
}
