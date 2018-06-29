package com.finance.testproject.thread;

import com.finance.testproject.dao.PipelineExecutionDAO;
import com.finance.testproject.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

public class ExecutionThread extends Thread {

    private PipelineExecution pipelineExecution;

    private Pipeline pipeline;

    @Autowired
    PipelineExecutionDAO pipelineExecutionDAO;

    public ExecutionThread(Pipeline pipeline) {
        this.pipelineExecution = new PipelineExecution(pipeline, null);
        this.pipeline = pipeline;
    }

    public PipelineExecution getPipelineExecution() {
        return pipelineExecution;
    }

    @Override
    public void run() {
        for (Task x : pipelineExecution.getTasks()) {
            x.setStatus(Status.PENDING);
        }
        pipelineExecution.setStatus(Status.IN_PROGRESS);
        pipelineExecution.setStartTime(new Timestamp(System.currentTimeMillis()));
        for (Task x : pipelineExecution.getTasks()) {
            switch (x.getAction()) {
                case print: {
                    new PrintAction(x, pipeline).start();
                    break;
                }
                case random: {
                    new RandomAction(x, pipeline).start();
                    break;
                }
                case completed: {
                    new CompletedAction(x, pipeline).start();
                    break;
                }
                case delay: {
                    new DelayAction(x, pipeline).start();
                    break;
                }
            }
        }
        pipelineExecutionDAO.addPipelineExecution(pipelineExecution);
    }
}
