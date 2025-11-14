package controladores;

import modelos.*;

public class ControladorComprobante {

    public static String generarComprobante(Cuenta cuenta, Vehiculo vehiculo) {

        StringBuilder sb = new StringBuilder();
        sb.append("==== COMPROBANTE DE REGISTRO DE VEHÍCULO ====\n\n");
        sb.append("============== DATOS DE CUENTA ==============\n");
        sb.append("Nombre: ").append(cuenta.getUsuario().getNombre()).append("\n");
        sb.append("Cédula: ").append(cuenta.getUsuario().getDocumento()).append("\n");
        sb.append("Teléfono: ").append(cuenta.getUsuario().getTelefono()).append("\n\n");
        sb.append("============ DATOS DEL VEHÍCULO =============\n");
        sb.append("Marca: ").append(vehiculo.getMarca()).append("\n");
        sb.append("Modelo: ").append(vehiculo.getModelo()).append("\n");
        sb.append("Patente: ").append(vehiculo.getPatente()).append("\n");
        sb.append("Color: ").append(vehiculo.getColor()).append("\n\n");
        sb.append("============ FECHA Y HORA EMITIDA ===========\n");
        sb.append("Fecha de registro: ").append(vehiculo.getFechaRegistro()).append("\n");
        sb.append("Hora de registro: ").append(vehiculo.getHoraRegistro()).append("\n");
        sb.append("=============================================\n");
        return sb.toString();
    }

    
    public static void guardarComprobanteTXT(String strComprobante) {
     //Se debe crear un archivo donde su interior contenga lo que devuelve generarComprobante y luego solicite una ruta donde guardar el archivo.txt
    }
}
