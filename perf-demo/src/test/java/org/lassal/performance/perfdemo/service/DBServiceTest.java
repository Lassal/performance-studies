package org.lassal.performance.perfdemo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lassal.performance.perfdemo.domain.PKOnlyTableRecord;
import org.lassal.performance.perfdemo.repository.PKOnlyTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DBServiceTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PKOnlyTableRepository repository;

    @Test
    public void testRepository(){
        PKOnlyTableRecord record = new PKOnlyTableRecord("AAAA", 1500L, new Date());
        this.repository.save(record);

        PKOnlyTableRecord record2 = new PKOnlyTableRecord("BBBBDDDDD", 19000L, new Date());
        this.repository.save(record2);

        assertEquals(2, this.repository.count());


    }
}
