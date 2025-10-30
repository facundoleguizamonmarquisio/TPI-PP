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
    private JComboBox<Cuenta> cbCuentas;
    private JTextField tfEditorComboC, tfMarca, tfModelo, tfPatente, tfColor;
    private JButton btnEliminar, btnRegistrar, btnImprimir;

    public VentanaPrincipal(ArrayList<Cuenta> cuentas) {
        setTitle("Registro de vehículo");
        setSize(550, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        inicializarComponentes(cuentas);

        inicializarEventos();

        configurarLayout();
    }

    // Getter
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
        btnRegistrar = new JButton("Registrar");
        btnEliminar = new JButton("Eliminar");
        btnImprimir = new JButton("Imprimir");

        cbCuentas = new JComboBox<>();
        for (Cuenta cuenta : cuentas) {
            cbCuentas.addItem(cuenta);
        }
        cbCuentas.setEditable(true);

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
        add(cbCuentas);

        add(btnRegistrar);
        add(btnEliminar);
        add(btnImprimir);
    }

    // Eventos
    private void registrar() {
        System.out.println("Registrado");
    }

    private void eliminar() {
        System.out.println("Eliminado");
    }

}