package vistas;

import java.util.List;
import java.util.stream.Collectors;

import javax.swing.*;

import modelos.UsuarioUTN;
import modelos.Vehiculo;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class PanelCuenta extends JPanel {
<<<<<<< HEAD
    private JLabel labelUsuario;
    private JComboBox<String> cbUsuarios;
    private JButton btnVerificar;
    private JLabel lblMensajeVerificacion;
    private List<String> documentoUsuarios;
=======
    private List<List<String>> vehiculos;
    private JPanel panelDatosCuenta, panelDatosUsuario, panelDatosVehiculos;
    private JLabel labelNroCuenta, labelTipoCuenta, labelEstado, labelNombreUser,
            labelApellidoUser, labelDocumentoUser, labelPatente, labelMarca, labelModelo, labelColor;
    private JLabel labelDatoNroCuenta, labelDatoTipoCuenta, labelDatoEstado, labelDatoNombreUser,
            labelDatoApellidoUser, labelDatoDocumentoUser, labelDatoVehiculo;
    private List<List<JLabel>> labelsVehiculo;
>>>>>>> testing

    public PanelCuenta(List<List<String>> vehiculos) {
        this.vehiculos = vehiculos;

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

    public void setDatoVehiculo(String datoVehiculo) {
        labelDatoVehiculo.setText(datoVehiculo);
    }

    public void setPanelDatosVehiculo(List<List<String>> nuevosVehiculos) {
        this.vehiculos = nuevosVehiculos;

        labelsVehiculo.clear();

        for (List<String> v : vehiculos) {
            List<JLabel> fila = new ArrayList<>();
            fila.add(new JLabel(v.get(0))); // Patente
            fila.add(new JLabel(v.get(1))); // Marca
            fila.add(new JLabel(v.get(2))); // Modelo
            fila.add(new JLabel(v.get(3))); // Color
            labelsVehiculo.add(fila);
        }
<<<<<<< HEAD
        cbUsuarios.setEditable(true);
        cbUsuarios.setSelectedIndex(-1);
        JTextField tfEditorComboC = (JTextField) cbUsuarios.getEditor().getEditorComponent();
        tfEditorComboC.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String texto = tfEditorComboC.getText().toLowerCase();
                cbUsuarios.hidePopup(); // Ocultar temporalmente
                cbUsuarios.removeAllItems();
                for (String documento : documentoUsuarios) {
                    if (documento.toString().toLowerCase().contains(texto)) {
                        cbUsuarios.addItem(documento);
                    }
                }
                cbUsuarios.getEditor().setItem(texto);
                cbUsuarios.showPopup();
            }
        });
    }
        public void mostrarLblVerificar(String mensaje) {
        lblMensajeVerificacion.setText(mensaje);
    }
    // Getter
    public JButton getBtnVerificar() {
        return btnVerificar;
    }
=======

        panelDatosVehiculos.removeAll(); // Panel limpio
>>>>>>> testing

        configurarLayoutVehiculos();

        panelDatosVehiculos.revalidate();
        panelDatosVehiculos.repaint();
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

        labelsVehiculo = new ArrayList<>();
        for (int i = 0; i < vehiculos.size(); i++) {
            List<JLabel> datos = new ArrayList<>();
            datos.add(new JLabel(vehiculos.get(i).get(0))); // Patente
            datos.add(new JLabel(vehiculos.get(i).get(1))); // Marca
            datos.add(new JLabel(vehiculos.get(i).get(2))); // Modelo
            datos.add(new JLabel(vehiculos.get(i).get(3))); // Color
            labelsVehiculo.add(datos);
        }

        panelDatosCuenta = new JPanel();
        panelDatosCuenta.setBorder(BorderFactory.createTitledBorder("Datos de la cuenta"));

        panelDatosUsuario = new JPanel();
        panelDatosUsuario.setBorder(BorderFactory.createTitledBorder("Datos del usuario UTN"));

        panelDatosVehiculos = new JPanel();
        panelDatosVehiculos.setBorder(BorderFactory.createTitledBorder("Vehículos asociados"));

        lblMensajeVerificacion = new JLabel();

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

<<<<<<< HEAD
        gbc.gridy = 3; // debajo del botón
        add(lblMensajeVerificacion, gbc);  

        setMinimumSize(getPreferredSize());
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
=======
>>>>>>> testing
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

        for (int i = 0; i < vehiculos.size(); i++) {
            for (int j = 0; j < 4; j++) {
                gbc.gridx = j;
                gbc.gridy = 1 + i;
                gbc.gridwidth = 1;
                gbc.weightx = 0;
                gbc.fill = GridBagConstraints.NONE;
                gbc.anchor = GridBagConstraints.WEST;
                panelDatosVehiculos.add(labelsVehiculo.get(i).get(j), gbc);
            }
        }
    }
}