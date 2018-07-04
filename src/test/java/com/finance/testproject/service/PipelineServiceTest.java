package com.finance.testproject.service;

import com.finance.testproject.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PipelineServiceTest {

    @Autowired
    private PipelineService pipelineService;

    private Pipeline pipeline;

    @Test
    public void createPipeline() {
        String name = "Test name";
        String description = "Test disription";

        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("test task name", "test task description", Action.print));
        tasks.add(new Task("test task name1", "test task description1", Action.delay));
        tasks.add(new Task("test task name2", "test task description2", Action.random));
        tasks.add(new Task("test task name3", "test task description3", Action.completed));

        List<Transition> transitions = new ArrayList<>();
        transitions.add(new Transition("test task name", "test task name1"));
        transitions.add(new Transition("test task name", "test task name2"));
        transitions.add(new Transition("test task name1", "test task name3"));
        transitions.add(new Transition("test task name2", "test task name3"));

        pipeline = pipelineService.createPipeline(name, description, tasks, transitions);
    }

    @Test
    public void findPipeline() {
        createPipeline();
        Pipeline pipeline1 = pipelineService.findPipeline(pipeline.getId());
        assertEquals(pipeline, pipeline1);
    }

    @Test
    public void findPipelineByName() {
        createPipeline();
        Pipeline pipeline1 = pipelineService.findPipelineByName(pipeline.getName());
        assertEquals(pipeline, pipeline1);
    }

    @Test
    public void deletePipeline() {
        createPipeline();
        pipelineService.deletePipeline(pipeline.getId());
    }

    @Test
    public void updatePipeline() {
        createPipeline();
        String name = "Test name";
        String description = "Test UPDATED disription";
        List<Task> tasks = new ArrayList<>();
        List<Transition> transitions = new ArrayList<>();

        pipeline.setName(name);
        pipeline.setDescription(description);
        pipeline.setTasks(tasks);
        pipeline.setTransitions(transitions);
        pipelineService.updatePipeline(pipeline);

        pipeline = pipelineService.findPipelineByName(pipeline.getName());

        assertEquals(name, pipeline.getName());
        assertEquals(description, pipeline.getDescription());
    }
}