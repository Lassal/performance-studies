package org.lassal.performance.perfdemo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FindMethodsServiceTest {

    private final int NUMBER_EXECUTIONS = 100000;

    @Autowired
    private FindMethodsService findService;

    @Test
    public void findInList100KTimesSequential() {

        long start = System.nanoTime();

        this.findService.findInListNTimesSequential(this.NUMBER_EXECUTIONS);

        long end = System.nanoTime();

        double duration = ((double) end - (double) start) / 1000000000.00;

        System.out.println("Tempo decorrido Lista: " + duration);

    }

    @Test
    public void findInMap100KTimesSequential() {
        long start = System.nanoTime();

        this.findService.findInMapNTimesSequential(this.NUMBER_EXECUTIONS);

        long end = System.nanoTime();

        double duration = ((double) end - (double) start) / 1000000000.00;

        System.out.println("Tempo decorrido Mapa : " + duration);
    }

    @Test
    public void findInListNTimesRandom() {
        long start = System.nanoTime();

        this.findService.findInListNTimesRandom(this.NUMBER_EXECUTIONS);

        long end = System.nanoTime();

        double duration = ((double) end - (double) start) / 1000000000.00;

        System.out.println("Tempo decorrido Lista: " + duration);

    }

    @Test
    public void findInMapNTimesRandom() {
        long start = System.nanoTime();

        this.findService.findInMapNTimesRandom(this.NUMBER_EXECUTIONS);

        long end = System.nanoTime();

        double duration = ((double) end - (double) start) / 1000000000.00;

        System.out.println("Tempo decorrido Mapa : " + duration);
    }
}