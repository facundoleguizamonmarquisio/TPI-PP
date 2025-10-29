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

        comboCuentas = new JComboBox<>();
        for (Cuenta c : cuentas) {
            comboCuentas.addItem(c);
        }

        tfMarca = new JTextField(10);
        tfModelo = new JTextField(10);
        tfPatente = new JTextField(10);
        tfColor = new JTextField(10);

        btnRegistrar = new JButton("Registrar vehículo");

        this.add(new JLabel("Seleccionar cuenta:"));
        this.add(comboCuentas);

        this.add(new JLabel("Marca:"));
        this.add(tfMarca);
        this.add(new JLabel("Modelo:"));
        this.add(tfModelo);
        this.add(new JLabel("Patente:"));
        this.add(tfPatente);
        this.add(new JLabel("Color:"));
        this.add(tfColor);

        this.add(btnRegistrar);

        // Acción del botón
        btnRegistrar.addActionListener(e -> registrarVehiculo());
    }

    private void registrarVehiculo() {
        Cuenta cuenta = (Cuenta) comboCuentas.getSelectedItem();
        String marca = tfMarca.getText().trim();
        String modelo = tfModelo.getText().trim();
        String patente = tfPatente.getText().trim();
        String color = tfColor.getText().trim();

        if (cuenta != null && !marca.isEmpty() && !modelo.isEmpty() && !patente.isEmpty() && !color.isEmpty()) {
            Vehiculo vehiculo = new Vehiculo(marca, modelo, patente, color);
            cuenta.asociarVehiculo(vehiculo);
        } else {
            JOptionPane.showMessageDialog(this, "Complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
