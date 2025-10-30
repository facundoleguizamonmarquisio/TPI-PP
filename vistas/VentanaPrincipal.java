package vistas;

import modelos.*;

import java.util.List;
import java.util.stream.Collectors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class VentanaPrincipal extends JFrame {
    private JPanel panelContenido, panelCuenta, panelVehiculo, panelComprobante;
    private JLabel labelUsuario, labelMarca, labelModelo, labelPatente, labelColor;
    private JComboBox<UsuarioUTN> cbUsuarios;
    private JTextField tfMarca, tfModelo, tfPatente, tfColor;
    private JButton btnVerificar, btnRegistrar, btnEliminar, btnImprimir;

    public VentanaPrincipal(ArrayList<UsuarioUTN> usuarios, ArrayList<Cuenta> cuentas) {
        setTitle("Registro de vehículo");
        setSize(550, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        inicializarComponentes(usuarios, cuentas);

        configurarLayout();
    }

    // Getter
    public JButton getBtnVerificar() {
        return btnRegistrar;
    }

    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnImprimir() {
        return btnImprimir;
    }

    // Métodos
    private void inicializarComponentes(ArrayList<UsuarioUTN> usuarios, ArrayList<Cuenta> cuentas) {
        panelContenido = new JPanel();

        panelCuenta = new JPanel();
        panelCuenta.setBorder(BorderFactory.createTitledBorder("Datos de la cuenta"));

        panelVehiculo = new JPanel();
        panelVehiculo.setBorder(BorderFactory.createTitledBorder("Datos del vehículo"));

        panelComprobante = new JPanel();

        labelUsuario = new JLabel("Usuario");
        labelPatente = new JLabel("Patente");
        labelMarca = new JLabel("Marca");
        labelModelo = new JLabel("Modelo");
        labelColor = new JLabel("Color");

        tfPatente = new JTextField();
        tfMarca = new JTextField();
        tfModelo = new JTextField();
        tfColor = new JTextField();

        btnVerificar = new JButton("Verificar cuenta");
        btnRegistrar = new JButton("Registrar");
        btnEliminar = new JButton("Eliminar");
        btnImprimir = new JButton("Imprimir");

        cbUsuarios = new JComboBox<>();
        for (UsuarioUTN usuario : usuarios) {
            cbUsuarios.addItem(usuario);
        }
        cbUsuarios.setEditable(true);
        cbUsuarios.setSelectedIndex(-1);
        JTextField tfEditorComboC = (JTextField) cbUsuarios.getEditor().getEditorComponent();
        tfEditorComboC.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String texto = tfEditorComboC.getText().toLowerCase();
                cbUsuarios.hidePopup(); // Ocultar temporalmente
                cbUsuarios.removeAllItems();
                for (UsuarioUTN usuario : usuarios) {
                    if (usuario.toString().toLowerCase().contains(texto)) {
                        cbUsuarios.addItem(usuario);
                    }
                }
                cbUsuarios.getEditor().setItem(texto);
                cbUsuarios.showPopup();
            }
        });

    }

    private void configurarLayout() {
        setLayout(new BorderLayout());

        panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));

        panelCuenta.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panelCuenta.add(labelUsuario, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panelCuenta.add(cbUsuarios, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelCuenta.add(btnVerificar, gbc);

        panelVehiculo.setLayout(new GridBagLayout());
        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panelVehiculo.add(labelPatente, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panelVehiculo.add(tfPatente, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panelVehiculo.add(labelMarca, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panelVehiculo.add(tfMarca, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panelVehiculo.add(labelModelo, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panelVehiculo.add(tfModelo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panelVehiculo.add(labelColor, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panelVehiculo.add(tfColor, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panelVehiculo.add(btnRegistrar, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        panelVehiculo.add(btnEliminar, gbc);

        panelComprobante.add(btnImprimir);

        // add(cbUsuarios);

        panelContenido.add(panelCuenta);
        panelContenido.add(Box.createVerticalStrut(10));
        panelContenido.add(panelVehiculo);

        add(panelContenido, BorderLayout.CENTER);
    }
}