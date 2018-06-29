package com.finance.testproject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExecuteStartTO {

    @JsonProperty("pipeline name")
    private String pipelineName;

    public String getPipelineName() {
        return pipelineName;
    }

    public void setPipelineName(String pipelineName) {
        this.pipelineName = pipelineName;
    }
}
