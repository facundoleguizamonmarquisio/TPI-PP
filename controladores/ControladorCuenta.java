package controladores;

import vistas.*;
import modelos.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.nio.channels.Pipe.SourceChannel;
import java.util.ArrayList;
import java.util.List;

public class ControladorCuenta implements ActionListener {
    private PanelCuenta vistaCuenta;
    private ArrayList<Cuenta> cuentas;
    private CuentaVerificadaListener cvlistener;

    public ControladorCuenta(PanelCuenta vistaCuenta, ArrayList<Cuenta> cuentas) {
        this.vistaCuenta = vistaCuenta;
        this.vistaCuenta.getBtnVerificar().addActionListener(this);

        this.cuentas = cuentas;
    }

    // Setter
    public void setCuentaVerificadaListener(CuentaVerificadaListener cvlistener) {
        this.cvlistener = cvlistener;
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
            if (cvlistener != null) {
                cvlistener.onCuentaEncontrada(cuentaSeleccionada);
            }
        } else {
            if (cvlistener != null) {
                cvlistener.onCuentaNoEncontrada();

            }
        }
    }

    private Cuenta buscarCuenta(String documentoUsuario) {
        Cuenta cuentaSeleccionada = null;

        for (int i = 0; i < cuentas.size(); i++) {
            UsuarioUTN usuarioCuenta = cuentas.get(i).getUsuario();
            if (documentoUsuario == usuarioCuenta.getDocumento()) {
                cuentaSeleccionada = cuentas.get(i);
            }
        }
        return cuentaSeleccionada;
    }
}
