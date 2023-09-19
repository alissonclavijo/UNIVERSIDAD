/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.triangulo_app;

import java.util.Scanner;
/**
 *
 * @author leito
 */
public class Triangulo_app {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la longitud del primer lado: ");
        double lado1 = scanner.nextDouble();

        System.out.println("Ingrese la longitud del segundo lado: ");
        double lado2 = scanner.nextDouble();

        System.out.println("Ingrese la longitud del tercer lado: ");
        double lado3 = scanner.nextDouble();

        Triangulo triangulo = new Triangulo(lado1, lado2, lado3);

        if (triangulo.esTriangulo()) {
            String tipo = triangulo.tipoTriangulo();
            System.out.println("El triángulo es de tipo: " + tipo);
        } else {
            System.out.println("No es un triángulo válido.");
        }

        scanner.close();
    }

    static String verificarTriangulo(int i, int i0, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}

class Triangulo {
    private double lado1;
    private double lado2;
    private double lado3;

    // Constructor vacío
    public Triangulo() {
        this.lado1 = 0;
        this.lado2 = 0;
        this.lado3 = 0;
    }

    // Constructor con datos
    public Triangulo(double lado1, double lado2, double lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public String tipoTriangulo() {
        if (lado1 == lado2 && lado2 == lado3) {
            return "Equilátero";
        } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
            return "Isósceles";
        } else {
            return "Escaleno";
        }
    }

    public boolean esTriangulo() {
        return lado1 + lado2 > lado3 && lado1 + lado3 > lado2 && lado2 + lado3 > lado1;
    }
}

