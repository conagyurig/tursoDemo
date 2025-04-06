package com.conagyurig.tursoDemo.repository;

import com.conagyurig.tursoDemo.model.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends CrudRepository<Job, Integer> {
    List<Job> findByStatus(String status);

}

