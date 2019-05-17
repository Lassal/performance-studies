package org.lassal.performance.perfdemo.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_PKONLY")
public class PKOnlyTableRecord extends SimpleRecord {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    public PKOnlyTableRecord(){};


}