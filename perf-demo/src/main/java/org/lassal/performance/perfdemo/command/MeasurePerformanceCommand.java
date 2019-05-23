package org.lassal.performance.perfdemo.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class MeasurePerformanceCommand implements Command {

    Logger logger = LoggerFactory.getLogger(MeasurePerformanceCommand.class);

    private int numberOfExecutions = 1000;

    protected abstract void executePerformanceTest();

    protected abstract String getTestName();

    public void setNumberOfExecutions(int numberOfExecutions){
        this.numberOfExecutions = numberOfExecutions;
    }

    public int getNumberOfExecutions(){
        return this.numberOfExecutions;
    }

    @Override
    public void execute(){
        Long start = System.nanoTime();

        this.executePerformanceTest();

        Long end = System.nanoTime();

        this.printExecutionStats(start, end);
    }

    protected void printExecutionStats(Long start, Long end){
        Long durationNano = end - start;
        double durationSec = durationNano / 1000000000.00;
        double rate = this.numberOfExecutions / durationSec;

        double timePerExec =  (durationNano/(double)this.numberOfExecutions);

        StringBuilder report = new StringBuilder();
        report.append(" Test results ---> \n");
        report.append("\n----------------------------------------------------------------------");
        report.append("\n :: Test scenario: " + this.getTestName());
        report.append("\n----------------------------------------------------------------------");
        report.append(String.format("%n    Number of executions: %d | Total time in seconds: %18.9f %n", this.getNumberOfExecutions(), durationSec));
        report.append(String.format("%n    Executions per second: %18.9f %n", rate ));
        report.append(String.format("%n    Time per execution in micros: %18.9f %n", timePerExec / 1000.00));
        report.append(String.format("%n    Duration in ms: %18.9f %n", (durationNano / 1000000.00)));
        report.append(String.format("%n    Duration in minutes: %18.9f %n", (durationNano / 60000000000.00)));
        report.append("\n-----------------------------------------------------------------------\n");

        logger.info(report.toString());

    }

}
