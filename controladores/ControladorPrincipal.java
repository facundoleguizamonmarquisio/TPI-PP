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
    private PanelComprobante vistaComprobante;
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
        inicializarVistaComprobante();

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

        vistaVehiculo.getBtnRegistrar().addActionListener(e -> {

        Vehiculo vehiculo = vistaVehiculo.obtenerVehiculoActual();
        String texto = ControladorComprobante.generarComprobante(cuentaSeleccionada, vehiculo);

        System.out.println(texto); //IMPRESION POR CONSOLA [BORRAR]

    });
    }

    private void inicializarVistaComprobante() {
        vistaComprobante = new PanelComprobante();

        vistaComprobante.getBtnGuardar().addActionListener(e -> {

        Vehiculo vehiculo = vistaVehiculo.obtenerVehiculoActual();
        Cuenta cuenta = cuentaSeleccionada;

        String strComprobante = ControladorComprobante.generarComprobante(cuenta, vehiculo);

        ControladorComprobante.guardarComprobanteTXT(strComprobante); //Aun no esta implementada la logica de crear un txt y guardarlo en local
         });
    }

    @Override
    public void onCuentaEncontrada(Cuenta cuentaSeleccionada) {
        this.cuentaSeleccionada = cuentaSeleccionada;
        
        vistaPrincipal.agregarPanelVehiculo(vistaVehiculo);
        vistaPrincipal.agregarPanelComprobante(vistaComprobante);
        // Mensaje de cuenta encontrada(borrar)
    }

    @Override
    public void onCuentaNoEncontrada() {
        // Mensaje de cuenta no encontrada(borrar)

    }


}
