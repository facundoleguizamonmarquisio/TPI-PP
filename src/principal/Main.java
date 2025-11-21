package principal;

import java.util.ArrayList;

import controladores.*;
import modelos.*;
import utilidades.ConocimientoVehiculo;

public class Main {
    public static void main(String[] args) {
        ArrayList<TipoDeUsuario> tiposUsuario = Inicializador.crearTiposDeUsuario();
        ArrayList<TipoDeCuenta> tiposCuenta = Inicializador.crearTiposDeCuenta();
        ArrayList<UsuarioUTN> usuarios = Inicializador.crearUsuariosUTN(tiposUsuario);
        ArrayList<Vehiculo> vehiculos = Inicializador.crearVehiculos();
        ArrayList<Cuenta> cuentas = Inicializador.crearCuentas(tiposCuenta, usuarios, vehiculos);
        ConocimientoVehiculo conocimientoVehiculo = Inicializador.crearConocimientoVehiculo(cuentas);

        ControladorPrincipal ctrlVentanaPrincipal = new ControladorPrincipal(usuarios, cuentas, vehiculos,
                conocimientoVehiculo);
        ctrlVentanaPrincipal.inicializarAplicacion();
    }

}
