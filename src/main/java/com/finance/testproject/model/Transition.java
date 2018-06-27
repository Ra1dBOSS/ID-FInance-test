package com.finance.testproject.model;

import javax.persistence.*;

@Entity
@Table(name = "transitions", schema = "public")
public class Transition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String source;

    @Column
    private String target;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pipline_id", nullable = false)
    private Pipeline pipeline;

}
