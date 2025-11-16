package vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaComprobante extends JFrame {
    private StringBuilder mensaje;
    private JTextArea taComprobante;
    private JButton btnGuardar, btnSalir;

    public VentanaComprobante(StringBuilder mensaje) {
        this.mensaje = mensaje;

        setTitle("Comprobante");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        // setUndecorated(true); // Quitar barra de opciones
        setResizable(false);

        inicializarComponentes();

        configurarLayout();

        pack();
        setLocationRelativeTo(null);
    }

    // Getter
    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }

    // Métodos
    private void inicializarComponentes() {
        taComprobante = new JTextArea();
        taComprobante.setText(mensaje.toString());
        taComprobante.setEditable(false);
        taComprobante.setOpaque(false);

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
        gbc.anchor = GridBagConstraints.EAST;
        add(btnGuardar, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        add(btnSalir, gbc);
    }

}
