package org.lassal.performance.perfdemo.service;

import org.lassal.performance.perfdemo.domain.FibonacciNumber;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Component
public class WebRESTService {

    public void callRESTWebAPI(int numberOfCalls, boolean sameCall){

        String webApiURL = "http://localhost:9510/fibonacci/";
        Random rand = new Random();
        RestTemplate restTemplate = new RestTemplate();
        String apiRequest = webApiURL + "/" + rand.nextInt(3000);

        for(int i=0; i < numberOfCalls; i++){
           if(sameCall == false){
               apiRequest = webApiURL + "/" + rand.nextInt(3000);
           }
           FibonacciNumber fiboNum = restTemplate.getForObject(apiRequest, FibonacciNumber.class);
        }
    }

    public void callRESTWebAPI(int numberOfCalls){
        this.callRESTWebAPI(numberOfCalls, true);
    }
}
