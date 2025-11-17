package src.vistas;

import java.util.List;
import java.util.stream.Collectors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class VentanaPrincipal extends JFrame {
    private JPanel panelContenido;

    public VentanaPrincipal() {
        setTitle("Registro de vehículo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        inicializarComponentes();

        configurarLayout();

        pack();

        setLocationRelativeTo(null);
    }

    // Métodos
    private void inicializarComponentes() {
        panelContenido = new JPanel();
    }

    private void configurarLayout() {
        setLayout(new BorderLayout());

        panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));

        add(panelContenido, BorderLayout.CENTER);
    }

    public void agregarPanel(JPanel panel) {
        panelContenido.add(panel);
        panelContenido.revalidate(); // Actualiza layout
        panelContenido.repaint(); // Redibuja interfaz
        setMaximumSize(new Dimension(620, Integer.MAX_VALUE));
        pack();
    }
}