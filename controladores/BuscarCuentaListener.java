package controladores;

import modelos.*;

public interface BuscarCuentaListener {
    void onCuentaEncontrada(Cuenta cuenta);

    void onCuentaNoEncontrada();
}
