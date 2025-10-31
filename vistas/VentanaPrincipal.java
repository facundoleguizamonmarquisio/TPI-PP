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
    private JPanel panelContenido;
    private JLabel labelUsuario, labelMarca, labelModelo, labelPatente, labelColor;
    private JComboBox<UsuarioUTN> cbUsuarios;
    private JTextField tfMarca, tfModelo, tfPatente, tfColor;
    private JButton btnVerificar, btnRegistrar, btnEliminar, btnImprimir;

    public VentanaPrincipal() {
        setTitle("Registro de vehículo");
        setSize(550, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        inicializarComponentes();

        configurarLayout();
    }

    // Getter

    // Métodos
    private void inicializarComponentes() {
        panelContenido = new JPanel();
    }

    private void configurarLayout() {
        setLayout(new BorderLayout());

        panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));

        add(panelContenido, BorderLayout.CENTER);
    }

    public void agregarPanelCuenta(PanelCuenta panelCuenta) {
        panelContenido.add(panelCuenta);
        panelContenido.revalidate(); // Actualiza layout
        panelContenido.repaint(); // Redibuja interfaz

    }

    public void agregarPanelVehiculo(PanelVehiculo panelVehiculo) {
        panelContenido.add(panelVehiculo);
        panelContenido.revalidate(); // Actualiza layout
        panelContenido.repaint(); // Redibuja interfaz

    }
}