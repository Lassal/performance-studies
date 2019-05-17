package org.lassal.performance.perfdemo.domain;

import java.util.Date;

public class SimpleRecord {

    protected String field1;
    protected Long field2;
    protected Date field3;
    protected String field4;
    protected double field5;
    protected String field6;
    protected String field7;
    protected Long field8;
    protected String field9;
    protected Date field10;

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

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public double getField5() {
        return field5;
    }

    public void setField5(double field5) {
        this.field5 = field5;
    }

    public String getField6() {
        return field6;
    }

    public void setField6(String field6) {
        this.field6 = field6;
    }

    public String getField7() {
        return field7;
    }

    public void setField7(String field7) {
        this.field7 = field7;
    }

    public Long getField8() {
        return field8;
    }

    public void setField8(Long field8) {
        this.field8 = field8;
    }

    public String getField9() {
        return field9;
    }

    public void setField9(String field9) {
        this.field9 = field9;
    }

    public Date getField10() {
        return field10;
    }

    public void setField10(Date field10) {
        this.field10 = field10;
    }
}
