package org.lassal.performance.perfdemo.repository;

import org.lassal.performance.perfdemo.domain.PKOnlyTableRecord;
import org.springframework.data.repository.CrudRepository;

public interface PKOnlyTableRepository extends CrudRepository<PKOnlyTableRecord, Long>{


}
