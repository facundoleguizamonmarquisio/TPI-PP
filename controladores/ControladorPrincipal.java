package controladores;

import vistas.*;
import modelos.*;
import utilidades.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPrincipal implements CuentaVerificadaListener {
    private ArrayList<UsuarioUTN> usuarios;
    private ArrayList<Cuenta> cuentas;
    private VentanaPrincipal vistaPrincipal;
    private PanelBuscarCuenta BuscarCuenta;
    private PanelCuenta vistaCuenta;
    private PanelVehiculo vistaVehiculo;
    private VentanaEmergente vistaMensaje;
    private ControladorBuscarCuenta ctrlCuenta;
    private ControladorVehiculo ctrlVehiculo;
    private Cuenta cuentaSeleccionada;

    public ControladorPrincipal(ArrayList<UsuarioUTN> usuarios, ArrayList<Cuenta> cuentas) {
        this.usuarios = usuarios;
        this.cuentas = cuentas;
    }

    // Métodos
    public void inicializarAplicacion() {
        vistaPrincipal = new VentanaPrincipal();

        inicializarVistaBuscarCuenta();

        vistaPrincipal.setVisible(true);
    }

    private void inicializarVistaBuscarCuenta() {
        List<String> legajoUsuarios = usuarios.stream().map(n -> String.valueOf(n.getLegajo())).toList();
        BuscarCuenta = new PanelBuscarCuenta(legajoUsuarios);
        BuscarCuenta.setCbUsuarios();

        ctrlCuenta = new ControladorBuscarCuenta(BuscarCuenta, cuentas);
        ctrlCuenta.setCuentaVerificadaListener(this);

        vistaPrincipal.agregarPanel(BuscarCuenta);

    }

    private void inicializarVistaCuenta() {
        vistaCuenta = new PanelCuenta();
        vistaCuenta.setLabelDatoNroCuenta(String.valueOf(cuentaSeleccionada.getNumeroDeCuenta()));
        vistaCuenta.setLabelDatoTipoCuenta(String.valueOf(cuentaSeleccionada.getTipoDeCuenta().getNombre()));
        vistaCuenta.setLabelDatoEstado(String.valueOf(cuentaSeleccionada.getEstadoCuenta()));
        vistaCuenta.setLabelDatoNombreUser(String.valueOf(cuentaSeleccionada.getUsuario().getNombre()));
        vistaCuenta.setLabelDatoApellidoUser(String.valueOf(cuentaSeleccionada.getUsuario().getApellido()));
        vistaCuenta.setLabelDatoDocumentoUser(String.valueOf(cuentaSeleccionada.getUsuario().getDocumento()));

        vistaPrincipal.agregarPanel(vistaCuenta);
    }

    private void inicializarVistaVehiculo() {
        vistaVehiculo = new PanelVehiculo();
        ctrlVehiculo = new ControladorVehiculo(vistaVehiculo);
        vistaPrincipal.agregarPanel(vistaVehiculo);
    }

    private void inicializarVistaMensaje() {
        vistaMensaje = new VentanaEmergente(Mensajes.CUENTA_NO_ENCONTRADA, "Error");
        vistaMensaje.setVisible(true);
    }

    @Override
    public void onCuentaEncontrada(Cuenta cuentaSeleccionada) {
        this.cuentaSeleccionada = cuentaSeleccionada;

        inicializarVistaCuenta();
        inicializarVistaVehiculo();
    }

    @Override
    public void onCuentaNoEncontrada() {
        inicializarVistaMensaje();
    }
}
