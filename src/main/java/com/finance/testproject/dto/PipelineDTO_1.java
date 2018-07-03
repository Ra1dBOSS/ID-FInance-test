package com.finance.testproject.dto;

public class PipelineDTO_1 {

    private String name;
    private String description;
    private TaskDTO[] tasks;
    private TransitionsDTO transitions;

    public PipelineDTO_1() {

    }

    public PipelineDTO_1(String name, String description, TaskDTO[] tasks, TransitionsDTO transitions) {
        this.name = name;
        this.description = description;
        this.tasks = tasks;
        this.transitions = transitions;
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
