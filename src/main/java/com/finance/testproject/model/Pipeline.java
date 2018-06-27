package com.finance.testproject.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "pipelines", schema = "public")
public class Pipeline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pipeline_id", nullable = false, unique = true)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "pipeline", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Task> tasks;

    @OneToMany(mappedBy = "pipeline", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Transition> transitions;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "pipeline", cascade = CascadeType.ALL)
    private PipelineExecution pipelineExecution;

    public Pipeline() {

    }

    public Pipeline(String name, String description, List<Task> tasks, Set<Transition> transitions) {
        this.name = name;
        this.description = description;
        this.tasks = tasks;
        this.transitions = transitions;
    }

    public int getId() {
        return id;
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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Set<Transition> getTransitions() {
        return transitions;
    }

    public void setTransitions(Set<Transition> transitions) {
        this.transitions = transitions;
    }

    public PipelineExecution getPipelineExecution() {
        return pipelineExecution;
    }

    public void setPipelineExecution(PipelineExecution pipelineExecution) {
        this.pipelineExecution = pipelineExecution;
    }
}
