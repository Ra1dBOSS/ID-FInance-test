package com.finance.testproject.dao;

import com.finance.testproject.model.Action;
import com.finance.testproject.model.Pipeline;
import com.finance.testproject.model.Task;
import com.finance.testproject.model.Transition;
import org.junit.Before;
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
public class PipelineDAOTest {

    @Autowired
    private PipelineDAO pipelineDAO;

    private Pipeline pipeline;

    @Before
    public void setUp() throws Exception {
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

        pipeline = new Pipeline("Test name", "Test pipeline", tasks, transitions);
    }

    @Test
    public void getPipelineById() {
        pipelineDAO.addPipeline(pipeline);
        pipeline = pipelineDAO.getPipelineById(pipeline.getId());
    }

    @Test
    public void getPipelineByName() {
        pipelineDAO.addPipeline(pipeline);
        List<Pipeline> pipelines = pipelineDAO.getPipelineByName(pipeline.getName());
        for (Pipeline x : pipelines)
            assertEquals(x.getName(), pipeline.getName());
    }

    @Test
    public void addPipeline() {
        pipelineDAO.addPipeline(pipeline);
    }

    @Test
    public void updatePipeline() {
        pipelineDAO.addPipeline(pipeline);
        pipeline.setDescription("updated desription");
        pipelineDAO.updatePipeline(pipeline);
    }

    @Test
    public void deletePipeline() {
        pipelineDAO.addPipeline(pipeline);
        pipelineDAO.deletePipeline(pipeline.getId());
    }
}