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
}