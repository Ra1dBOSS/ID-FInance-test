package com.finance.testproject.dto;

import com.finance.testproject.model.Action;
import com.finance.testproject.model.Pipeline;
import com.finance.testproject.model.Task;
import com.finance.testproject.model.Transition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PipelineDTO {

    private String name;
    private String description;
    private TaskDTO[] tasks;
    private Transition[] transitions;

    public PipelineDTO(Pipeline pipeline) {
        this.name = pipeline.getName();
        this.description = pipeline.getDescription();
        this.tasks = new TaskDTO[pipeline.getTasks().size()];
        int i = 0;
        for (Task x : pipeline.getTasks()) {
            this.tasks[i] = new TaskDTO(x);
            i++;
        }
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

    public List<Task> getTasksAsList() {
        List<Task> ret = new ArrayList<>(tasks.length);
        for (TaskDTO x : tasks)
            ret.add(x.getAsTask());
        return ret;
    }

    public Transition[] getTransitions() {
        return transitions;
    }

    public void setTransitions(Transition[] transitions) {
        this.transitions = transitions;
    }

    public Set<Transition> getTransitionsAsSet() {
        Set<Transition> ret = new HashSet<>();
        for (Transition x : transitions)
            ret.add(x);
        return ret;
    }
}
