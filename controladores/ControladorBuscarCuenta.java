package controladores;

import vistas.*;
import modelos.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.nio.channels.Pipe.SourceChannel;
import java.util.ArrayList;
import java.util.List;

public class ControladorBuscarCuenta implements ActionListener {
    private ArrayList<Cuenta> cuentas;
    private PanelBuscarCuenta vistaCuenta;
    private BuscarCuentaListener cuentaListener;

    public ControladorBuscarCuenta(PanelBuscarCuenta vistaCuenta, ArrayList<Cuenta> cuentas) {
        this.vistaCuenta = vistaCuenta;
        this.vistaCuenta.getBtnVerificar().addActionListener(this);

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

        if (source == vistaCuenta.getBtnVerificar()) {
            manejarVerificacion();
        }
    }

    private void manejarVerificacion() {
        String documentoUsuario = ((String) vistaCuenta.getCbUsuarios().getSelectedItem());

        Cuenta cuentaSeleccionada = buscarCuenta(documentoUsuario);

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
        Cuenta cuentaEncontrada = null;

        for (int i = 0; i < cuentas.size(); i++) {
            UsuarioUTN usuarioCuenta = cuentas.get(i).getUsuario();
            if (legajoUsuario.equals(String.valueOf(usuarioCuenta.getLegajo()))) {
                cuentaEncontrada = cuentas.get(i);
            }
        }
        return cuentaEncontrada;
    }
}
