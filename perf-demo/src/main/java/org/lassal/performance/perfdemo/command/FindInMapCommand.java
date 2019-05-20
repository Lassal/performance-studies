package org.lassal.performance.perfdemo.command;

import org.lassal.performance.perfdemo.service.FindMethodsService;
import org.springframework.beans.factory.annotation.Autowired;

public class FindInMapCommand  extends MeasurePerformanceCommand{

    private FindMethodsService service;

    public FindInMapCommand(int numberOfExecutions, FindMethodsService service){
        this.setNumberOfExecutions(numberOfExecutions);
        this.service = service;
    }

    @Override
    protected void executePerformanceTest() {
         this.service.findInMapNTimesRandom(this.getNumberOfExecutions());
    }

    @Override
    protected String getTestName() {
        return "Find item in Hashmap n times, in random order - Find item using hashmap";
    }
}
