package controladores;

import vistas.*;
import modelos.*;
import utilidades.Mensajes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPrincipal implements CuentaVerificadaListener {
    private VentanaPrincipal vistaPrincipal;
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

        inicializarVistaCuenta();
        inicializarVistaVehiculo();

        ctrlCuenta = new ControladorCuenta(vistaCuenta, cuentas);
        ctrlCuenta.setCuentaVerificadaListener(this);
        ctrlVehiculo = new ControladorVehiculo(vistaVehiculo);

        vistaPrincipal.agregarPanelCuenta(vistaCuenta);

        vistaPrincipal.setVisible(true);
    }

    private void inicializarVistaCuenta() {
        List<String> documentoUsuarios = usuarios.stream().map(n -> n.getDocumento()).toList();
        vistaCuenta = new PanelCuenta(documentoUsuarios);
        vistaCuenta.setCbUsuarios();
    }

    private void inicializarVistaVehiculo() {
        vistaVehiculo = new PanelVehiculo();
    }

    @Override
    public void onCuentaEncontrada(Cuenta cuentaSeleccionada) {
        this.cuentaSeleccionada = cuentaSeleccionada;
        vistaPrincipal.agregarPanelVehiculo(vistaVehiculo);
        vistaCuenta.mostrarLblVerificar(utilidades.Mensajes.CUENTA_ENCONTRADA);
    }

    @Override
    public void onCuentaNoEncontrada() {
        vistaCuenta.mostrarLblVerificar(utilidades.Mensajes.NO_TIENE_CUENTA);

    }


}
