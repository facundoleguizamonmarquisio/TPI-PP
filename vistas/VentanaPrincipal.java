package vistas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import modelos.Cuenta;
import modelos.Vehiculo;

public class VentanaPrincipal extends JFrame {
    private JComboBox<Cuenta> comboCuentas;
    private JTextField tfMarca, tfModelo, tfPatente, tfColor;
    private JButton btnAsociar, btnDesasociar, btnImprimir;

    public VentanaPrincipal(ArrayList<Cuenta> cuentas) {
        this.setTitle("Registro de vehículo");
        this.setSize(550, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        // Botones
        btnAsociar = new JButton("Asociar");
        btnDesasociar = new JButton("Asociar");
        btnImprimir = new JButton("Asociar");

        // Acciones del botón
        btnAsociar.addActionListener(e -> {
            System.out.println("Asocie xd");
        });

        btnDesasociar.addActionListener(e -> {
            System.out.println("Desasocie xd");
        });

        btnDesasociar.addActionListener(e -> {
            System.out.println("Imprimi xd");
        });

        // Agregar componentes
        add(btnAsociar);
        add(btnDesasociar);
        add(btnImprimir);
    }
}