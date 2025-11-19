package principal;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class PrueblaLogico {

    public static void main(String[] args) {
        Map<String, String> verdades = new LinkedHashMap<>();
        verdades.put("Eres capaz",
                "Porque completaste este cuatrimestre a pesar de las dudas");
        verdades.put("Eres resiliente",
                "Porque no abandonaste cuando las actividades te sacaban el sueño");

        int contador = 1;
        for (Map.Entry<String, String> verdad : verdades.entrySet()) {
            System.out.println("VERDAD " + contador + ": " + verdad.getKey().toUpperCase());
            System.out.println("   Porque: " + verdad.getValue());
            System.out.println();
            contador++;
        }
    }

}