/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.junitmockito;

/**
 *
 * @author PC
 */
public class Operaciones{
    
 public double dividir(double numerador, double denominador) throws ArithmeticException {
        if (denominador == 0) {
            throw new ArithmeticException("División por cero no permitida.");
        }
        return numerador / denominador;
    }

    public int calcularFactorial(int numero) throws IllegalArgumentException {
        if (numero < 0) {
            throw new IllegalArgumentException("El número debe ser no negativo.");
        }
        int factorial = 1;
        for (int i = 2; i <= numero; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public double calcularPotencia(double base, double exponente) throws ArithmeticException {
        if (base == 0 && exponente == 0) {
            throw new ArithmeticException("0 elevado a la 0 es indeterminado.");
        }
        int resultado = (int) Math.pow(base, exponente);
        return resultado;
    }
}
