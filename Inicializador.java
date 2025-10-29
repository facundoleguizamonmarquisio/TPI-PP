import java.util.ArrayList;
import Modelos.*;
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
        usuarios.add(new UsuarioUTN("Juan", "Pérez", "Calle 1", "12345678", "Ciudad A", "01/01/1980", "1111111111",
                "juan@mail.com", tiposUsuario.get(0), 11300));
        usuarios.add(new UsuarioUTN("María", "González", "Calle 2", "87654321", "Ciudad B", "05/05/1990", "2222222222",
                "maria@mail.com", tiposUsuario.get(1), 13000));
        usuarios.add(new UsuarioUTN("Carlos", "Ramírez", "Calle 3", "11223344", "Ciudad C", "10/10/1985", "3333333333",
                "carlos@mail.com", tiposUsuario.get(2), 7000));
        usuarios.add(new UsuarioUTN("Lucía", "Fernández", "Calle 4", "44332211", "Ciudad D", "15/12/1995", "4444444444",
                "lucia@mail.com", tiposUsuario.get(3), 14000));
        return usuarios;
    }

    public static ArrayList<Vehiculo> crearVehiculos() {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Toyota", "Corolla", "ABC123", "Rojo", "01/03/2020", "08:30"));
        vehiculos.add(new Vehiculo("Honda", "Civic", "DEF456", "Azul", "15/07/2021", "10:15"));
        vehiculos.add(new Vehiculo("Ford", "Focus", "GHI789", "Negro", "20/09/2022", "12:00"));
        vehiculos.add(new Vehiculo("Chevrolet", "Cruze", "JKL012", "Blanco", "05/05/2023", "14:45"));
        vehiculos.add(new Vehiculo("Volkswagen", "Golf", "MNO345", "Gris", "10/10/2020", "16:20"));
        vehiculos.add(new Vehiculo("Renault", "Megane", "PQR678", "Verde", "22/08/2021", "09:50"));
        return vehiculos;
    }

    public static ArrayList<Cuenta> crearCuentas(ArrayList<TipoDeCuenta> tiposCuenta, ArrayList<UsuarioUTN> usuarios,
            ArrayList<Vehiculo> vehiculos) {
        ArrayList<Cuenta> cuentas = new ArrayList<>();

        Cuenta cuenta1 = new Cuenta(1, tiposCuenta.get(0), usuarios.get(0), new ArrayList<>(), true);

        Cuenta cuenta2 = new Cuenta(2, tiposCuenta.get(1), usuarios.get(1), new ArrayList<>(), true);
        cuenta2.asociarVehiculo(vehiculos.get(0));

        Cuenta cuenta3 = new Cuenta(3, tiposCuenta.get(0), usuarios.get(2), new ArrayList<>(), false);
        cuenta3.asociarVehiculo(vehiculos.get(1));
        cuenta3.asociarVehiculo(vehiculos.get(2));
        cuenta3.asociarVehiculo(vehiculos.get(3));

        Cuenta cuenta4 = new Cuenta(4, tiposCuenta.get(1), usuarios.get(3), new ArrayList<>(), true);
        cuenta4.asociarVehiculo(vehiculos.get(4));

        cuentas.add(cuenta1);
        cuentas.add(cuenta2);
        cuentas.add(cuenta3);
        cuentas.add(cuenta4);

        return cuentas;
    }
}