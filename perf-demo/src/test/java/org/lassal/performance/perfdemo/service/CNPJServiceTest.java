package org.lassal.performance.perfdemo.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class CNPJServiceTest {

    @Test
    public void calculaDigitoVerificador() throws Exception {

        CNPJService cnpjService = new CNPJService();

        String expectedCnpj = "14.572.457.0001-85";
        String raizCnpj = "14.572.457.0001";

        String actualCnpj = cnpjService.calculaDigitoVerificador(raizCnpj);

        assertEquals(expectedCnpj, actualCnpj);

    }

    @Test
    public void calculaDV10kTimes() throws Exception {

        String raizCnpj = "14.572.457.0001";

        CNPJService cnpjService = new CNPJService();

        long start = System.nanoTime();

        for(int i=0; i< 100000; i++){
            cnpjService.calculaDigitoVerificador(raizCnpj);
        }

        long end = System.nanoTime();

        double duration = ((double) end - (double) start) / 1000000000.00;

        System.out.println("Tempo decorrido: " + duration);
    }
}