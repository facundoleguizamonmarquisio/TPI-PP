package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import modelos.*;
import vistas.*;
import utilidades.ConocimientoVehiculo;

public class ControladorVehiculo implements ActionListener {
    private Cuenta cuentaSeleccionada;
    private ArrayList<Vehiculo> vehiculos;
    private GestionarVehiculoListener vehiculoListener;
    private PanelVehiculo vistaVehiculo;
    private ConocimientoVehiculo conocimientoVehiculo;

    public ControladorVehiculo(PanelVehiculo vistaVehiculo, Cuenta cuentaSeleccionada,
            ConocimientoVehiculo conocimientoVehiculo) {
        this.vistaVehiculo = vistaVehiculo;
        this.cuentaSeleccionada = cuentaSeleccionada;
        this.vehiculos = cuentaSeleccionada.getVehiculos();
        this.conocimientoVehiculo = conocimientoVehiculo;

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
            // MILIII
            if (conocimientoVehiculo.vehiculoAsociadoACuenta(patente, cuentaSeleccionada.getNumeroDeCuenta())) {
                if (vehiculoListener != null) {
                    vehiculoListener.onVehiculoAsociado();
                }
            } else {
                if (vehiculoListener != null) {
                    Vehiculo vehiculoRegistrado = new Vehiculo(marca, modelo, patente, color);
                    cuentaSeleccionada.asociarVehiculo(vehiculoRegistrado);
                    conocimientoVehiculo.agregarAsociacion(patente, cuentaSeleccionada.getNumeroDeCuenta());
                    if (vehiculoListener != null) {
                        vehiculoListener.onVehiculoRegistrado(vehiculoRegistrado);
                    }
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
            if (conocimientoVehiculo.vehiculoAsociadoACuenta(patente, cuentaSeleccionada.getNumeroDeCuenta())) {
                Vehiculo vehiculoIngresado = buscarVehiculo(patente);
                cuentaSeleccionada.desasociarVehiculo(vehiculoIngresado);
                conocimientoVehiculo.eliminarAsociacion(patente, cuentaSeleccionada.getNumeroDeCuenta());
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
        Vehiculo vehiculoEncontrado = vehiculos.stream().filter(n -> patente.equals(n.getPatente())).findFirst()
                .orElse(null);
        return vehiculoEncontrado;
    }
}
