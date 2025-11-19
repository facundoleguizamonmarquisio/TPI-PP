package controladores;

import modelos.*;
import utilidades.Mensajes;
import vistas.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.security.Guard;
import java.util.ArrayList;

public class ControladorComprobante implements ActionListener {
    private VentanaComprobante vistaComprobante;
    private StringBuilder contenido;
    private String patenteVehiculo;
    private int nroCuenta;
    private GuardarComprobanteListener comprobanteListener;

    public ControladorComprobante(VentanaComprobante vistaComprobante, StringBuilder contenido, String patenteVehiculo,
            int nroCuenta) {
        this.vistaComprobante = vistaComprobante;
        this.contenido = contenido;
        this.patenteVehiculo = patenteVehiculo;
        this.nroCuenta = nroCuenta;
        this.patenteVehiculo = patenteVehiculo;
        this.nroCuenta = nroCuenta;

        this.vistaComprobante.getBtnGuardar().addActionListener(this);
        this.vistaComprobante.getBtnSalir().addActionListener(this);
    }

    // Setter
    public void setGuardarComprobanteListener(GuardarComprobanteListener comprobanteListener) {
        this.comprobanteListener = comprobanteListener;
    }

    // Métodos
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == vistaComprobante.getBtnGuardar()) {
            manejarGuardado();
        } else if (source == vistaComprobante.getBtnSalir()) {
            manejarSalida();
        }
    }

    private void manejarGuardado() {
        // try {
        // FileWriter escritor = new FileWriter(
        // "Comprobantes/Comprobante_" + nroCuenta + "_" + patenteVehiculo + ".txt");
        // escritor.write(contenido.toString()); // Escribe el contenido
        // escritor.close(); // Cierra el archivo
        // } catch (Exception e) {
        // System.out.println("Error");
        // }

        System.out.println("Hola");

    }

    private void manejarSalida() {
        vistaComprobante.dispose();
        if (comprobanteListener != null) {
            comprobanteListener.onComprobanteGuardado();
        }
    }

}
