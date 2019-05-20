package org.lassal.performance.perfdemo.domain;

import javax.persistence.*;

@Entity
@Table(name = "TB_TenIdx")
public class MultiIndexTableRecord extends SimpleRecord{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected Long id;

    public MultiIndexTableRecord(){};


}
