package controladores;

import modelos.*;
import vistas.*;

import java.util.function.Predicate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorBuscarCuenta implements ActionListener {
    private ArrayList<Cuenta> cuentas;
    private PanelBuscarCuenta vistaCuenta;
    private BuscarCuentaListener cuentaListener;

    public ControladorBuscarCuenta(PanelBuscarCuenta vistaCuenta, ArrayList<Cuenta> cuentas) {
        this.vistaCuenta = vistaCuenta;
        this.vistaCuenta.getBtnBuscar().addActionListener(this);

        this.cuentas = cuentas;
    }

    // Setter
    public void setCuentaBuscadaListener(BuscarCuentaListener cuentaListener) {
        this.cuentaListener = cuentaListener;
    }

    // Métodos
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == vistaCuenta.getBtnBuscar()) {
            manejarBusqueda();
        }
    }

    private void manejarBusqueda() {
        String legajoUsuario = ((String) vistaCuenta.getCbUsuarios().getSelectedItem());

        Cuenta cuentaSeleccionada = buscarCuenta(legajoUsuario);

        if (cuentaSeleccionada != null) {
            if (cuentaListener != null) {
                cuentaListener.onCuentaEncontrada(cuentaSeleccionada);
            }
        } else {
            if (cuentaListener != null) {
                cuentaListener.onCuentaNoEncontrada();

            }

        }
    }

    private Cuenta buscarCuenta(String legajoUsuario) {
        Predicate<Cuenta> legajoCoindice = n -> legajoUsuario.equals(String.valueOf(n.getUsuario().getLegajo()));
        Cuenta cuentaEncontrada = cuentas.stream()
                .filter(legajoCoindice)
                .findFirst().orElse(null);
        return cuentaEncontrada;
    }
}
