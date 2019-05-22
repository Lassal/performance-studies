package org.lassal.performance.perfdemo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ComponentScan("org.lassal.performance.perfdemo.*")
@SpringBootTest
public class FileServiceTest {

    Logger logger = LoggerFactory.getLogger(FileServiceTest.class);

    @Autowired
    private FileService fileService;


    @Test
    public void writeRecordsToFile() throws IOException {

        this.fileService.writeRecordsToFile(100);
    }

    @Test
    public void test100kInserts() throws IOException {

        long start = System.nanoTime();

        this.fileService.writeRecordsToFile(100000);

        long end = System.nanoTime();

        double duration = ((double) end - (double) start) / 1000000000.00;

        logger.info("Tempo decorrido: " + duration );
    }
}