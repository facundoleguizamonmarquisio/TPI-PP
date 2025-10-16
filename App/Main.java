import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<TipoDeUsuario> tiposUsuario = Inicializador.crearTiposDeUsuario();
        ArrayList<TipoDeCuenta> tiposCuenta = Inicializador.crearTiposDeCuenta();
        ArrayList<UsuarioUTN> usuarios = Inicializador.crearUsuariosUTN(tiposUsuario);
        ArrayList<Vehiculo> vehiculos = Inicializador.crearVehiculos();
        ArrayList<Cuenta> cuentas = Inicializador.crearCuentas(tiposCuenta,usuarios,vehiculos);

        // Esto que puse aca abajo es para mostrar los datos de prueba, una vez que hagamos la vista
        // vamos a sacar esto
        System.out.println("=== DATOS DE PRUEBA ===");
        for(Cuenta c : cuentas) {
            System.out.println(c);
            System.out.println("----------------------");
        }
    }
}
