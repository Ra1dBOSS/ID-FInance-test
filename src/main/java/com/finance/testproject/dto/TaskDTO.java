package com.finance.testproject.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finance.testproject.model.Task;

public class TaskDTO {
    private String name;
    private String description;
    private ActionDTO action;

    public TaskDTO() {

    }

    public TaskDTO(Task task) {
        this.name = task.getName();
        this.description = task.getDescription();
        this.action = new ActionDTO(task.getAction());
    }

    @JsonIgnore
    public Task getAsTask() {
        return new Task(name, description, action.getAsAction());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ActionDTO getAction() {
        return action;
    }

    public void setAction(ActionDTO action) {
        this.action = action;
    }
}
