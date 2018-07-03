package com.finance.testproject.service;

import com.finance.testproject.dao.PipelineExecutionDAO;
import com.finance.testproject.model.*;
import com.finance.testproject.thread.ExecutionThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PipelineExecutionServiceImpl implements PipelineExecutionService {

    @Autowired
    PipelineService pipelineService;

    @Autowired
    PipelineExecutionDAO pipelineExecutionDAO;

    @Autowired
    ApplicationContext applicationContext;

    Map<Integer, ExecutionThread> executionThreadMap = new HashMap<>();

    @Override
    public PipelineExecution executePipeline(String name) {
        Pipeline pipeline = pipelineService.findPipelineByName(name);
        ExecutionThread executionThread = (ExecutionThread) applicationContext.getBean("executionThreadPrototype");
        PipelineExecution pipelineExecution = new PipelineExecution(pipeline);
        executionThread.setStartInformation(pipelineExecution, pipeline);
        pipelineExecution.setStatus(Status.IN_PROGRESS);
        pipelineExecutionDAO.addPipelineExecution(pipelineExecution);
        executionThread.start();
        executionThreadMap.put(pipelineExecution.getExecutionId(), executionThread);
        return pipelineExecution;
    }

    @Override
    public PipelineExecution showPipelineExecutionStatus(int executionId) {
        PipelineExecution pipelineExecution;
        ExecutionThread executionThread = executionThreadMap.get(executionId);
        if ((executionThread != null) && (executionThread.isAlive())) {
           pipelineExecution = executionThread.getPipelineExecution();
        } else {
            pipelineExecution = pipelineExecutionDAO.getPipelineExecutionById(executionId);
        }
        return pipelineExecution;
    }

    @Override
    public PipelineExecution stopPipelineExecution(int executionId) {
        ExecutionThread executionThread = executionThreadMap.get(executionId);
        if ((executionThread != null) && (executionThread.isAlive())) {
            executionThread.interrupt();
        }
        PipelineExecution pipelineExecution = pipelineExecutionDAO.getPipelineExecutionById(executionId);
        return pipelineExecution;
    }
}
