package controladores;

import vistas.*;
import modelos.*;

import java.util.ArrayList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVentanaPrincipal {
    private VentanaPrincipal vistaPrincipal;
    private PanelCuenta vistaCuenta;
    private PanelVehiculo vistaVehiculo;
    private ControladorCuenta ctrlCuenta;
    private ControladorVehiculo ctrlVehiculo;

    public ControladorVentanaPrincipal() {
    }

    // Métodos
    public void inicializarAplicacion() {
        vistaPrincipal = new VentanaPrincipal();

        vistaCuenta = new PanelCuenta();
        vistaVehiculo = new PanelVehiculo();

        ctrlCuenta = new ControladorCuenta(vistaCuenta);
        ctrlVehiculo = new ControladorVehiculo(vistaVehiculo);

        vistaPrincipal.agregarPanelCuenta(vistaCuenta);
        vistaPrincipal.agregarPanelVehiculo(vistaVehiculo);

        vistaPrincipal.setVisible(true);
    }
}
