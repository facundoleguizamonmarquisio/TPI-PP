package controladores;

import modelos.*;
import vistas.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

public class ControladorComprobante implements ActionListener {
    private VentanaComprobante vistaComprobante;
    private StringBuilder contenido;
    private String patenteVehiculo;
    private int nroCuenta;
    private GuardarComprobanteListener comprobanteListener;
    private CrearArchivoListener archivoListener;

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

    // Setter
    public void setCrearArchivoListener(CrearArchivoListener ArchivoListener) {
        this.archivoListener = ArchivoListener;
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
        try {
            FileWriter escritor = new FileWriter(
                    "Comprobantes/Comprobante_" + nroCuenta + "_" + patenteVehiculo + ".txt");
            escritor.write(contenido.toString()); // Escribe el contenido
            escritor.close(); // Cierra el archivo
        } catch (Exception e) {
            if (archivoListener != null) {
                archivoListener.onArchivoNoCreado();
            }
        }
    }

    private void manejarSalida() {
        vistaComprobante.dispose();
        if (comprobanteListener != null) {
            comprobanteListener.onComprobanteGuardado();
        }
    }

}
