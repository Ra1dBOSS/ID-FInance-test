package com.finance.testproject.model;

import javax.persistence.*;

@Entity
@Table(name = "tasks", schema = "public")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    @Column
    private Action action;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pipline_id", nullable = false)
    private Pipeline pipeline;

    @Enumerated(EnumType.STRING)
    @Column
    private Status status;


}
