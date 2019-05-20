package org.lassal.performance.perfdemo.command;

import org.lassal.performance.perfdemo.service.CNPJService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;




public class DoCPUOnlyProcessingCommand extends MeasurePerformanceCommand {

    //@Autowired
    private CNPJService service;

    public DoCPUOnlyProcessingCommand(int numberOfExecutions, CNPJService service){
        this.setNumberOfExecutions(numberOfExecutions);
        this.service = service;
    }

    @Override
    protected void executePerformanceTest() {
        try {
            this.service.calculateVerificationDigitNTimes(this.getNumberOfExecutions());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String getTestName() {
        return "Calculate CNPJ verification digit - CPU Only operation";
    }
}
