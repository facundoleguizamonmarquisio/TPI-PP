import java.beans.Visibility;
import java.util.ArrayList;
import modelos.*;
import vistas.*;
import controladores.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<TipoDeUsuario> tiposUsuario = Inicializador.crearTiposDeUsuario();
        ArrayList<TipoDeCuenta> tiposCuenta = Inicializador.crearTiposDeCuenta();
        ArrayList<UsuarioUTN> usuarios = Inicializador.crearUsuariosUTN(tiposUsuario);
        ArrayList<Vehiculo> vehiculos = Inicializador.crearVehiculos();
        ArrayList<Cuenta> cuentas = Inicializador.crearCuentas(tiposCuenta, usuarios,
                vehiculos);

        // Muestra de datos
        System.out.println("=== DATOS DE PRUEBA ===");
        for (Cuenta c : cuentas) {
            System.out.println(c);
            System.out.println("----------------------");
        }

        // Vista y controlador
        VentanaPrincipal vista = new VentanaPrincipal();
        ControladorRegistro controlador = new ControladorRegistro();

        vista.setVisible(true);
    }

}
