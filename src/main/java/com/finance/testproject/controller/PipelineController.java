package com.finance.testproject.controller;

import com.finance.testproject.dto.PipelineDTO;
import com.finance.testproject.model.Pipeline;
import com.finance.testproject.service.PipelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping(value = "/pipeline", produces = "application/x-yaml")
public class PipelineController {

    @Autowired
    private PipelineService pipelineService;

    @PostMapping("/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    public PipelineDTO createPipeline(@RequestBody PipelineDTO pipelineDTO) {
        Pipeline pipeline = pipelineService.createPipeline(pipelineDTO.getName(), pipelineDTO.getDescription()
                , pipelineDTO.getTasksAsList(), pipelineDTO.getTransitionsAsList());
        return new PipelineDTO(pipeline);
    }

    @GetMapping("/read/{name}")
    @ResponseStatus(value = HttpStatus.OK)
    public PipelineDTO readPipeline(@PathVariable("name") String name) {
        Pipeline pipeline = pipelineService.findPipelineByName(name);
        PipelineDTO pipelineDTO = new PipelineDTO(pipeline);
        return pipelineDTO;
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public PipelineDTO updatePipeline(@RequestBody PipelineDTO pipelineDTO) {
        Pipeline pipeline = new Pipeline(pipelineDTO.getName(), pipelineDTO.getDescription()
                , pipelineDTO.getTasksAsList(), pipelineDTO.getTransitionsAsList());
        pipeline.setId(pipelineService.findPipelineByName(pipeline.getName()).getId());
        pipelineService.updatePipeline(pipeline);
        pipelineDTO = new PipelineDTO(pipeline);
        return pipelineDTO;
    }

    @DeleteMapping("/delete/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePipeline(@PathVariable("name") String name) {
        Pipeline pipeline = pipelineService.findPipelineByName(name);
        pipelineService.deletePipeline(pipeline.getId());
    }

}
