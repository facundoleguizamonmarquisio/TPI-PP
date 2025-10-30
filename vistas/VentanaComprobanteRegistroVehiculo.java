package vistas;

import modelos.Cuenta;
import modelos.Vehiculo;
import controladores.ControladorComprobante;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaComprobanteRegistroVehiculo extends JFrame {

    private Cuenta cuenta;
    private Vehiculo vehiculo;

    private JTextArea areaDatos;
    private JButton btnGenerarComprobante;

    public VentanaComprobanteRegistroVehiculo(Cuenta cuenta, Vehiculo vehiculo) {
        this.cuenta = cuenta;
        this.vehiculo = vehiculo;

        setTitle("Registro de Vehículo");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        inicializarComponentes();
        setVisible(true);
    }

    private void inicializarComponentes() {
        areaDatos = new JTextArea();
        areaDatos.setEditable(false);
        areaDatos.setFont(new Font("Monospaced", Font.PLAIN, 12));

        mostrarDatos();

        btnGenerarComprobante = new JButton("Generar Comprobante");
        btnGenerarComprobante.addActionListener((ActionEvent e) -> {
            String comprobante = ControladorComprobante.generarComprobante(cuenta, vehiculo);
            JOptionPane.showMessageDialog(
                VentanaComprobanteRegistroVehiculo.this,
                comprobante,
                "Comprobante Generado",
                JOptionPane.INFORMATION_MESSAGE
            );
        });

        add(new JScrollPane(areaDatos), BorderLayout.CENTER);
        add(btnGenerarComprobante, BorderLayout.SOUTH);
    }

    private void mostrarDatos() {
        String texto = String.format(
            "=== DATOS DEL cuenta ===\nNombre: %s\nPatente: %s\nTeléfono: %s\n\n=== DATOS DEL VEHÍCULO ===\nMarca: %s\nModelo: %s\nPlaca: %s\nFecha Registro: %s\nHora Registro: %s",
            cuenta.getUsuario().getNombre(),
            cuenta.getUsuario().getDocumento(),
            cuenta.getUsuario().getTelefono(),
            vehiculo.getMarca(),
            vehiculo.getModelo(),
            vehiculo.getPatente(),
            vehiculo.getFechaRegistro(),
            vehiculo.getHoraRegistro()
        );

        areaDatos.setText(texto);
    }

}
