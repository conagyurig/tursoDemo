package com.conagyurig.tursoDemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("job")
public class Job {
    @Id
    @Column("id")
    private Integer id;
    @Column("createdAt")
    private String createdAt;
    @Column("status")
    private String status;

    public Job(String status) {
        this.status = status;
        this.createdAt = LocalDateTime.now().toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
