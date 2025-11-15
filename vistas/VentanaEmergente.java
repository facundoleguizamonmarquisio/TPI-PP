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

        if (tipo.equals("Error")) {
            getContentPane().setBackground(new Color(255, 181, 181));
        } else {
            getContentPane().setBackground(new Color(207, 233, 206));
        }

        inicializarComponentes();

        configurarLayout();

        pack();

        setSize(getWidth() + 10, 200);

        setLocationRelativeTo(null);
    }

    // Métodos
    private void inicializarComponentes() {
        aviso = new JTextArea(mensaje);
        aviso.setOpaque(false);
        aviso.setEditable(false);

    }

    private void configurarLayout() {
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        add(aviso, gbc);
    }

}
