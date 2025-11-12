package utilidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Formato {

    public static String devolverFechaActualFormateada() {
        LocalDateTime ahora = LocalDateTime.now();
        return ahora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static String devolverHoraActualFormateada() {
        LocalDateTime ahora = LocalDateTime.now();
        return ahora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

}