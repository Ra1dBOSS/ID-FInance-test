package com.finance.testproject.controller;


import com.finance.testproject.dto.PipelineExecutionDTO;
import com.finance.testproject.model.PipelineExecution;
import com.finance.testproject.service.PipelineExecutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/pipeline_execution", produces = "application/x-yaml")
public class PipelineExecutionController {

    @Autowired
    private PipelineExecutionService pipelineExecutionService;

    @PostMapping("/execute/{name}")
    @ResponseStatus(HttpStatus.CREATED)
    public PipelineExecutionDTO executePipeline(@PathVariable String name) {
        PipelineExecution pipelineExecution = pipelineExecutionService.executePipeline(name);
        PipelineExecutionDTO pipelineExecutionDTO = new PipelineExecutionDTO(pipelineExecution);
        return pipelineExecutionDTO;
    }

    @GetMapping("/show_status/{executionId}")
    @ResponseStatus(HttpStatus.OK)
    public PipelineExecutionDTO showPipelineExecutionStatus(@PathVariable int executionId) {
        PipelineExecution pipelineExecution = pipelineExecutionService.showPipelineExecutionStatus(executionId);
        PipelineExecutionDTO pipelineExecutionDTO = new PipelineExecutionDTO(pipelineExecution);
        return pipelineExecutionDTO;
    }

    @PostMapping("/stop/{executionId}")
    @ResponseStatus(HttpStatus.OK)
    public PipelineExecutionDTO stopPipelineExecution(@PathVariable int executionId) {
        PipelineExecution pipelineExecution = pipelineExecutionService.showPipelineExecutionStatus(executionId);
        PipelineExecutionDTO pipelineExecutionDTO = new PipelineExecutionDTO(pipelineExecution);
        return pipelineExecutionDTO;
    }

}
