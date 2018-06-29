package com.finance.testproject.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finance.testproject.model.Action;

public class ActionDTO {

    private String type;

    public ActionDTO() {

    }

    public ActionDTO(Action action) {
        switch (action) {
            case completed: {
                this.type = "completed";
                break;
            }
            case delay: {
                this.type = "delay";
                break;
            }
            case random: {
                this.type = "random";
                break;
            }
            case print: {
                this.type = "print";
                break;
            }
        }
    }

    @JsonIgnore
    public Action getAsAction() {
        switch (type) {
            case "completed": {
                return Action.completed;
            }
            case "delay": {
            return Action.delay;
            }
            case "random": {
            return Action.random;
            }
            case "print": {
                return Action.print;
            }
        }
        return null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
