package modelos;

import org.jpl7.Query;

public class TestJPL {
    public static void main(String[] args) {
        String t1 = "consult('test.pl')";
        Query q1 = new Query(t1);

        System.out.println("Consult result: " + (q1.hasSolution() ? "OK" : "FAIL"));
    }
}
