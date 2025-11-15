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
    private JLabel labelDatoNroCuenta, labelDatoTipoCuenta, labelDatoEstado, labelDatoNombreUser,
            labelDatoApellidoUser, labelDatoDocumentoUser, labelDatoPatente, labelDatoMarca, labelDatoModelo,
            labelDatoColor;

    public PanelCuenta() {
        setBorder(BorderFactory.createTitledBorder("Cuenta"));

        inicializarComponentes();

        configurarLayout();
    }

    // Setter
    public void setLabelDatoNroCuenta(String nroCuenta) {
        labelDatoNroCuenta.setText(nroCuenta);
    }

    public void setLabelDatoTipoCuenta(String tipoCuenta) {
        labelDatoTipoCuenta.setText(tipoCuenta);
    }

    public void setLabelDatoEstado(String estado) {
        labelDatoEstado.setText(estado);
    }

    public void setLabelDatoNombreUser(String nombreUsuario) {
        labelDatoNombreUser.setText(nombreUsuario);
    }

    public void setLabelDatoApellidoUser(String apellidoUsuario) {
        labelDatoApellidoUser.setText(apellidoUsuario);
    }

    public void setLabelDatoDocumentoUser(String documentoUsuario) {
        labelDatoDocumentoUser.setText(documentoUsuario);
    }

    // Métodos
    private void inicializarComponentes() {

        labelNroCuenta = new JLabel("N° de cuenta");
        labelNroCuenta.setForeground(new Color(114, 114, 114));
        labelTipoCuenta = new JLabel("Tipo de cuenta");
        labelTipoCuenta.setForeground(new Color(114, 114, 114));
        labelEstado = new JLabel("Estado");
        labelEstado.setForeground(new Color(114, 114, 114));

        labelNombreUser = new JLabel("Nombre");
        labelNombreUser.setForeground(new Color(114, 114, 114));
        labelApellidoUser = new JLabel("Apellido");
        labelApellidoUser.setForeground(new Color(114, 114, 114));
        labelDocumentoUser = new JLabel("Documento");
        labelDocumentoUser.setForeground(new Color(114, 114, 114));

        labelPatente = new JLabel("Patente");
        labelPatente.setForeground(new Color(114, 114, 114));
        labelMarca = new JLabel("Marca");
        labelMarca.setForeground(new Color(114, 114, 114));
        labelModelo = new JLabel("Modelo");
        labelModelo.setForeground(new Color(114, 114, 114));
        labelColor = new JLabel("Color");
        labelColor.setForeground(new Color(114, 114, 114));

        labelDatoNroCuenta = new JLabel();
        labelDatoTipoCuenta = new JLabel();
        labelDatoEstado = new JLabel();

        labelDatoNombreUser = new JLabel();
        labelDatoApellidoUser = new JLabel();
        labelDatoDocumentoUser = new JLabel();

        labelDatoPatente = new JLabel();
        labelDatoMarca = new JLabel();
        labelDatoModelo = new JLabel();
        labelDatoColor = new JLabel();

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
        panelDatosCuenta.add(labelDatoNroCuenta, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        panelDatosCuenta.add(labelTipoCuenta, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        panelDatosCuenta.add(labelDatoTipoCuenta, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        panelDatosCuenta.add(labelEstado, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        panelDatosCuenta.add(labelDatoEstado, gbc);

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
        panelDatosUsuario.add(labelDatoNombreUser, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        panelDatosUsuario.add(labelApellidoUser, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        panelDatosUsuario.add(labelDatoApellidoUser, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        panelDatosUsuario.add(labelDocumentoUser, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        panelDatosUsuario.add(labelDatoDocumentoUser, gbc);
    }

    private void configurarLayoutVehiculos() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

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