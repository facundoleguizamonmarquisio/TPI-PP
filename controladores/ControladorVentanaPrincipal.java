package controladores;

import vistas.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelos.Cuenta;
import vistas.VentanaPrincipalNO;
import java.util.ArrayList;

public class ControladorVentanaPrincipal {
    private VentanaPrincipal vistaPrincipal;
    private PanelCuenta vistaCuenta;
    private PanelVehiculo vistaVehiculo;
    private ControladorCuenta ctrlCuenta;
    private ControladorVehiculo ctrlVehiculo;

    public ControladorVentanaPrincipal() {
    }

    public void inicializarAplicacion() {
        vistaPrincipal = new VentanaPrincipal();

        vistaCuenta = new PanelCuenta();
        ctrlCuenta = new ControladorCuenta();
        vistaPrincipal.agregarPanelCuenta(vistaCuenta);

        vistaPrincipal.setVisible(true);
    }
}
