package com.conagyurig.tursoDemo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends CrudRepository<Job, Integer> {
    List<Job> findByStatus(String status);

}

