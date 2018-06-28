package com.finance.testproject.dto;

import com.finance.testproject.model.Action;
import com.finance.testproject.model.Task;

public class TaskDTO {
    private String name;
    private String desription;
    private ActionDTO action;

    public TaskDTO(Task task) {
        this.name = task.getName();
        this.desription = task.getDescription();
        this.action = new ActionDTO(task.getAction());
    }

    public Task getAsTask() {
        return new Task(name, desription, action.getAsAction());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }

    public ActionDTO getAction() {
        return action;
    }

    public void setAction(ActionDTO action) {
        this.action = action;
    }
}
