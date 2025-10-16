public class TipoDeUsuario {

    private String nombre;

    public TipoDeUsuario() {
    }

    public TipoDeUsuario(String nombre) {
        this.nombre=nombre;
    }

    public void tomarNombre(String nombre) {
        this.nombre=nombre;
    }

    public String mostrarNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Tipo de usuario: " + nombre;
    }
}