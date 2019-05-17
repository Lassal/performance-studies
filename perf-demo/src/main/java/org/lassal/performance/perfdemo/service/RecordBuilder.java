package org.lassal.performance.perfdemo.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.lassal.performance.perfdemo.domain.PKOnlyTableRecord;
import org.springframework.stereotype.Component;

import java.util.Date;



@Component
public class RecordBuilder {

    public PKOnlyTableRecord createTableRecord(){

        PKOnlyTableRecord rec = new PKOnlyTableRecord();
        rec.setField1(this.getRandomString(13));
        rec.setField2(111222333444555666L);
        rec.setField3(new Date());
        rec.setField4(this.getRandomString(15));
        rec.setField5(Math.PI);
        rec.setField6(this.getRandomString(12));
        rec.setField7(this.getRandomString(18));
        rec.setField8(987654321123456789L);
        rec.setField9(this.getRandomString(14));
        rec.setField10(new Date());

        return rec;
    }

    private String getRandomString(int length){
        return RandomStringUtils.random(length, true, true);
    }
}
