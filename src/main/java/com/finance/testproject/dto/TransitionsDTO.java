package com.finance.testproject.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.finance.testproject.deserializer.TransitionsDeserializer;
import com.finance.testproject.model.Transition;
import com.finance.testproject.serializer.TransitionsSerializer;

import java.util.List;

@JsonDeserialize(using = TransitionsDeserializer.class)
@JsonSerialize(using = TransitionsSerializer.class)
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
