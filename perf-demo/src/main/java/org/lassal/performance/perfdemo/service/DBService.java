package org.lassal.performance.perfdemo.service;

import org.lassal.performance.perfdemo.domain.MultiIndexTableRecord;
import org.lassal.performance.perfdemo.domain.PKOnlyTableRecord;
import org.lassal.performance.perfdemo.repository.MultiIndexTableRepository;
import org.lassal.performance.perfdemo.repository.PKOnlyTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DBService {

    @Autowired
    private PKOnlyTableRepository pkOnlyTableRepository;

    @Autowired
    private MultiIndexTableRepository multiIndexTableRepository;

    @Autowired
    private RecordBuilder recordBuilder;


    public PKOnlyTableRecord addNewRecordPKOnlyTable(){

       return pkOnlyTableRepository.save(recordBuilder.createPKOnlyTableRecord());
    }

    public void addRecordSetRecordPKOnlyTable(int recordSetSize){
        ArrayList<PKOnlyTableRecord> recordSet = new ArrayList(recordSetSize);
        int recordsWritten = 0;

        while(recordsWritten < recordSetSize){
            recordSet.clear();
            for(int i=0; (i< 500) && (recordsWritten < recordSetSize); i++){
                recordSet.add(this.recordBuilder.createPKOnlyTableRecord());
                recordsWritten++;
            }
            this.pkOnlyTableRepository.saveAll(recordSet);
        }
    }

    public long countPKOnlyTableRecords(){
        return pkOnlyTableRepository.count();
    }


    public MultiIndexTableRecord addNewRecordMultiIndexTable(){

        return multiIndexTableRepository.save(recordBuilder.createMultiIndexTableRecord());
    }

    public void addRecordSetRecordMultiIndexTable(int recordSetSize){
        ArrayList<MultiIndexTableRecord> recordSet = new ArrayList(recordSetSize);
        int recordsWritten = 0;

        while(recordsWritten < recordSetSize){
            recordSet.clear();
            for(int i=0; (i< 500) && (recordsWritten < recordSetSize); i++){
                recordSet.add(this.recordBuilder.createMultiIndexTableRecord());
                recordsWritten++;
            }
            this.multiIndexTableRepository.saveAll(recordSet);
        }
    }

    public long countMultiIndexTableRecords(){
        return multiIndexTableRepository.count();
    }


}
