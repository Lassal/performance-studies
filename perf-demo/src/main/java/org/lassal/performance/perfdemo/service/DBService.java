package org.lassal.performance.perfdemo.service;

import org.lassal.performance.perfdemo.domain.PKOnlyTableRecord;
import org.lassal.performance.perfdemo.repository.PKOnlyTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBService {

    @Autowired
    private PKOnlyTableRepository repository;

    @Autowired
    private RecordBuilder recordBuilder;


    public PKOnlyTableRecord addNewRecordPKOnlyTable(){

       return repository.save(recordBuilder.createTableRecord());
    }

    public long countPKOnlyTableRecords(){
        return repository.count();
    }

}
