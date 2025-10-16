import java.util.ArrayList;

public class Cuenta {
    private int numeroDeCuenta;
    private TipoDeCuenta tipoDeCuenta;
    private UsuarioUTN usuario;
    private ArrayList<Vehiculo> vehiculos;
    private boolean estadoCuenta;

    public Cuenta() {
        this.vehiculos=new ArrayList<>();
    }

    public Cuenta(int numeroDeCuenta, TipoDeCuenta tipoDeCuenta, UsuarioUTN usuario, ArrayList<Vehiculo> vehiculos, boolean estadoCuenta) {
        this.numeroDeCuenta=numeroDeCuenta;
        this.tipoDeCuenta=tipoDeCuenta;
        this.usuario=usuario;
        this.vehiculos=vehiculos;
        this.estadoCuenta=estadoCuenta;
    }

    public void tomarNumeroDeCuenta(int numeroDeCuenta) {
        this.numeroDeCuenta=numeroDeCuenta;
    }

    public void tomarEstadoCuenta(boolean estadoCuenta) {
        this.estadoCuenta=estadoCuenta;
    }

    public void tomarUsuario(UsuarioUTN usuario) {
        this.usuario=usuario;
    }

    public void asociarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }

    public void desasociarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.remove(vehiculo);
    }

    public int mostrarNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public boolean mostrarEstadoCuenta() {
        return estadoCuenta;
    }

    public UsuarioUTN mostrarUsuario() {
        return usuario;
    }

    public ArrayList<Vehiculo> mostrarVehiculos() {
        return vehiculos;
    }

    private StringBuilder mostrarPatentes(){
        StringBuilder patentes = new StringBuilder();
        if(vehiculos != null && !vehiculos.isEmpty()) {
            for(Vehiculo v : vehiculos) {
                patentes.append(v.mostrarPatente()).append(" - ");
            }
        } else {
            patentes.append("No tiene vehículos asignados");
        }
        return patentes;
    }
    
    @Override
    public String toString() {
        return "Número de cuenta: "+mostrarNumeroDeCuenta()+
               "\nTipo de cuenta: "+(tipoDeCuenta!=null?tipoDeCuenta.mostrarNombre():"No posee tipo de cuenta")+
               "\nUsuario: "+(usuario!=null?usuario.toString():"No posee usuario")+
               "\nPatentes asignadas: "+(this.mostrarPatentes())+
               "\nEstado de cuenta: "+mostrarEstadoCuenta();
    }
}
