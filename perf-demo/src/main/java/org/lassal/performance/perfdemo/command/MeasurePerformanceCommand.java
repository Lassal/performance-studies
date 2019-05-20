package org.lassal.performance.perfdemo.command;

public abstract class MeasurePerformanceCommand implements Command {

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

        System.out.println("\n----------------------------------------------------------------------");
        System.out.println(" :: Test scenario: " + this.getTestName());
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("%n    Number of executions: %d | Total time in seconds: %18.9f %n", this.getNumberOfExecutions(), durationSec);
        System.out.printf("%n    Executions per second: %18.9f %n", rate );
        System.out.printf("%n    Duration in ms: %18.9f %n", (durationNano / 1000000.00));
        System.out.printf("%n    Duration in minutes: %18.9f %n", (durationNano / 60000000000.00));
        System.out.println("-----------------------------------------------------------------------\n");

    }

}
