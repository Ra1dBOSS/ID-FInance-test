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

}
