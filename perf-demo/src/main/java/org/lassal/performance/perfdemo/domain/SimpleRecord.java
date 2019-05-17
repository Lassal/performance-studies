package org.lassal.performance.perfdemo.domain;

import java.util.Date;

public class SimpleRecord {

    private String field1;
    private Long field2;
    private Date field3;

    protected SimpleRecord() {}

    public SimpleRecord(String f1, Long f2, Date f3){
        this.field1 = f1;
        this.field2 = f2;
        this.field3 = f3;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public Long getField2() {
        return field2;
    }

    public void setField2(Long field2) {
        this.field2 = field2;
    }

    public Date getField3() {
        return field3;
    }

    public void setField3(Date field3) {
        this.field3 = field3;
    }
}
