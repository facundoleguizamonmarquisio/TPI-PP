package principal;

import java.util.ArrayList;

import org.jpl7.Query;

import controladores.*;
import modelos.*;

public class Main {
    public static void main(String[] args) {

        PrologConfig.inicializar();

        Query q1 = new Query("consult('src/prolog/base.pl')");
        System.out.println("Consult: " + (q1.hasSolution() ? "OK" : "ERROR"));

        Query q2 = new Query("numero(X)");
        System.out.println("Primer número: " + q2.oneSolution().get("X"));

        Query q3 = new Query("saludo(S)");
        System.out.println("Mensaje: " + q3.oneSolution().get("S"));

        ArrayList<TipoDeUsuario> tiposUsuario = Inicializador.crearTiposDeUsuario();
        ArrayList<TipoDeCuenta> tiposCuenta = Inicializador.crearTiposDeCuenta();
        ArrayList<UsuarioUTN> usuarios = Inicializador.crearUsuariosUTN(tiposUsuario);
        ArrayList<Vehiculo> vehiculos = Inicializador.crearVehiculos();
        ArrayList<Cuenta> cuentas = Inicializador.crearCuentas(tiposCuenta, usuarios, vehiculos);

        ControladorPrincipal ctrlVentanaPrincipal = new ControladorPrincipal(usuarios, cuentas, vehiculos);
        ctrlVentanaPrincipal.inicializarAplicacion();
    }

}
