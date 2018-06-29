package com.finance.testproject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.finance.testproject.model.Status;
import com.finance.testproject.model.Task;

import java.sql.Timestamp;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExecutedTaskDTO {

    private String name;
    private Status status;
    private Timestamp startTime;
    private Timestamp endTime;

    public ExecutedTaskDTO() {

    }

    public ExecutedTaskDTO(Task task) {
        this.name = task.getName();
        this.status = task.getStatus();
        this.startTime = task.getStartTime();
        this.endTime = task.getEndTime();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
