package com.finance.testproject.service;

import com.finance.testproject.model.Action;
import com.finance.testproject.model.Pipeline;
import com.finance.testproject.model.Task;
import com.finance.testproject.model.Transition;
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

        Set<Transition> transitions = new HashSet<>();
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

}