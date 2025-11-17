package principal;

import org.jpl7.Query;

public class TestJPL {
    public static void main(String[] args) {

        // Ruta al archivo Prolog (ajustala si cambia)
        String ruta = "prolog/base.pl";

        System.out.println("Cargando archivo Prolog: " + ruta);

        // Consultar el archivo
        Query q1 = new Query("consult('" + ruta + "')");

        if (q1.hasSolution()) {
            System.out.println("✔ Prolog cargado correctamente.");
        } else {
            System.out.println("✖ Error: No se pudo cargar Prolog.");
            return;
        }

        // Consulta simple para testear
        Query q2 = new Query("member(X, [1,2,3])");

        System.out.println("\nProbando consulta: member(X, [1,2,3]).");

        while (q2.hasMoreSolutions()) {
            System.out.println("   X = " + q2.nextSolution().get("X"));
        }

        System.out.println("\n✔ JPL está funcionando correctamente.");
    }
}