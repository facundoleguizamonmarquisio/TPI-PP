package controladores;

import vistas.*;
import modelos.*;
import utilidades.Mensajes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.security.Guard;
import java.util.ArrayList;

public class ControladorComprobante implements ActionListener {
    private VentanaComprobante vistaComprobante;
    private StringBuilder contenido;
    private GuardarComprobanteListener comprobanteListener;

    public ControladorComprobante(VentanaComprobante vistaComprobante, StringBuilder contenido) {
        this.vistaComprobante = vistaComprobante;
        this.contenido = contenido;

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
        try {
            FileWriter escritor = new FileWriter("Comprobantes/Comprobante.txt");
            escritor.write(contenido.toString()); // Escribe el contenido
            escritor.close(); // Cierra el archivo
        } catch (Exception e) {
            System.out.println("Error");
        }

    }

    private void manejarSalida() {
        vistaComprobante.dispose();
        if (comprobanteListener != null) {
            comprobanteListener.onComprobanteGuardado();
        }
    }

}
