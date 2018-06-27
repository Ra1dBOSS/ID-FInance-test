package com.finance.testproject.model;

import javax.persistence.*;
import java.util.Objects;

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

    public Transition() {

    }

    public Transition(String source, String target, Pipeline pipeline) {
        this.source = source;
        this.target = target;
        this.pipeline = pipeline;
    }

    public int getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public String getTarget() {
        return target;
    }

    public Pipeline getPipeline() {
        return pipeline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transition that = (Transition) o;
        return id == that.id &&
                Objects.equals(source, that.source) &&
                Objects.equals(target, that.target);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, source, target);
    }
}
