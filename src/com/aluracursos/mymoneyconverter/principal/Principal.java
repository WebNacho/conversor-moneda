package com.aluracursos.mymoneyconverter.principal;

import com.aluracursos.mymoneyconverter.modelos.ConsultaValorMoneda;
import com.aluracursos.mymoneyconverter.modelos.MenuOpcion;
import com.aluracursos.mymoneyconverter.modelos.Moneda;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scannerMoneda = new Scanner(System.in);
        ConsultaValorMoneda consultaValorMonedaMoneda = new ConsultaValorMoneda();

        while (true) {
            MenuOpcion menuOpcion = new MenuOpcion();
            int opcionSeleccionada = menuOpcion.mostrarMenu();

            String monedaBase = "";
            String monedaAConvertir = "";

            switch (opcionSeleccionada) {
                case 1 -> { // Dolar a Peso Argentino
                    monedaBase = "USD";
                    monedaAConvertir = "ARS";
                }
                case 2 -> { // Peso Argentino a Dolar
                    monedaBase = "ARS";
                    monedaAConvertir = "USD";
                }
                case 3 -> { // Dolar a Real brasileño
                    monedaBase = "USD";
                    monedaAConvertir = "BRL";
                }
                case 4 -> { // Real brasileño a Dolar
                    monedaBase = "BRL";
                    monedaAConvertir = "USD";
                }
                case 5 -> { // Dolar a Peso Colombiano
                    monedaBase = "USD";
                    monedaAConvertir = "COP";
                }
                case 6 -> { // Peso Colombiano a Dolar
                    monedaBase = "COP";
                    monedaAConvertir = "USD";
                }
                case 7 -> { // Salir
                    System.out.println("¡Gracias por usar el conversor!");
                    System.exit(0);
                }
            }

            System.out.print("Ingrese el monto a convertir: ");
            var montoAConvertir = scannerMoneda.nextDouble();

            try {
                Moneda moneda = consultaValorMonedaMoneda.consultaMoneda(monedaBase, monedaAConvertir, montoAConvertir);
                System.out.printf("\nResultado de la conversión: %.2f %s = %.2f %s%n",
                        montoAConvertir, moneda.base_code(),
                        moneda.conversion_result(), moneda.target_code());
                System.out.println("");
            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}