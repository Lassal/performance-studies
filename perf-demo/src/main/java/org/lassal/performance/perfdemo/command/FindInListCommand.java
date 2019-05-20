package org.lassal.performance.perfdemo.command;

import org.lassal.performance.perfdemo.service.FindMethodsService;
import org.springframework.beans.factory.annotation.Autowired;

public class FindInListCommand  extends MeasurePerformanceCommand{


    private FindMethodsService service;

    public FindInListCommand(int numberOfExecutions, FindMethodsService service){
        this.setNumberOfExecutions(numberOfExecutions);
        this.service = service;
    }

    @Override
    protected void executePerformanceTest() {

        this.service.findInListNTimesRandom(this.getNumberOfExecutions());
    }

    @Override
    protected String getTestName() {
        return "Find item in list n times, in random order - Find item sequentially";
    }
}
