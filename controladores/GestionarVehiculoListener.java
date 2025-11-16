package controladores;

import modelos.*;

public interface GestionarVehiculoListener {
    void onVehiculoAsociado();

    void onVehiculoNoEncontrado();

    void onVehiculoIncompleto();

    void onVehiculoRegistrado(Vehiculo vehiculoSeleccionado);

    void onVehiculoEliminado();

}
