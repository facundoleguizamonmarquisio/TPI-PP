package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import modelos.*;
// import utilidades.ConocimientoVehiculo;
import vistas.*;

public class ControladorVehiculo implements ActionListener {
    private Cuenta cuentaSeleccionada;
    private ArrayList<Vehiculo> vehiculos;
    private GestionarVehiculoListener vehiculoListener;
    private PanelVehiculo vistaVehiculo;
    // private ConocimientoVehiculo conocimientoVehiculo;

    // public ControladorVehiculo(PanelVehiculo vistaVehiculo, Cuenta
    // cuentaSeleccionada,
    // ConocimientoVehiculo conocimientoVehiculo) {
    public ControladorVehiculo(PanelVehiculo vistaVehiculo, Cuenta cuentaSeleccionada) {
        this.vistaVehiculo = vistaVehiculo;
        this.cuentaSeleccionada = cuentaSeleccionada;
        this.vehiculos = cuentaSeleccionada.getVehiculos();
        // this.conocimientoVehiculo = conocimientoVehiculo;

        this.vistaVehiculo.getBtnRegistrar().addActionListener(this);
        this.vistaVehiculo.getBtnEliminar().addActionListener(this);
    }

    // Setter
    public void setVehiculoBuscadoListener(GestionarVehiculoListener vehiculoListener) {
        this.vehiculoListener = vehiculoListener;
    }

    // Métodos
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == vistaVehiculo.getBtnRegistrar()) {
            manejarRegistro();
        } else if (source == vistaVehiculo.getBtnEliminar()) {
            manejarEliminacion();
        }
    }

    private void manejarRegistro() {
        String patente = vistaVehiculo.getTfPatente().getText();
        String marca = vistaVehiculo.getTfMarca().getText();
        String modelo = vistaVehiculo.getTfModelo().getText();
        String color = vistaVehiculo.getTfColor().getText();

        if (!(patente.isEmpty() || marca.isEmpty() || modelo.isEmpty() || color.isEmpty())) {
            Vehiculo vehiculoIngresado = buscarVehiculo(patente);

            // if (conocimientoVehiculo.vehiculoAsociado(patente)) {
            // Integer numeroCuentaAsociada =
            // conocimientoVehiculo.obtenerCuentaDeVehiculo(patente);
            // if (numeroCuentaAsociada.equals(cuentaSeleccionada.getNumeroDeCuenta())) { //
            // ya esa asociado a esa
            // // ceunfra
            // if (vehiculoListener != null) {
            // vehiculoListener.onVehiculoAsociado();
            // }
            // } else { // esta asocuado a otra cuenta
            // if (vehiculoListener != null) {
            // vehiculoListener.onVehiculoAsociado();
            // }
            // }
            // }

            if (vehiculoIngresado != null) { // Vehículo ya asociado
                if (vehiculoListener != null) {
                    vehiculoListener.onVehiculoAsociado();
                }
            } else { // Vehículo aún inexistente
                Vehiculo vehiculoRegistrado = new Vehiculo(marca, modelo, patente, color);
                cuentaSeleccionada.asociarVehiculo(vehiculoRegistrado);
                if (vehiculoListener != null) {
                    vehiculoListener.onVehiculoRegistrado(vehiculoRegistrado);
                }
            }
        } else {
            if (vehiculoListener != null) {
                vehiculoListener.onVehiculoIncompleto();
            }
        }

    }

    private void manejarEliminacion() {
        String patente = vistaVehiculo.getTfPatente().getText();

        if (!(patente.isEmpty())) {
            Vehiculo vehiculoIngresado = buscarVehiculo(patente);
            if (vehiculoIngresado != null) {
                cuentaSeleccionada.desasociarVehiculo(vehiculoIngresado);

                // if (conocimientoVehiculo.vehiculoAsociadoACuenta(patente,
                // cuentaSeleccionada.getNumeroDeCuenta())) {
                // Vehiculo vehiculoIngresado = buscarVehiculo(patente);
                // cuentaSeleccionada.desasociarVehiculo(vehiculoIngresado);
                // conocimientoVehiculo.eliminarAsociacion(patente);

                if (vehiculoListener != null) {
                    vehiculoListener.onVehiculoEliminado();
                }
            } else {
                if (vehiculoListener != null) {
                    vehiculoListener.onVehiculoNoEncontrado();
                }
            }
        }
    }

    private Vehiculo buscarVehiculo(String patente) {
        Vehiculo vehiculoEncontrado = null;

        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo vehiculo = vehiculos.get(i);
            if (patente.equals(String.valueOf(vehiculo.getPatente()))) {
                vehiculoEncontrado = vehiculo;
            }
        }
        return vehiculoEncontrado;

    }
}
