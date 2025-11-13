package controladores;

import vistas.*;
import modelos.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.Pipe.SourceChannel;
import java.util.ArrayList;

public class ControladorVehiculo implements java.awt.event.ActionListener {
    private PanelVehiculo vistaVehiculo;

    public ControladorVehiculo(PanelVehiculo vistaVehiculo) {
        this.vistaVehiculo = vistaVehiculo;

        this.vistaVehiculo.getBtnRegistrar().addActionListener(this);
        this.vistaVehiculo.getBtnEliminar().addActionListener(this);
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
         vistaVehiculo.mostrarLblMensajeRegistrar(utilidades.Mensajes.VEHICULO_REGISTRADO);
    }

    private void manejarEliminacion() {
        //System.out.println("Vehiculo eliminado.");
    }
}
