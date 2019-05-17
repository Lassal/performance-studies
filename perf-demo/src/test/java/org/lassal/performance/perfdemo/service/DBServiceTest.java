package org.lassal.performance.perfdemo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ComponentScan("org.lassal.performance.perfdemo.*")
@SpringBootTest
public class DBServiceTest {

    @Autowired
    private DBService dbService;

    @Test
    public void testRepository(){

      //  this.dbService = new DBService();

        // insere 2 registros
        this.dbService.addNewRecordPKOnlyTable();
        this.dbService.addNewRecordPKOnlyTable();

        assertEquals(2, this.dbService.countPKOnlyTableRecords());


    }

    @Test
    public void test100kInserts(){

        long start = System.nanoTime();

        this.dbService.addRecordSetRecordPKOnlyTable(10000);

        long end = System.nanoTime();

        double duration = ((double) end - (double) start) / 1000000000.00;

        System.out.println("Tempo decorrido: " + duration + " | Qtd: " + this.dbService.countPKOnlyTableRecords());
    }
}