package org.lassal.performance.webapi.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

public class FibonacciNumberTest {

    @Test
    public void testFibonacciNumber(){
        //Fibonacci sequence:  0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144

        long seq0Expected = 0;
        long seq1Expected = 1;
        long seq2Expected = 1;
        long seq3Expected = 2;
        long seq7Expected = 13;
        long seq12Expected = 144;

        FibonacciNumber seq0 = new FibonacciNumber(0);
        assertEquals(seq0Expected, seq0.getFibonacciNumber());

        FibonacciNumber seq1 = new FibonacciNumber(1);
        assertEquals(seq1Expected, seq1.getFibonacciNumber());

        FibonacciNumber seq2 = new FibonacciNumber(2);
        assertEquals(seq2Expected, seq2.getFibonacciNumber());

        FibonacciNumber seq3 = new FibonacciNumber(3);
        assertEquals(seq3Expected, seq3.getFibonacciNumber());

        FibonacciNumber seq7 = new FibonacciNumber(7);
        assertEquals(seq7Expected, seq7.getFibonacciNumber());

        FibonacciNumber seq12 = new FibonacciNumber(12);
        assertEquals(seq12Expected, seq12.getFibonacciNumber());

    }
}
