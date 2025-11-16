package principal;

import java.util.ArrayList;

import modelos.*;
import controladores.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<TipoDeUsuario> tiposUsuario = Inicializador.crearTiposDeUsuario();
        ArrayList<TipoDeCuenta> tiposCuenta = Inicializador.crearTiposDeCuenta();
        ArrayList<UsuarioUTN> usuarios = Inicializador.crearUsuariosUTN(tiposUsuario);
        ArrayList<Vehiculo> vehiculos = Inicializador.crearVehiculos();
        ArrayList<Cuenta> cuentas = Inicializador.crearCuentas(tiposCuenta, usuarios, vehiculos);

        ControladorPrincipal ctrlVentanaPrincipal = new ControladorPrincipal(usuarios, cuentas, vehiculos);
        ctrlVentanaPrincipal.inicializarAplicacion();
    }

}
