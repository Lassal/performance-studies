package org.lassal.performance.perfdemo.service;

import org.lassal.performance.perfdemo.domain.FibonacciNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Component
public class WebRESTService {

    Logger logger = LoggerFactory.getLogger(WebRESTService.class);

    private String webApiURL;

    public void callRESTWebAPI(String url, int numberOfCalls, boolean sameCall){

        Random rand = new Random();
        RestTemplate restTemplate = new RestTemplate();
        String apiRequest = url + "/" + rand.nextInt(3000);

        logger.info("Web API base URL >> " + url);

        for(int i=0; i < numberOfCalls; i++){
           if(sameCall == false){
               apiRequest = url + "/" + rand.nextInt(3000);
           }
           FibonacciNumber fiboNum = restTemplate.getForObject(apiRequest, FibonacciNumber.class);
        }
    }

}
