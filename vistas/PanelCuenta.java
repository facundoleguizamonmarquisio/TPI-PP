package vistas;

import java.util.List;
import java.util.stream.Collectors;

import javax.swing.*;

import modelos.UsuarioUTN;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class PanelCuenta extends JPanel {
    private JPanel panelDatosCuenta, panelDatosUsuario, panelDatosVehiculos;
    private JLabel labelNroCuenta, labelTipoCuenta, labelEstado, labelNombreUser,
            labelApellidoUser, labelDocumentoUser, labelPatente, labelMarca, labelModelo, labelColor;
    private List<String> legajoUsuarios;

    public PanelCuenta() {
        setBorder(BorderFactory.createTitledBorder("Cuenta"));

        inicializarComponentes();

        configurarLayout();
    }

    // Setter

    // Getter

    // Métodos
    private void inicializarComponentes() {

        labelNroCuenta = new JLabel("N° de cuenta");
        labelTipoCuenta = new JLabel("Tipo de cuenta");
        labelEstado = new JLabel("Estado");

        labelNombreUser = new JLabel("Nombre");
        labelApellidoUser = new JLabel("Apellido");
        labelDocumentoUser = new JLabel("Documento");

        labelPatente = new JLabel("Patente");
        labelMarca = new JLabel("Marca");
        labelModelo = new JLabel("Modelo");
        labelColor = new JLabel("Color");

        panelDatosCuenta = new JPanel();
        panelDatosCuenta.setBorder(BorderFactory.createTitledBorder("Datos de la cuenta"));

        panelDatosUsuario = new JPanel();
        panelDatosUsuario.setBorder(BorderFactory.createTitledBorder("Datos del usuario UTN"));

        panelDatosVehiculos = new JPanel();
        panelDatosVehiculos.setBorder(BorderFactory.createTitledBorder("Vehículos asociados"));

    }

    private void configurarLayout() {
        setLayout(new GridBagLayout());

        panelDatosCuenta.setLayout(new GridBagLayout());
        panelDatosUsuario.setLayout(new GridBagLayout());
        panelDatosVehiculos.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.EAST;

        configurarLayoutCuenta();
        configurarLayoutUsuario();
        configurarLayoutVehiculos();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        add(panelDatosCuenta, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        add(panelDatosUsuario, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        add(panelDatosVehiculos, gbc);

    }

    private void configurarLayoutCuenta() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1; // Ocupa 1 columna
        gbc.weightx = 0; // No se expande en x
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        panelDatosCuenta.add(labelNroCuenta, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        panelDatosCuenta.add(labelTipoCuenta, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        panelDatosCuenta.add(labelEstado, gbc);
    }

    private void configurarLayoutUsuario() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        panelDatosUsuario.add(labelNombreUser, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        panelDatosUsuario.add(labelApellidoUser, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        panelDatosUsuario.add(labelDocumentoUser, gbc);
    }

    private void configurarLayoutVehiculos() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        panelDatosVehiculos.add(labelPatente, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        panelDatosVehiculos.add(labelMarca, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        panelDatosVehiculos.add(labelModelo, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        panelDatosVehiculos.add(labelColor, gbc);
    }
}