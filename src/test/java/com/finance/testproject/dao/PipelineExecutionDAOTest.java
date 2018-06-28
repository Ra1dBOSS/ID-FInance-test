package com.finance.testproject.dao;

import com.finance.testproject.model.*;
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
public class PipelineExecutionDAOTest {

    @Autowired
    private PipelineExecutionDAO pipelineExecutionDAO;

    private PipelineExecution pipelineExecution;

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

        Pipeline pipeline = new Pipeline("Test name", "Test pipeline", tasks, transitions);

        pipelineExecution = new PipelineExecution(pipeline, Status.IN_PROGRESS);
    }

    @Test
    public void getPipelineExecutionById() {
        pipelineExecutionDAO.addPipelineExecution(pipelineExecution);
        pipelineExecution = pipelineExecutionDAO.getPipelineExecutionById(pipelineExecution.getExecutionId());
    }

    @Test
    public void addPipelineExecution() {
        pipelineExecutionDAO.addPipelineExecution(pipelineExecution);
    }

    @Test
    public void updatePipelineExecution() {
        pipelineExecutionDAO.addPipelineExecution(pipelineExecution);
        pipelineExecution.setStatus(Status.FAILED);
        pipelineExecutionDAO.updatePipelineExecution(pipelineExecution);
    }

    @Test
    public void deletePipelineExecution() {
        pipelineExecutionDAO.addPipelineExecution(pipelineExecution);
        pipelineExecutionDAO.deletePipelineExecution(pipelineExecution.getExecutionId());
    }
}