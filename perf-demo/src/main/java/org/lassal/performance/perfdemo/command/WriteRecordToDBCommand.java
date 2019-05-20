package org.lassal.performance.perfdemo.command;

import org.lassal.performance.perfdemo.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;

public class WriteRecordToDBCommand  extends MeasurePerformanceCommand {


    @Autowired
    private DBService service;

    public WriteRecordToDBCommand(int numberOfExecutions, DBService service){
        this.setNumberOfExecutions(numberOfExecutions);
        this.service = service;
    }

    @Override
    protected void executePerformanceTest() {
         this.service.addRecordSetRecordPKOnlyTable(this.getNumberOfExecutions());
    }

    @Override
    protected String getTestName() {
        return "Insert N records in a table with only PK as index - Test write to the database";
    }
}
