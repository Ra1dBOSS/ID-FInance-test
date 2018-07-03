package com.finance.testproject.controller;


import com.finance.testproject.dto.PipelineExecutionDTO;
import com.finance.testproject.model.PipelineExecution;
import com.finance.testproject.service.PipelineExecutionService;
import com.finance.testproject.service.PipelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/pipeline_execution", produces = "application/x-yaml")
public class PipelineExecutionController {

    @Autowired
    private PipelineExecutionService pipelineExecutionService;

    @Autowired
    private PipelineService pipelineService;

    @PostMapping("/execute/{name}")
    @ResponseStatus(HttpStatus.CREATED)
    public PipelineExecutionDTO executePipeline(@PathVariable String name) {
        PipelineExecution pipelineExecution = pipelineExecutionService.executePipeline(name);
        PipelineExecutionDTO pipelineExecutionDTO = new PipelineExecutionDTO(pipelineExecution);
        return pipelineExecutionDTO;
    }

}
