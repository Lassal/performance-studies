package org.lassal.performance.perfdemo.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PKOnlyTable")
public class PKOnlyTableRecord extends SimpleRecord {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    protected PKOnlyTableRecord(){};

    public PKOnlyTableRecord(String f1, Long f2, Date f3){
        super(f1, f2, f3);
    }
}
