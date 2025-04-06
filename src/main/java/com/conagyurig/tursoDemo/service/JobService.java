package com.conagyurig.tursoDemo.service;

import com.conagyurig.tursoDemo.model.Job;
import com.conagyurig.tursoDemo.repository.JobRepository;
import com.conagyurig.tursoDemo.repository.PageableJobRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class JobService {
    private final JobRepository jobRepository;
    private final PageableJobRepository pageableJobRepository;
    public JobService(JobRepository jobRepository, PageableJobRepository pageableJobRepository) {
        this.jobRepository = jobRepository;
        this.pageableJobRepository = pageableJobRepository;
    }

    public Optional<Job> findJobById(Integer id) {
        return jobRepository.findById(id);
    }

    public Job createJob(String status) {
        return jobRepository.save(new Job(status));
    }

    public Job updateJob(Integer id, String status) {
        Optional<Job> foundJob = jobRepository.findById(id);
        if (foundJob.isEmpty()) {
            return null;
        }
        Job job = foundJob.get();
        job.setStatus(status);
        return jobRepository.save(job);
    }

    public Job deleteJob(Integer id) {
        Optional<Job> foundJob = jobRepository.findById(id);
        if (foundJob.isEmpty()) {
            return null;
        }
        jobRepository.deleteById(id);
        return foundJob.get();
    }

    public Page<Job> getSortedPaginatedJobs(Integer page) {
        Pageable jobPage = PageRequest.of(page, 10, Sort.by("createdAt"));
        return pageableJobRepository.findAll(jobPage);
    }

    public List<Job> createJobs(List<String> statuses) {
        List<Job> jobs = new ArrayList<>();
        for (String status : statuses) {
            jobs.add(new Job(status));
        }
        return (List<Job>) jobRepository.saveAll(jobs);
    }
}
