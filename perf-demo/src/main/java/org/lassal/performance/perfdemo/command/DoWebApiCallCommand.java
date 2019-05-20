package org.lassal.performance.perfdemo.command;

import org.lassal.performance.perfdemo.service.WebRESTService;
import org.springframework.beans.factory.annotation.Autowired;

public class DoWebApiCallCommand  extends MeasurePerformanceCommand{

    private WebRESTService service;

    public DoWebApiCallCommand(int numberOfExecutions, WebRESTService service){
        this.setNumberOfExecutions(numberOfExecutions);
        this.service = service;
    }



    @Override
    protected void executePerformanceTest() {
        this.service.callRESTWebAPI(this.getNumberOfExecutions(), false);
    }

    @Override
    protected String getTestName() {
        return "Call Web API Rest - Test interprocess latency";
    }
}
