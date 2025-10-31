package controladores;

import vistas.*;
import modelos.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.Pipe.SourceChannel;
import java.util.ArrayList;

public class ControladorCuenta implements java.awt.event.ActionListener {
    private PanelCuenta vistaCuenta;

    public ControladorCuenta(PanelCuenta vistaCuenta) {
        this.vistaCuenta = vistaCuenta;

        this.vistaCuenta.getBtnVerificar().addActionListener(this);
    }

    // Métodos
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == vistaCuenta.getBtnVerificar()) {
            manejarVerificacion();
        }
    }

    private void manejarVerificacion() {
        System.out.println("Cuenta verificada.");
    }
}
