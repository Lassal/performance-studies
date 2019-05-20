package org.lassal.performance.perfdemo.service;

import org.lassal.performance.perfdemo.repository.SimpleRecordFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class FileService {

    @Autowired
    private RecordBuilder recordBuilder;

    public void writeRecordsToFile(int numberRecords, String fileName) throws IOException {

        try(SimpleRecordFileRepository repository = new SimpleRecordFileRepository()){
            repository.open(fileName, false, 1000);

            for(int i=0; i < numberRecords; i++){

                repository.save(this.recordBuilder.createPKOnlyTableRecord());
            }
        }

    }

    public void writeRecordsToFile(int numberRecords) throws IOException {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileName = df.format(new Date()) + ".out";

        this.writeRecordsToFile(numberRecords, fileName);
    }
}
