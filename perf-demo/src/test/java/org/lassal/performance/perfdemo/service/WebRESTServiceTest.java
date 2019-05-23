package org.lassal.performance.perfdemo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ComponentScan("org.lassal.performance.perfdemo.*")
@SpringBootTest
public class WebRESTServiceTest {

    Logger logger = LoggerFactory.getLogger(FindMethodsServiceTest.class);

    @Autowired
    private WebRESTService service;

    @Value( "${perfdemo.webapiserver.url}" )
    private String webApiURL;

    @Test
    public void callRESTWebAPI() {

        int numberOfHits = 100000;

        long start = System.nanoTime();

        this.service.callRESTWebAPI(this.webApiURL, numberOfHits, false);

        long end = System.nanoTime();

        double duration = ((double) end - (double) start) / 1000000000.00;

        logger.info("Tempo decorrido Web API call: " + duration + " | Number of calls: " + numberOfHits );
    }
}