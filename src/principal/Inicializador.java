package principal;

import java.util.ArrayList;

import controladores.*;
import modelos.*;
import utilidades.ConocimientoVehiculo;
import vistas.*;

import java.util.ArrayList;

public class Inicializador {

    public static ArrayList<TipoDeUsuario> crearTiposDeUsuario() {
        ArrayList<TipoDeUsuario> tipos = new ArrayList<>();
        tipos.add(new TipoDeUsuario("Profesor"));
        tipos.add(new TipoDeUsuario("Estudiante"));
        tipos.add(new TipoDeUsuario("Operativo"));
        tipos.add(new TipoDeUsuario("Graduado"));
        return tipos;
    }

    public static ArrayList<TipoDeCuenta> crearTiposDeCuenta() {
        ArrayList<TipoDeCuenta> tiposCuenta = new ArrayList<>();
        tiposCuenta.add(new TipoDeCuenta("Saldo", "Cuenta con saldo disponible"));
        tiposCuenta.add(new TipoDeCuenta("Abono", "Cuenta de tipo abono mensual"));
        return tiposCuenta;
    }

    public static ArrayList<UsuarioUTN> crearUsuariosUTN(ArrayList<TipoDeUsuario> tiposUsuario) {
        ArrayList<UsuarioUTN> usuarios = new ArrayList<>();
        usuarios.add(new UsuarioUTN("Juan", "Pérez", "12355455", "Calle 1", "Ciudad A", "01/01/1980", "1111111111",
                "juan@mail.com", tiposUsuario.get(0), 11300));
        usuarios.add(new UsuarioUTN("María", "González", "87654321", "Calle 2", "Ciudad B", "05/05/1990", "2222222222",
                "maria@mail.com", tiposUsuario.get(1), 13000));
        usuarios.add(new UsuarioUTN("Carlos", "Ramírez", "11223344", "Calle 3", "Ciudad C", "10/10/1985", "3333333333",
                "carlos@mail.com", tiposUsuario.get(2), 7000));
        usuarios.add(new UsuarioUTN("Lucía", "Fernández", "44332211", "Calle 4", "Ciudad D", "15/12/1995", "4444444444",
                "lucia@mail.com", tiposUsuario.get(3), 14000));
        usuarios.add(new UsuarioUTN("Milagros", "Mondaca", "47322454", "Avenida siempre viva", "Villa maria",
                "23/06/2006", "4444444444",
                "miliMon@gmail.com", tiposUsuario.get(1), 17122));
        return usuarios;
    }

    public static ArrayList<Vehiculo> crearVehiculos() {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Toyota", "Corolla", "ABC123", "Rojo"));
        vehiculos.add(new Vehiculo("Honda", "Civic", "DEF456", "Azul"));
        vehiculos.add(new Vehiculo("Ford", "Focus", "GHI789", "Negro"));
        vehiculos.add(new Vehiculo("Chevrolet", "Cruze", "JKL012", "Blanco"));
        vehiculos.add(new Vehiculo("Volkswagen", "Golf", "MNO345", "Gris"));
        vehiculos.add(new Vehiculo("Renault", "Megane", "PQR678", "Verde"));
        return vehiculos;
    }

    public static ArrayList<Cuenta> crearCuentas(ArrayList<TipoDeCuenta> tiposCuenta, ArrayList<UsuarioUTN> usuarios,
            ArrayList<Vehiculo> vehiculos) {
        ArrayList<Cuenta> cuentas = new ArrayList<>();

        Cuenta cuenta1 = new Cuenta(1, tiposCuenta.get(0), usuarios.get(0), true);

        Cuenta cuenta2 = new Cuenta(2, tiposCuenta.get(1), usuarios.get(1), true);
        cuenta2.asociarVehiculo(vehiculos.get(0));

        Cuenta cuenta3 = new Cuenta(3, tiposCuenta.get(0), usuarios.get(2), false);
        cuenta3.asociarVehiculo(vehiculos.get(1));
        cuenta3.asociarVehiculo(vehiculos.get(2));
        cuenta3.asociarVehiculo(vehiculos.get(3));

        Cuenta cuenta4 = new Cuenta(4, tiposCuenta.get(1), usuarios.get(3), true);
        cuenta4.asociarVehiculo(vehiculos.get(4));

        cuentas.add(cuenta1);
        cuentas.add(cuenta2);
        cuentas.add(cuenta3);
        cuentas.add(cuenta4);

        return cuentas;
    }

    public static ConocimientoVehiculo crearConocimientoVehiculo(ArrayList<Cuenta> cuentas){
        ConocimientoVehiculo conocimientoVehiculo= new ConocimientoVehiculo();
        for (Cuenta cuenta: cuentas){
            for (Vehiculo vehiculo: cuenta.getVehiculos()){
                conocimientoVehiculo.agregarAsociacion(vehiculo.getPatente(), cuenta.getNumeroDeCuenta());
            }
        }
        return conocimientoVehiculo;
    }
}