package vistas;

import java.util.List;
import java.util.stream.Collectors;

import javax.swing.*;

import modelos.Cuenta;
import modelos.UsuarioUTN;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class PanelVehiculo extends JPanel {
    private JLabel labelMarca, labelModelo, labelPatente, labelColor;
    private JTextField tfMarca, tfModelo, tfPatente, tfColor;
    private JButton btnRegistrar, btnEliminar;
    private JLabel lblMensajeRegistrar;

    public PanelVehiculo() {
        setBorder(BorderFactory.createTitledBorder("Gestión de vehículos"));

        inicializarComponentes();

        configurarLayout();
    }

    // Getter
    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }
    

    // Métodos
    private void inicializarComponentes() {
        labelPatente = new JLabel("Patente");
        labelMarca = new JLabel("Marca");
        labelModelo = new JLabel("Modelo");
        labelColor = new JLabel("Color");

        tfPatente = new JTextField();
        tfMarca = new JTextField();
        tfModelo = new JTextField();
        tfColor = new JTextField();

        btnRegistrar = new JButton("Registrar");
        btnEliminar = new JButton("Eliminar");

        lblMensajeRegistrar = new JLabel();

    }

        public void mostrarLblMensajeRegistrar(String mensaje) {
        lblMensajeRegistrar.setText(mensaje);
    }

    private void configurarLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(labelPatente, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(tfPatente, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(labelMarca, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(tfMarca, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(labelModelo, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(tfModelo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(labelColor, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(tfColor, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(btnRegistrar, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        add(btnEliminar, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        add(lblMensajeRegistrar, gbc);

        setMinimumSize(getPreferredSize());
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 200));


    }


}