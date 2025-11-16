package vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaComprobante extends JFrame {
    private StringBuilder comprobante;
    private JButton btnGuardar, btnSalir;

    public VentanaComprobante(StringBuilder comprobante) {
        // ventana.dispose(); Para poder cerrar la ventana

        this.comprobante = comprobante;

        setTitle("Comprobante");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        inicializarComponentes();

        configurarLayout();

        pack();
        setLocationRelativeTo(null);
    }

    // Métodos
    private void inicializarComponentes() {
        btnGuardar = new JButton("Guardar");
        btnSalir = new JButton("Salir");
    }

    private void configurarLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1; // Ocupa 1 columna
        gbc.weightx = 0; // No se expande en x
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        add(btnGuardar, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        add(btnGuardar, gbc);
    }

}
