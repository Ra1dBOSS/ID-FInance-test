package com.finance.testproject.controller;

import com.finance.testproject.dto.PipelineDTO;
import com.finance.testproject.model.Pipeline;
import com.finance.testproject.service.PipelineService;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pipeline")
public class PipelineController {

    @Autowired
    private PipelineService pipelineService;

    @RequestMapping(
            value = "/yaml",
            consumes = "application/x-yaml",
//            produces = MediaType.TEXT_PLAIN_VALUE,
            method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String create(@RequestBody PipelineDTO pipelineDTO) {
        System.out.printf("In handleRequest method, employee: ", pipelineDTO);
        String s = String.format("PipelineDTO saved: " + pipelineDTO.getName());
        System.out.println(s);
        return s;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public PipelineDTO createPipeline(@RequestBody PipelineDTO pipelineDTO) {
        Pipeline pipeline = pipelineService.createPipeline(pipelineDTO.getName(), pipelineDTO.getDescription()
                , pipelineDTO.getTasksAsList(), pipelineDTO.getTransitionsAsSet());
        return new PipelineDTO(pipeline);
    }

    @GetMapping("/{name}")
    @ResponseStatus(value = HttpStatus.OK)
    public PipelineDTO readPipeline(@PathVariable("name") String name) {
        Pipeline pipeline = pipelineService.findPipelineByName(name);
        PipelineDTO pipelineDTO = new PipelineDTO(pipeline);
        return pipelineDTO;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public PipelineDTO updatePipeline(@RequestBody PipelineDTO pipelineDTO) {
        Pipeline pipeline = new Pipeline(pipelineDTO.getName(), pipelineDTO.getDescription()
                , pipelineDTO.getTasksAsList(), pipelineDTO.getTransitionsAsSet());
        pipeline.setId(pipelineService.findPipelineByName(pipeline.getName()).getId());
        pipelineService.updatePipeline(pipeline);
        pipelineDTO = new PipelineDTO(pipeline);
        return pipelineDTO;
    }

    @DeleteMapping("/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePipeline(@PathVariable("name") String name) {
        Pipeline pipeline = pipelineService.findPipelineByName(name);
        pipelineService.deletePipeline(pipeline.getId());
    }

}