package modelos;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cuenta {
    private int numeroDeCuenta;
    private TipoDeCuenta tipoDeCuenta;
    private UsuarioUTN usuario;
    private ArrayList<Vehiculo> vehiculos;
    private boolean estadoCuenta;

    public Cuenta(int numeroDeCuenta, TipoDeCuenta tipoDeCuenta, UsuarioUTN usuario, ArrayList<Vehiculo> vehiculos,
            boolean estadoCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.tipoDeCuenta = tipoDeCuenta;
        this.usuario = usuario;
        this.vehiculos = vehiculos;
        this.estadoCuenta = estadoCuenta;
    }

    public void asociarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }

    public void desasociarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.remove(vehiculo);
    }

    // private StringBuilder mostrarPatentes() {
    // StringBuilder patentes = new StringBuilder();
    // if (vehiculos != null && !vehiculos.isEmpty()) {
    // for (Vehiculo v : vehiculos) {
    // patentes.append(v.mostrarPatente()).append(" - ");
    // }
    // } else {
    // patentes.append("No tiene vehículos asignados");
    // }
    // return patentes;
    // }

}
