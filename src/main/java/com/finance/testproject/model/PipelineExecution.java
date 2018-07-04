package com.finance.testproject.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pipeline_executions")
public class PipelineExecution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "execution_id", unique = true, nullable = false)
    private int executionId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pipeline_id")
    private Pipeline pipeline;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "start_time")
    private Timestamp startTime;

    @Column(name = "end_time")
    private Timestamp endTime;

    @OneToMany(mappedBy = "pipelineExecution", fetch = FetchType.EAGER, cascade = {CascadeType.DETACH
            , CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE, CascadeType.PERSIST})
    private List<Task> tasks;

    public PipelineExecution() {

    }

    public PipelineExecution(Pipeline pipeline) {
        this.pipeline = pipeline;
        this.status = null;
        this.tasks = new ArrayList<>(pipeline.getTasks().size());
        for (Task x : pipeline.getTasks()) {
            Task task = new Task(x.getName(), x.getDescription(), x.getAction());
            task.setPipelineExecution(this);
            this.tasks.add(task);
        }
        this.startTime = new Timestamp(System.currentTimeMillis());
    }

    public int getExecutionId() {
        return executionId;
    }

    public Pipeline getPipeline() {
        return pipeline;
    }

    public void setPipeline(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PipelineExecution that = (PipelineExecution) o;
        return executionId == that.executionId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(executionId);
    }
}
