package vistas;

import java.util.List;
import java.util.stream.Collectors;

import javax.swing.*;

import modelos.Cuenta; //Se deberia sacar?
import modelos.UsuarioUTN; //Se deberia sacar?

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class PanelComprobante extends JPanel {
    private JLabel labelMarca, labelModelo, labelPatente, labelColor;
    private JTextField tfMarca, tfModelo, tfPatente, tfColor;
    private JButton btnGuardar, btnSalir;
    //No se que se pretende con el boton salir, responder comentario
    private JLabel lblMensajeRegistrar;

    public PanelComprobante() {
        setBorder(BorderFactory.createTitledBorder("Comprobante"));

        inicializarComponentes();

        configurarLayout();
    }

    // Getter
    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JButton getBtnEliminar() {
        return btnSalir;
    }
    

    // Métodos
    private void inicializarComponentes() {
        labelPatente = new JLabel("Patente");
        labelMarca = new JLabel("Marca");
        labelModelo = new JLabel("Modelo");
        labelColor = new JLabel("Color");
        lblMensajeRegistrar = new JLabel();

        tfPatente = new JTextField();
        tfMarca = new JTextField();
        tfModelo = new JTextField();
        tfColor = new JTextField();

        btnGuardar = new JButton("Registrar");
        btnSalir = new JButton("Eliminar");
    }

        public void mostrarLblMensajeRegistrar(String mensaje) {
        lblMensajeRegistrar.setText(mensaje);
    }

    private void configurarLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;


        //Necesito que los botones esten posicionado en las esquinas superiores, pero no se como hacerlo
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(btnGuardar, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        add(btnSalir, gbc);
        
        setMinimumSize(getPreferredSize());
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 200));

    }


}