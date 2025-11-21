package modelos;

import java.util.ArrayList;

public class Cuenta {
    private int numeroDeCuenta;
    private TipoDeCuenta tipoDeCuenta;
    private UsuarioUTN usuario;
    private ArrayList<Vehiculo> vehiculos;
    private boolean estadoCuenta;

    public Cuenta(int numeroDeCuenta, TipoDeCuenta tipoDeCuenta, UsuarioUTN usuario, boolean estadoCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.tipoDeCuenta = tipoDeCuenta;
        this.usuario = usuario;
        this.vehiculos = new ArrayList<Vehiculo>();
        this.estadoCuenta = estadoCuenta;
    }

    // Setter
    public void setNumeroDeCuenta(int numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public void setTipoDeCuenta(TipoDeCuenta tipoDeCuenta) {
        this.tipoDeCuenta = tipoDeCuenta;
    }

    public void setUsuario(UsuarioUTN usuario) {
        this.usuario = usuario;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void setEstadoCuenta(boolean estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    // Getter
    public int getNumeroDeCuenta() {
        return this.numeroDeCuenta;
    }

    public TipoDeCuenta getTipoDeCuenta() {
        return this.tipoDeCuenta;
    }

    public UsuarioUTN getUsuario() {
        return this.usuario;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return this.vehiculos;
    }

    public boolean getEstadoCuenta() {
        return this.estadoCuenta;
    }

    // Métodos
    public void asociarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }

    public void desasociarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.remove(vehiculo);
    }

    public StringBuilder generarComprobante(Vehiculo vehiculo) {
        StringBuilder mensajeComprobante = new StringBuilder();
        mensajeComprobante.append("===== COMPROBANTE DE REGISTRO DE VEHÍCULO =====\n\n");
        mensajeComprobante.append("=== DATOS DE LA CUENTA ===\n");
        mensajeComprobante.append("Nombre: ").append(getUsuario().getNombre()).append("\n");
        mensajeComprobante.append("Documento:").append(getUsuario().getDocumento()).append("\n");
        mensajeComprobante.append("Teléfono:").append(getUsuario().getTelefono()).append("\n\n");
        mensajeComprobante.append("=== DATOS DEL VEHÍCULO ===\n");
        mensajeComprobante.append("Marca: ").append(vehiculo.getMarca()).append("\n");
        mensajeComprobante.append("Modelo: ").append(vehiculo.getModelo()).append("\n");
        mensajeComprobante.append("Patente: ").append(vehiculo.getPatente()).append("\n");
        mensajeComprobante.append("Fecha de registro:").append(vehiculo.getFechaRegistro()).append("\n");
        mensajeComprobante.append("Hora de registro:").append(vehiculo.getHoraRegistro()).append("\n");
        mensajeComprobante.append("=============================================\n");
        return mensajeComprobante;
    }

    // ToString
    @Override
    public String toString() {
        return "Cuenta #" + numeroDeCuenta + " - " + usuario.getNombre() + " " + usuario.getApellido();
    }
}
