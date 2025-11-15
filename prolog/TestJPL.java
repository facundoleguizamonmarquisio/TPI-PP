package prolog;

import org.jpl7.*;

public class TestJPL {
    public static void main(String[] args) {
        // Cargar archivo Prolog
        Query q1 = new Query("consult('test.pl')");
        System.out.println("Cargar test.pl: " + q1.hasSolution());

        // Ejecutar una consulta
        Query q2 = new Query("padre(juan, X)");
        while (q2.hasMoreSolutions()) {
            System.out.println(q2.nextSolution());
        }
    }
}
