package modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Vehiculo {
    private String marca;
    private String modelo;
    private String patente;
    private String color;
    private final String fechaRegistro;
    private final String horaRegistro;

    public Vehiculo(String marca, String modelo, String patente, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.patente = patente;
        this.color = color;

        LocalDateTime ahora = LocalDateTime.now();
        this.fechaRegistro = ahora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.horaRegistro = ahora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

    }

    // Setter
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setPatente(String patente) {
        this.patente = patente;
    }
    public void setColor(String color) {
        this.color = color;
    }

    // Getter
    public String getMarca() {
        return this.marca;
    }
    public String getModelo() {
        return this.modelo;
    }
    public String getPatente() {
        return this.patente;
    }
    public String getColor() {
        return this.color;
    }
    public String getFechaRegistro() {
        return this.fechaRegistro;
    }
    public String getHoraRegistro() {
        return this.horaRegistro;
    }

    @Override
    public String toString() {
        return "  -> Patente: " + patente + 
               ", Marca: " + marca + 
               ", Color: " + color + 
               " | REGISTRADO: " + fechaRegistro + " a las " + horaRegistro;
    }
}
