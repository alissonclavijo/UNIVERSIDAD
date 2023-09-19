/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.junitmockito;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.doReturn;

/**
 *
 * @author PC
 */
public class OperacionesTest {
    
    /*@Test
    void dividir_ValidArguments_ReturnsCorrectResult() {
        Operaciones calculadora = new Operaciones();
        Operaciones calculadoraMock = Mockito.spy(calculadora);
        doReturn(2.0).when(calculadoraMock).dividir(10.0, 5.0);
        //CASO 1 PASA
        //assertEquals(4, calculadoraMock.dividir(16.0, 4));
        //CASO 4 PASA
        assertThrows(ArithmeticException.class, () -> calculadoraMock.dividir(12.0, 0));
        //CASO 7 PASA
        //assertEquals(5, calculadoraMock.dividir(774396530, 154879306));
        //CASO 10 NO PASA - No se provoca un ArithmeticException puesto que la operación es valida.
        //assertThrows(ArithmeticException.class, () -> calculadoraMock.dividir(124.0, 0.2));
        
    }*/
    
    /* @Test
    void calcularFactorial_ValidArgument_ReturnsCorrectResult() {
        // Crear una instancia real de la clase Calculadora
        Operaciones calculadora = new Operaciones();
        Operaciones calculadoraMock = Mockito.spy(calculadora);
        doReturn(6).when(calculadoraMock).calcularFactorial(3);
        // Llamar al método que se está probando
        //CASO 2 NO PASA - El valor 5! no es aceptado por la función
        //int resultado = calculadora.calcularFactorial(5!);
        //assertEquals(120, resultado);
        //CASO 5 NO PASA - El valor -5! no es aceptado por la función
        //assertThrows(IllegalArgumentException.class, () -> calculadora.calcularFactorial(-5!));
        //CASO 8 NO PASA - El valor -12! no es aceptado por la función
        //int resultado = calculadora.calcularFactorial(12!);
        //assertEquals(479001600, resultado);
    }*/
    
    /* @Test
    void calcularPotencia_ValidArguments_ReturnsCorrectResult() {
        // Crear una instancia real de la clase Calculadora
        Operaciones calculadora = new Operaciones();
        
        //CASO 3 NO PASA - El valor 2^3 no es aceptado por la función
        //int resultado = (int) calculadora.calcularPotencia(2^3);
        //assertEquals(8, resultado);
        //CASO 6 NO PASA - El simbolo ^ es confundido con el operador OR
        //assertThrows(IllegalArgumentException.class, () -> calculadora.calcularFactorial(0^1));
        //CASO 9 NO PASA - El valor 5^-3 no es aceptado por la función
        //int resultado = (int) calculadora.calcularPotencia(5^-3);
        //assertEquals(8, resultado);
    }
    */
}