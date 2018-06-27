package com.finance.testproject.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "pipeline_executions", schema = "public")
public class PipelineExecution {

    @GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "pipeline"))
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "execution_id", unique = true, nullable = false)
    private int executionId;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Pipeline pipeline;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "start_time")
    private Timestamp startTime;

    @Column(name = "end_time")
    private Timestamp endTime;

    @GenericGenerator(name = "task_gen", strategy = "foreign")
    @OneToOne(fetch = FetchType.EAGER)
    @Column
    private
}
