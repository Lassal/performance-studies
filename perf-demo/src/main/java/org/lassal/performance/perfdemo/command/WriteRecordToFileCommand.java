package org.lassal.performance.perfdemo.command;

import org.lassal.performance.perfdemo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class WriteRecordToFileCommand  extends MeasurePerformanceCommand{

    private FileService service;

    public WriteRecordToFileCommand(int numberOfExecutions, FileService service){
        this.setNumberOfExecutions(numberOfExecutions);
        this.service = service;
    }

    @Override
    protected void executePerformanceTest() {
        try {
            this.service.writeRecordsToFile(this.getNumberOfExecutions());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String getTestName() {
        return "Write records of 192 bytes each in a file - Test write in file";
    }
}
