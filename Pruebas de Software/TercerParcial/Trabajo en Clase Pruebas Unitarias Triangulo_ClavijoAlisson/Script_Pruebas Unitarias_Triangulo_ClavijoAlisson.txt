/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.triangulo_app;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alisson Clavijo
 */
public class TrianguloTest {

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }
    
   
 
    @Test
     //(Entrada  = 5,5,8, Salida= Equilátero)
    public void testTipoTrianguloEquilatero() {
        Triangulo triangulo = new Triangulo(5, 5, 5);
        assertEquals("Equilátero", triangulo.tipoTriangulo());
    }
     
    
    
    /*
    @Test
    //(Entrada  = 5, 5,5, Salida= Isósceles)
    public void testTipoTrianguloIsosceles() {
        Triangulo triangulo = new Triangulo(5, 5, 8);
        assertEquals("Isósceles", triangulo.tipoTriangulo());
    }
    */
    
    /*
    @Test
     //(Entrada  = 3,4,5, Salida= Escaleno)
    
    
    public void testTipoTrianguloEscaleno() {
        Triangulo triangulo = new Triangulo(3, 4, 5);
        assertEquals("Escaleno", triangulo.tipoTriangulo());
    }
    */
    
     /*
    @Test
   //(Entrada  = 1,3,1, Salida= Triangulo no valido)
    public void testEsTrianguloValido() {
        Triangulo triangulo = new Triangulo(3, 4, 5);
        assertTrue(triangulo.esTriangulo());
    }
     */
    
     /*
    @Test
    //(Entrada  = 1, -,1, Salida= Error)
    public void testNoEsTrianguloValidoError() {
        Triangulo triangulo = new Triangulo(1, - , 1);
        assertFalse(triangulo.esTriangulo());
    }
    */
    
    /*
       @Test
    //(Entrada  = -, 2,3, Salida= Error)
    public void testNoEsTrianguloValidoError() {
        Triangulo triangulo = new Triangulo(-, 2 , 3);
        assertFalse(triangulo.esTriangulo());
    }
   
     /*
    
    /*
       @Test
    //(Entrada= 8, -3,9, Salida=Triangulo no valido)
    public void testNoEsTrianguloValido() {
        Triangulo triangulo = new Triangulo(3, 4, 5);
        assertTrue(triangulo.esTriangulo());
    }
   /*
    
    /*
        @Test
    //(Entrada= 5, 7,-2, Salida=Triangulo no valido)
    public void testNoEsTrianguloValido() {
        Triangulo triangulo = new Triangulo(5, 7, -2);
        assertTrue(triangulo.esTriangulo());
    }
     */
    
    /*
        @Test
    //(Entrada= 1, 3, a, Salida= Error)
    public void testNoEsTrianguloValido() {
        Triangulo triangulo = new Triangulo(1, 3, a);
        assertTrue(triangulo.esTriangulo());
    }
     */
    
    /*
      @Test
    //(Entrada= 4, 5, b, Salida= Error)
    public void testNoEsTrianguloValido() {
        Triangulo triangulo = new Triangulo(4, 5, b);
        assertTrue(triangulo.esTriangulo());
    }
    
 */
    
    
    
}


