package org.lassal.performance.perfdemo.repository;

import org.lassal.performance.perfdemo.domain.MultiIndexTableRecord;
import org.springframework.data.repository.CrudRepository;

public interface MultiIndexTableRepository extends CrudRepository<MultiIndexTableRecord, Long> {

}
