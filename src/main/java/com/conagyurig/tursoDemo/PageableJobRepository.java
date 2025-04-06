package com.conagyurig.tursoDemo;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PageableJobRepository extends PagingAndSortingRepository<Job, Integer> {
}
