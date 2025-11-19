package principal;

// 1. Clases principales de la API de Projog
import org.projog.*;
// import org.projog.api.QueryResult;

import org.projog.core.term.Term;
// 2. Clases estándar de Java para manejo de archivos/recursos (URL, File, etc.)
import java.io.File;
import java.net.URI;
import java.net.URL; // Aunque no se usa directamente en la última versión, es útil tenerla.

public class Test {

    public static void main(String[] args) {
        Projog projog = new Projog();

        // projog.consultResource("resources/base.pl");

        // QueryResult result = projog.executeQuery("abuelo(juan,X)");

        // if (result == null) {
        // System.err.println("No se pudo ejecutar la consulta (result == null)");
        // return;
        // }

        // while (result.next()) {
        // Term x = result.getTerm("X");
        // System.out.println("X = " + (x != null ? x.toString() : "null"));
        // }
        System.out.println("hOLA");
    }
}