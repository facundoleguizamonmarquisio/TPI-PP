package utilidades;

import java.util.*;
import java.util.function.BiPredicate;

public class ConocimientoVehiculo {
    private Map<String, Integer> asociaciones;
    private BiPredicate<String, Integer> estaAsociado;
    private BiPredicate<String, Integer> noEstaAsociado;

    public ConocimientoVehiculo() {
        this.asociaciones = new LinkedHashMap<>();
        this.estaAsociado = (patente, nroCuenta) -> asociaciones.containsKey(patente) && asociaciones.get(patente).equals(nroCuenta);
        this.noEstaAsociado = (patente, nroCuenta) -> !estaAsociado.test(patente, nroCuenta);
    }

    public void agregarAsociacion(String patente, int numeroCuenta) {
        asociaciones.put(patente, numeroCuenta);
    }
    public void eliminarAsociacion(String patente) {
        asociaciones.remove(patente);
    }

    public boolean vehiculoAsociado(String patente) {
        return asociaciones.containsKey(patente);
    }

    public boolean vehiculoAsociadoACuenta(String patente, int numeroCuenta) {
        return estaAsociado.test(patente, numeroCuenta);
    }

    public Integer obtenerCuentaDeVehiculo(String patente) {
        return asociaciones.get(patente);
    }
    public List<String> obtenerVehiculosDeCuenta(int numeroCuenta) {
        List<String> vehiculos = new ArrayList<>();
        for (Map.Entry<String, Integer> entrada : asociaciones.entrySet()) {
            if (entrada.getValue().equals(numeroCuenta)) {
                vehiculos.add(entrada.getKey());
            }
        }
        return vehiculos;
    }
}