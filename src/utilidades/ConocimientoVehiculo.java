package utilidades;

import java.util.*;
import java.util.function.BiPredicate;

public class ConocimientoVehiculo {
    private Map<String, Integer> asociaciones;
    private BiPredicate<String, Integer> estaAsociado;
    private BiPredicate<String, Integer> noEstaAsociado;

    public ConocimientoVehiculo() {
        this.asociaciones = new LinkedHashMap<>();
        this.estaAsociado = (patente, nroCuenta) -> asociaciones.containsKey(patente)
                && asociaciones.get(patente).equals(nroCuenta);
        this.noEstaAsociado = (patente, nroCuenta) -> !estaAsociado.test(patente,
                nroCuenta);
    }

    public void agregarAsociacion(String patente, int numeroCuenta) {
        asociaciones.put(patente, numeroCuenta);
    }

    public void eliminarAsociacion(String patente, int numeroCuenta) {
        asociaciones.remove(patente, numeroCuenta);
    }

    public boolean vehiculoAsociadoACuenta(String patente, int numeroCuenta) {
        return estaAsociado.test(patente, numeroCuenta);
    }

    public boolean vehiculoNoAsociadoACuenta(String patente, int numeroCuenta) {
        return noEstaAsociado.test(patente, numeroCuenta);
    }
}