package controladores;

import vistas.*;
import modelos.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPrincipal implements CuentaVerificadaListener {
    private VentanaPrincipal vistaPrincipal;
    private PanelBuscarCuenta BuscarCuenta;
    private PanelCuenta vistaCuenta;
    private PanelVehiculo vistaVehiculo;
    private ControladorCuenta ctrlCuenta;
    private ControladorVehiculo ctrlVehiculo;
    private ArrayList<UsuarioUTN> usuarios;
    private ArrayList<Cuenta> cuentas;
    private Cuenta cuentaSeleccionada;

    public ControladorPrincipal(ArrayList<UsuarioUTN> usuarios, ArrayList<Cuenta> cuentas) {
        this.usuarios = usuarios;
        this.cuentas = cuentas;
    }

    // Métodos
    public void inicializarAplicacion() {
        vistaPrincipal = new VentanaPrincipal();

        inicializarBuscarCuenta();
        inicializarVistaCuenta();
        inicializarVistaVehiculo();

        ctrlCuenta = new ControladorCuenta(BuscarCuenta, cuentas);
        ctrlCuenta.setCuentaVerificadaListener(this);
        ctrlVehiculo = new ControladorVehiculo(vistaVehiculo);

        vistaPrincipal.agregarPanel(BuscarCuenta);

        vistaPrincipal.setVisible(true);
    }

    private void inicializarBuscarCuenta() {
        List<String> legajoUsuarios = usuarios.stream().map(n -> String.valueOf(n.getLegajo())).toList();
        BuscarCuenta = new PanelBuscarCuenta(legajoUsuarios);
        BuscarCuenta.setCbUsuarios();
    }

    private void inicializarVistaCuenta() {
        vistaCuenta = new PanelCuenta();
    }

    private void inicializarVistaVehiculo() {
        vistaVehiculo = new PanelVehiculo();
    }

    @Override
    public void onCuentaEncontrada(Cuenta cuentaSeleccionada) {
        this.cuentaSeleccionada = cuentaSeleccionada;
        vistaPrincipal.agregarPanel(vistaCuenta);
        vistaPrincipal.agregarPanel(vistaVehiculo);
        System.out.println("Tiene cuenta");
    }

    @Override
    public void onCuentaNoEncontrada() {
        System.out.println("NO tiene cuenta");
    }
}
