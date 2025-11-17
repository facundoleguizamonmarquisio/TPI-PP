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

    public PanelVehiculo() {

        setBorder(BorderFactory.createTitledBorder("Gestión de vehículos"));

        inicializarComponentes();

        configurarLayout();
    }

    // Getter
    public JTextField getTfPatente() {
        return tfPatente;
    }

    public JTextField getTfMarca() {
        return tfMarca;
    }

    public JTextField getTfModelo() {
        return tfModelo;
    }

    public JTextField getTfColor() {
        return tfColor;
    }

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
    }

    private void configurarLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        add(labelPatente, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        add(labelMarca, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        add(labelModelo, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        add(labelColor, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        add(tfPatente, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        add(tfMarca, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        add(tfModelo, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        add(tfColor, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnRegistrar, gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnEliminar, gbc);

    }
}