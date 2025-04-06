package com.conagyurig.tursoDemo;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/{id}")
    public Job findJobById(@PathVariable Integer id) {
        return jobService.findJobById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "No job found with id " + id));
    }

    @GetMapping("/")
    public Page<Job> findAllJobsSorted(@RequestParam Integer page) {
        return jobService.getSortedPaginatedJobs(page);
    }

    @PostMapping("/")
    public Job createJob(String status) {
        return jobService.createJob(status);
    }

    @PostMapping("/{id}")
    public Job updateJob(@PathVariable Integer id, String status) {
        Job job = jobService.updateJob(id, status);
        if (job == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No job found with id " + id);
        }
        return job;
    }

    @DeleteMapping("/{id}")
    public Job deleteJob(@PathVariable Integer id) {
        Job job = jobService.deleteJob(id);
        if (job == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No job found with id " + id);
        }
        return job;
    }

    @PostMapping("/bulk")
    public List<Job> createJobs(@RequestBody StatusListDTO statusList) {
        return jobService.createJobs(statusList.getStatuses());
    }

}