package com.aluracursos.mymoneyconverter.modelos;

import java.util.Scanner;

import static java.lang.System.*;

public class MenuOpcion {

    public static boolean isNumeric(String cadena) {
        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

    public int mostrarMenu() {
        out.println("""
                *************** Menú conversor de moneda ***************
                         Sea bienvenido/a al conversor de moneda
                
                1) Dolar              ------>>>   Pesos Argentino.
                2) Pesos Argentino    ------>>>   Dolar.
                3) Dolar              ------>>>   Real Brasilero.
                4) Real Brasilero     ------>>>   Dolar.
                5) Dolar              ------>>>   Peso Colombiano.
                6) Peso Colombiano    ------>>>   Dolar.
                7) Salir 
                """);
        out.print("Ingrese la opcion deseada: ");

        Scanner scanner = new Scanner(System.in);
        var opcion = scanner.next();

        if (isNumeric(opcion)) {
            int numero = Integer.parseInt(opcion);
            if (numero >= 1 && numero <= 7) {
                return numero;
            } else {
                out.println("\nLa opción seleccionada no es válida. Por favor seleccione una opción válida...\n");
                return mostrarMenu();
            }
        } else {
            System.out.println("\nPor favor ingresa un valor numérico para la selección...\n");
            return mostrarMenu();
        }
    }
}