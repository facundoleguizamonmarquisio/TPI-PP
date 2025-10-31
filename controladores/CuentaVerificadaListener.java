package controladores;

import modelos.*;

public interface CuentaVerificadaListener {
    void onCuentaEncontrada(Cuenta cuenta);

    void onCuentaNoEncontrada();
}
