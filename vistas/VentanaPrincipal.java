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
    private JPanel panelCuenta, panelVehiculo, panelComprobante;
    private JLabel labelNumCuenta, labelUsuario;
    private JComboBox<Cuenta> cbCuentas;
    private JTextField tfEditorComboC, tfMarca, tfModelo, tfPatente, tfColor;
    private JButton btnVerificar, btnRegistrar, btnEliminar, btnImprimir;

    public VentanaPrincipal(ArrayList<Cuenta> cuentas) {
        setTitle("Registro de vehículo");
        setSize(550, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        inicializarComponentes(cuentas);

        configurarLayout();
    }

    // Getter
    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

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
    private void inicializarComponentes(ArrayList<Cuenta> cuentas) {
        panelCuenta = new JPanel();
        panelCuenta.setBorder(BorderFactory.createTitledBorder("Datos de la cuenta"));

        panelVehiculo = new JPanel();
        panelComprobante = new JPanel();

        btnVerificar = new JButton("Verificar cuenta");
        btnRegistrar = new JButton("Registrar");
        btnEliminar = new JButton("Eliminar");
        btnImprimir = new JButton("Imprimir");

        cbCuentas = new JComboBox<>();
        for (Cuenta cuenta : cuentas) {
            cbCuentas.addItem(cuenta);
        }
        cbCuentas.setEditable(true);
        cbCuentas.setSelectedIndex(-1);
        JTextField tfEditorComboC = (JTextField) cbCuentas.getEditor().getEditorComponent();
        tfEditorComboC.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String texto = tfEditorComboC.getText().toLowerCase();
                cbCuentas.hidePopup(); // Ocultar temporalmente
                cbCuentas.removeAllItems();
                for (Cuenta cuenta : cuentas) {
                    if (cuenta.toString().toLowerCase().contains(texto)) {
                        cbCuentas.addItem(cuenta);
                    }
                }
                cbCuentas.getEditor().setItem(texto);
                cbCuentas.showPopup();
            }
        });

    }

    private void inicializarEventos() {

    }

    private void configurarLayout() {
        setLayout(new BorderLayout());

        add(btnRegistrar);
        add(btnEliminar);
        add(btnImprimir);
    }
        panelCuenta.add(btnVerificar);

        // add(cbCuentas);

        // add(btnRegistrar);
        // add(btnEliminar);

        add(panelCuenta, BorderLayout.NORTH);
    }

}