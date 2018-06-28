package com.finance.testproject.controller;

import com.finance.testproject.dao.PipelineDAO;
import com.finance.testproject.dto.PipelineDTO;
import com.finance.testproject.model.Action;
import com.finance.testproject.model.Pipeline;
import com.finance.testproject.model.Task;
import com.finance.testproject.model.Transition;
import com.finance.testproject.service.PipelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/")
public class PipelineController {

    @Autowired
    private PipelineService pipelineService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Pipeline createPipeline(@RequestBody PipelineDTO pipelineDTO) {
        return pipelineService.createPipeline(pipelineDTO.getName(), pipelineDTO.getDescription()
                , pipelineDTO.getTasksAsList(), pipelineDTO.getTransitionsAsSet());
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public PipelineDTO readPipeline() {

        return null;
    }

}
