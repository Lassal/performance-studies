package org.lassal.performance.perfdemo.service;

import org.lassal.performance.perfdemo.domain.PKOnlyTableRecord;
import org.lassal.performance.perfdemo.repository.PKOnlyTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DBService {

    @Autowired
    private PKOnlyTableRepository repository;

    @Autowired
    private RecordBuilder recordBuilder;


    public PKOnlyTableRecord addNewRecordPKOnlyTable(){

       return repository.save(recordBuilder.createTableRecord());
    }

    public void addRecordSetRecordPKOnlyTable(int recordSetSize){
        ArrayList recordSet = new ArrayList(recordSetSize);
        int recordsWritten = 0;

        while(recordsWritten < recordSetSize){
            recordSet.clear();
            for(int i=0; (i< 500) && (recordsWritten < recordSetSize); i++){
                recordSet.add(this.recordBuilder.createTableRecord());
                recordsWritten++;
            }
            this.repository.saveAll(recordSet);
        }
    }

    public long countPKOnlyTableRecords(){
        return repository.count();
    }

}
