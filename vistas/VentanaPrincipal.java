package vistas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import modelos.Cuenta;
import modelos.Vehiculo;

public class VentanaPrincipal extends JFrame {
    private JComboBox<Cuenta> comboCuentas;
    private JTextField tfMarca, tfModelo, tfPatente, tfColor;
    private JButton btnRegistrar;

    public VentanaPrincipal(ArrayList<Cuenta> cuentas) {
        this.setTitle("Registro de vehículo");
        this.setSize(550, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

    }
}