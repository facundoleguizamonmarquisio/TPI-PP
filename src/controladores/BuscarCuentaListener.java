package src.controladores;

import src.modelos.*;

public interface BuscarCuentaListener {
    void onCuentaEncontrada(Cuenta cuenta);

    void onCuentaNoEncontrada();
}
