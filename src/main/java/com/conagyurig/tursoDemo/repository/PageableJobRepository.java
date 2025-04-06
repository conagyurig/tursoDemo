package com.conagyurig.tursoDemo.repository;

import com.conagyurig.tursoDemo.model.Job;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PageableJobRepository extends PagingAndSortingRepository<Job, Integer> {
}
