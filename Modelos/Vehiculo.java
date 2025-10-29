package modelos;

public class Vehiculo {
    protected String marca;
    protected String modelo;
    protected String patente;
    protected String color;

    public Vehiculo(String marca, String modelo, String patente, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.patente = patente;
        this.color = color;
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
}
