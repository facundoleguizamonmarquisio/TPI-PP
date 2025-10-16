public class Vehiculo {
    protected String marca;
    protected String modelo;
    protected String patente;
    protected String color;
    protected String fechaRegistro;
    protected String horaRegistro;

    public Vehiculo() {
    }

    public Vehiculo(String marca,String modelo,String patente,String color,String fechaRegistro,String horaRegistro) {
        this.marca=marca;
        this.modelo=modelo;
        this.patente=patente;
        this.color=color;
        this.fechaRegistro=fechaRegistro;
        this.horaRegistro=horaRegistro;
    }

    public void tomarMarca(String marca) {
        this.marca=marca;
    }

    public void tomarModelo(String modelo) {
        this.modelo=modelo;
    }

    public void tomarPatente(String patente) {
        this.patente=patente;
    }

    public void tomarColor(String color) {
        this.color=color;
    }

    public void tomarFechaRegistro(String fechaRegistro) {
        this.fechaRegistro=fechaRegistro;
    }

    public void tomarHoraRegistro(String horaRegistro) {
        this.horaRegistro=horaRegistro;
    }

    public String mostrarMarca() {
        return marca;
    }

    public String mostrarModelo() {
        return modelo;
    }

    public String mostrarPatente() {
        return patente;
    }

    public String mostrarColor() {
        return color;
    }

    public String mostrarFechaRegistro() {
        return fechaRegistro;
    }

    public String mostrarHoraRegistro() {
        return horaRegistro;
    }

    @Override
    public String toString() {
        return "Marca: "+marca+
               "\nModelo: "+modelo+
               "\nPatente: "+patente+
               "\nColor: "+color+
               "\nFecha de registro: "+fechaRegistro+
               "\nHora de registro: "+horaRegistro;
    }
}

