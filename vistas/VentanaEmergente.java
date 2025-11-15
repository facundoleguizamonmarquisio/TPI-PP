package vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaEmergente extends JFrame {
    private String mensaje;
    private String tipo; // Error, Éxito
    private JButton btnGuardar, btnSalir;
    private JTextArea aviso;

    public VentanaEmergente(String mensaje, String tipo) {
        this.mensaje = mensaje;
        this.tipo = tipo;

        setTitle(tipo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        inicializarComponentes();

        configurarLayout();

        pack();
        setLocationRelativeTo(null);
    }

    // Métodos
    private void inicializarComponentes() {
        aviso = new JTextArea("Aviso");
        aviso.setEditable(false);

    }

    private void configurarLayout() {
        setLayout(new BorderLayout());

        aviso.setLayout(new BoxLayout(aviso, BoxLayout.Y_AXIS));

        add(aviso, BorderLayout.CENTER);
    }

}
