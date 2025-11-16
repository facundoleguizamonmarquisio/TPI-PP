package controladores;

import vistas.*;
import modelos.*;
import utilidades.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPrincipal
        implements BuscarCuentaListener, GestionarVehiculoListener, GuardarComprobanteListener {
    private ArrayList<UsuarioUTN> usuarios;
    private ArrayList<Cuenta> cuentas;
    private List<List<String>> vehiculos;
    private VentanaPrincipal vistaPrincipal;
    private PanelBuscarCuenta BuscarCuenta;
    private PanelCuenta vistaCuenta;
    private PanelVehiculo vistaVehiculo;
    private VentanaEmergente vistaMensaje;
    private VentanaComprobante vistaComprobante;
    private ControladorBuscarCuenta ctrlCuenta;
    private ControladorVehiculo ctrlVehiculo;
    private ControladorComprobante ctrlComprobante;
    private Cuenta cuentaSeleccionada;
    private Vehiculo vehiculoRegistrado;

    public ControladorPrincipal(ArrayList<UsuarioUTN> usuarios, ArrayList<Cuenta> cuentas,
            ArrayList<Vehiculo> vehiculos) {
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
        ctrlCuenta.setCuentaBuscadaListener(this);

        vistaPrincipal.agregarPanel(BuscarCuenta);

    }

    private void inicializarVistaCuenta() {
        vehiculos = new ArrayList<>();
        for (Vehiculo v : cuentaSeleccionada.getVehiculos()) {
            List<String> vehiculo = new ArrayList<>();
            vehiculo.add(v.getPatente());
            vehiculo.add(v.getMarca());
            vehiculo.add(v.getModelo());
            vehiculo.add(v.getColor());
            vehiculos.add(vehiculo);
        }
        vistaCuenta = new PanelCuenta(vehiculos);
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

        ctrlVehiculo = new ControladorVehiculo(vistaVehiculo, cuentaSeleccionada);
        ctrlVehiculo.setVehiculoBuscadoListener(this);

        vistaPrincipal.agregarPanel(vistaVehiculo);
    }

    private void inicializarVistaMensaje(String mensaje, String tipo) {
        vistaMensaje = new VentanaEmergente(vistaPrincipal, mensaje, tipo);
        vistaMensaje.setVisible(true);
    }

    private void inicializarVistaComprobante() {
        vistaComprobante = new VentanaComprobante(vistaPrincipal,
                cuentaSeleccionada.generarComprobante(vehiculoRegistrado));

        ctrlComprobante = new ControladorComprobante(vistaComprobante,
                cuentaSeleccionada.generarComprobante(vehiculoRegistrado));
        ctrlComprobante.setGuardarComprobanteListener(this);

        vistaComprobante.setVisible(true);

    }

    @Override
    public void onCuentaEncontrada(Cuenta cuentaSeleccionada) {
        this.cuentaSeleccionada = cuentaSeleccionada;

        inicializarVistaCuenta();
        inicializarVistaVehiculo();
    }

    @Override
    public void onCuentaNoEncontrada() {
        inicializarVistaMensaje(Mensajes.CUENTA_NO_ENCONTRADA, "Error");
    }

    @Override
    public void onVehiculoAsociado() {
        inicializarVistaMensaje(Mensajes.VEHICULO_YA_ASOCIADO, "Error");
    }

    @Override
    public void onVehiculoNoEncontrado() {
        inicializarVistaMensaje(Mensajes.VEHICULO_NO_ENCONTRAD0, "Error");
    }

    @Override
    public void onVehiculoRegistrado(Vehiculo vehiculoRegistrado) {
        this.vehiculoRegistrado = vehiculoRegistrado;
        inicializarVistaComprobante();
    }

    @Override
    public void onVehiculoIncompleto() {
        inicializarVistaMensaje(Mensajes.VEHICULO_INCOMPLETO, "Error");
    }

    @Override
    public void onVehiculoEliminado() {
        inicializarVistaMensaje(Mensajes.VEHICULO_ELIMINADO, "Éxito");

        vehiculos = new ArrayList<>();
        for (Vehiculo v : cuentaSeleccionada.getVehiculos()) {
            List<String> vehiculo = new ArrayList<>();
            vehiculo.add(v.getPatente());
            vehiculo.add(v.getMarca());
            vehiculo.add(v.getModelo());
            vehiculo.add(v.getColor());
            vehiculos.add(vehiculo);
        }
        vistaCuenta.setPanelDatosVehiculo(vehiculos);
    }

    @Override
    public void onComprobanteGuardado() {
        vistaPrincipal.dispose();
        ;
    }
}
