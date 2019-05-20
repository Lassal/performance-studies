package org.lassal.performance.perfdemo.command;

public class HelpCommand implements Command {

    @Override
    public void execute() {
        System.out.println("");
        System.out.println("========================================================");
        System.out.println("   PERFORMANCE DEMO TOOL");
        System.out.println("========================================================");
        System.out.println("Usage :");
        System.out.println("     --n=<number of executions> -test=< OnlyCPU | FileWrite | DBWrite | DBWrite10Indx | WebApiCall | FindInList | FindInHash >");
        System.out.println("");
    }

}
