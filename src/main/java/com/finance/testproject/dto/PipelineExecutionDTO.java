package com.finance.testproject.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.finance.testproject.model.PipelineExecution;
import com.finance.testproject.model.Status;
import com.finance.testproject.model.Task;
import com.finance.testproject.model.Transition;

import java.sql.Timestamp;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PipelineExecutionDTO {

    private int executionId;
    private String pipeline;
    private Status status;
    private Timestamp startTime;
    private Timestamp endTime;
    private ExecutedTaskDTO[] tasks;

    public PipelineExecutionDTO(PipelineExecution pipelineExecution) {
        this.executionId = pipelineExecution.getExecutionId();
        this.pipeline = pipelineExecution.getPipeline().getName();
        this.status = pipelineExecution.getStatus();
        this.startTime = pipelineExecution.getStartTime();
        this.endTime = pipelineExecution.getEndTime();
        this.tasks = new ExecutedTaskDTO[pipelineExecution.getTasks().size()];
        int i = 0;
        for (Task x : pipelineExecution.getTasks()) {
            this.tasks[i] = new ExecutedTaskDTO(x);
            i++;
        }
    }

    public PipelineExecutionDTO() {

    }

    public int getExecutionId() {
        return executionId;
    }

    public void setExecutionId(int executionId) {
        this.executionId = executionId;
    }

    public String getPipeline() {
        return pipeline;
    }

    public void setPipeline(String pipeline) {
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

    public ExecutedTaskDTO[] getTasks() {
        return tasks;
    }

    public void setTasks(ExecutedTaskDTO[] tasks) {
        this.tasks = tasks;
    }
}
