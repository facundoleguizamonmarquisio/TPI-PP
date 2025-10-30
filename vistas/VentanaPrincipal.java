package vistas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import modelos.*;

public class VentanaPrincipal extends JFrame {
    private JComboBox<Cuenta> comboCuentas;
    private JTextField tfMarca, tfModelo, tfPatente, tfColor;
    private JButton btnAsociar, btnDesasociar, btnImprimir;

    public VentanaPrincipal(ArrayList<Cuenta> cuentas) {
        this.setTitle("Registro de vehículo");
        this.setSize(550, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        // ComboBox
        comboCuentas = new JComboBox<>();

        // Botones
        btnAsociar = new JButton("Asociar");
        btnDesasociar = new JButton("Desasociar");
        btnImprimir = new JButton("Imprimir");

        // Acciones del botón
        btnAsociar.addActionListener(e -> {
            System.out.println("Asocie xd");
        });

        btnDesasociar.addActionListener(e -> {
            System.out.println("Desasocie xd");
        });

        // btnImprimir.addActionListener(e -> {
        // System.out.println("Imprimi xd");
        // });

        // Agregar componentes
        add(comboCuentas);

        add(btnAsociar);
        add(btnDesasociar);
        // add(btnImprimir);

    }

    // Getter
    public JButton getBtnAsociar() {
        return btnAsociar;
    }

    public JButton getBtnDesasociar() {
        return btnDesasociar;
    }

    public JButton getBtnImprimir() {
        return btnImprimir;
    }
}