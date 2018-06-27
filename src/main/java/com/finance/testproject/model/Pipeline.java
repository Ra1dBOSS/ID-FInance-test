package com.finance.testproject.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pipelines", schema = "public")
public class Pipeline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name = "description")
    private String description;

//    @Column
//    private List<Task> tasks;

}
