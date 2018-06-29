package com.finance.testproject.controller;


import com.finance.testproject.dto.ExecuteStartDTO;
import com.finance.testproject.dto.PipelineExecutionDTO;
import com.finance.testproject.model.Pipeline;
import com.finance.testproject.model.PipelineExecution;
import com.finance.testproject.service.PipelineExecutionService;
import com.finance.testproject.service.PipelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/execution")
public class PipelineExecutionController {

    @Autowired
    private PipelineExecutionService pipelineExecutionService;

    @Autowired
    private PipelineService pipelineService;

    @PostMapping("/start")
    @ResponseStatus(HttpStatus.OK)
    public PipelineExecutionDTO executePipeline(@RequestBody ExecuteStartDTO executeStartDTO) {
        Pipeline pipeline = pipelineService.findPipelineByName(executeStartDTO.getPipelineName());
        PipelineExecution pipelineExecution = pipelineExecutionService.executePipeline(pipeline);
        PipelineExecutionDTO pipelineExecutionDTO = new PipelineExecutionDTO(pipelineExecution);
        return pipelineExecutionDTO;
    }

}
