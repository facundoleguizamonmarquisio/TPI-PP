package vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaComprobante extends JFrame {
    private StringBuilder mensaje;
    private JTextArea taComprobante;
    private JButton btnGuardar, btnSalir;

    public VentanaComprobante(StringBuilder mensaje) {
        // ventana.dispose(); Para poder cerrar la ventana

        this.mensaje = mensaje;

        setTitle("Comprobante");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        inicializarComponentes();

        configurarLayout();

        pack();
        setLocationRelativeTo(null);
    }

    // Métodos
    private void inicializarComponentes() {
        taComprobante = new JTextArea();
        taComprobante.setText(mensaje.toString());
        taComprobante.setEditable(false);
        ;

        btnGuardar = new JButton("Guardar");
        btnSalir = new JButton("Salir");
    }

    private void configurarLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Ocupa 2 columna
        gbc.weightx = 0; // No se expande en x
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        add(taComprobante, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        add(btnGuardar, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        add(btnSalir, gbc);
    }

}
