package com.finance.testproject.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.finance.testproject.deserializator.TransitionsDeserializer;
import com.finance.testproject.model.Transition;

import java.util.List;

@JsonDeserialize(using = TransitionsDeserializer.class)
public class TransitionsDTO {

    private List<Transition> transitions;

    public TransitionsDTO() {

    }

    public TransitionsDTO(List<Transition> transitions) {
        this.transitions = transitions;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<Transition> transitions) {
        this.transitions = transitions;
    }
}
