package principal;

import java.util.ArrayList;

import modelos.*;
import controladores.*;
import vistas.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<TipoDeUsuario> tiposUsuario = Inicializador.crearTiposDeUsuario();
        ArrayList<TipoDeCuenta> tiposCuenta = Inicializador.crearTiposDeCuenta();
        ArrayList<UsuarioUTN> usuarios = Inicializador.crearUsuariosUTN(tiposUsuario);
        ArrayList<Vehiculo> vehiculos = Inicializador.crearVehiculos();
        ArrayList<Cuenta> cuentas = Inicializador.crearCuentas(tiposCuenta, usuarios, vehiculos);

        System.out.println("=== DATOS DE PRUEBA ===");
        for (Cuenta c : cuentas) {
            System.out.println(c);
            System.out.println("----------------------");
        }

        VentanaPrincipal vista = new VentanaPrincipal(usuarios, cuentas);
        ControladorVentanaPrincipal controlador = new ControladorVentanaPrincipal(vista, cuentas);

        vista.setVisible(true);
    }

}
