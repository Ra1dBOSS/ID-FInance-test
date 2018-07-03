package com.finance.testproject.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finance.testproject.model.Pipeline;
import com.finance.testproject.model.Task;
import com.finance.testproject.model.Transition;

import java.util.ArrayList;
import java.util.List;

public class PipelineDTO {

    private String name;
    private String description;
    private TaskDTO[] tasks;
    private TransitionsDTO transitions;

    public PipelineDTO() {

    }

    public PipelineDTO(String name, String description, TaskDTO[] tasks, TransitionsDTO transitions) {
        this.name = name;
        this.description = description;
        this.tasks = tasks;
        this.transitions = transitions;
    }

    public PipelineDTO(Pipeline pipeline) {
        this.name = pipeline.getName();
        this.description = pipeline.getDescription();
        this.tasks = new TaskDTO[pipeline.getTasks().size()];
        int i = 0;
        for (Task x : pipeline.getTasks()) {
            this.tasks[i] = new TaskDTO(x);
            i++;
        }
        this.transitions = new TransitionsDTO(pipeline.getTransitions());
    }

    @JsonIgnore
    public List<Transition> getTransitionsAsList() {
        return this.transitions.getTransitions();
    }

    @JsonIgnore
    public List<Task> getTasksAsList() {
        List<Task> ret = new ArrayList<>(tasks.length);
        for (TaskDTO x : tasks)
            ret.add(x.getAsTask());
        return ret;
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

    public TaskDTO[] getTasks() {
        return tasks;
    }

    public void setTasks(TaskDTO[] tasks) {
        this.tasks = tasks;
    }

    public TransitionsDTO getTransitions() {
        return transitions;
    }

    public void setTransitions(TransitionsDTO transitions) {
        this.transitions = transitions;
    }
}
