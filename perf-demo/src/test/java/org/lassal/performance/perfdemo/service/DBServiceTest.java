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
//@DataJpaTest
@SpringBootTest
public class DBServiceTest {

    @Autowired
    private DBService dbService;

    //@Autowired
    private TestEntityManager entityManager;

    private final int TEST_SIZE = 15000;

    @Test
    public void test100kInsertsMultiIndexTable(){

        long start = System.nanoTime();

        this.dbService.addRecordSetRecordMultiIndexTable(this.TEST_SIZE);

        long end = System.nanoTime();

        double duration = ((double) end - (double) start) / 1000000000.00;

        System.out.println("Tempo decorrido INSERT MULTI INDEX: " + duration + " | Qtd: " + this.dbService.countMultiIndexTableRecords());
    }

    @Test
    public void test100kInsertsPKOnlyTable(){

        long start = System.nanoTime();

        this.dbService.addRecordSetRecordPKOnlyTable(this.TEST_SIZE);

        long end = System.nanoTime();

        double duration = ((double) end - (double) start) / 1000000000.00;

        System.out.println("Tempo decorrido INSERT PK ONLY: " + duration + " | Qtd: " + this.dbService.countPKOnlyTableRecords());
    }


}

