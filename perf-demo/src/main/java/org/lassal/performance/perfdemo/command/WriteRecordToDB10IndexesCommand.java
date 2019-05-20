package org.lassal.performance.perfdemo.command;

import org.lassal.performance.perfdemo.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;

public class WriteRecordToDB10IndexesCommand extends MeasurePerformanceCommand {

    private DBService service;

    public WriteRecordToDB10IndexesCommand(int numberOfExecutions, DBService service){
        this.setNumberOfExecutions(numberOfExecutions);
        this.service = service;
    }

    @Override
    protected void executePerformanceTest() {
         this.service.addRecordSetRecordMultiIndexTable(this.getNumberOfExecutions());
    }

    @Override
    protected String getTestName() {
        return "Insert N records in a table with 10 indexes - Test write in database with multiple indexes";
    }
}
