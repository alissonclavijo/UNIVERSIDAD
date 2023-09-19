/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package triangulo;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Triangulo {

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese el 1 er lado del triángulo: ");
        double lado1 = scanner.nextDouble();
        
        System.out.println("Ingrese el 2 do lado del triángulo: ");
        double lado2 = scanner.nextDouble();
        
        System.out.println("Ingrese el 3 er lado del triángulo: ");
        double lado3 = scanner.nextDouble();
        
        if (esTriangulo(lado1, lado2, lado3)) {
            String tipo = determinarTipoTriangulo(lado1, lado2, lado3);
            System.out.println("El triángulo ingresado es de tipo: " + tipo);
        } else {
            System.out.println("Los lados ingresados no forman un triángulo.");
        }
    }
    
    public static boolean esTriangulo(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }
   
    public static String determinarTipoTriangulo(double a, double b, double c) {
        if (a == b && b == c) {
            return "Tiangulo Equilátero";
        } else if (a == b || b == c || a == c) {
            return "Triangulo Isósceles";
        } else {
            return "Triangulo Escaleno";
        }
    }
}
