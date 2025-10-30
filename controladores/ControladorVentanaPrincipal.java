package controladores;

import vistas.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelos.Cuenta;
import vistas.VentanaPrincipal;
import java.util.ArrayList;


public class ControladorVentanaPrincipal implements java.awt.event.ActionListener {
    private VentanaPrincipal vista;
    private ArrayList<Cuenta> cuentas;
    public ControladorVentanaPrincipal(VentanaPrincipal vista, ArrayList<Cuenta> cuentas) {
        this.vista = vista;
        this.cuentas= cuentas;

        this.vista.getBtnRegistrar().addActionListener(this);
        this.vista.getBtnEliminar().addActionListener(this);
        this.vista.getBtnImprimir().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == vista.getBtnRegistrar()) {
            manejarRegistro();
        } else if (source == vista.getBtnEliminar()) {
            manejarEliminacion();
        } else if (source == vista.getBtnImprimir()) {
            manejarImpresion();
        }
    }


    private void manejarRegistro() {
        System.out.println("Vehiculo Registrado.");
    }

    private void manejarEliminacion() {
        System.out.println("Vehiculo eliminado.");
    }

    private void manejarImpresion() {
        for (Cuenta c : this.cuentas) {
            c.imprimirComprobantes();
        }
        System.out.println("Comprobantes con exito.");
    }
}
