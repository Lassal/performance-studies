package org.lassal.performance.webapi.controller;

import org.lassal.performance.webapi.domain.FibonacciNumber;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FibonacciController {

    @RequestMapping("/fibonacci/{seqnumber}")
    public FibonacciNumber getFibonacciSequence(@PathVariable("seqnumber")int sequenceNumber){

        return new FibonacciNumber(sequenceNumber);
    }
}
