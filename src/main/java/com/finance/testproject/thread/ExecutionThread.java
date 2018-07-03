package com.finance.testproject.thread;

import com.finance.testproject.dao.PipelineExecutionDAO;
import com.finance.testproject.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ExecutionThread extends Thread {

    private volatile PipelineExecution pipelineExecution;

    private Pipeline pipeline;

    @Autowired
    PipelineExecutionDAO pipelineExecutionDAO;

    public ExecutionThread() {

    }

    public void setStartInformation(PipelineExecution pipelineExecution, Pipeline pipeline) {
        this.pipelineExecution = pipelineExecution;
        this.pipeline = pipeline;
    }

    public PipelineExecution getPipelineExecution() {
        return pipelineExecution;
    }

    private boolean checkOnFail() {
        for (Task x : pipelineExecution.getTasks()) {
            if (x.getStatus() == Status.FAILED) {
                pipelineExecution.setStatus(Status.FAILED);
                pipelineExecutionDAO.updatePipelineExecution(pipelineExecution);
                return true;
            }
        }
        return false;
    }

    @Override
    public void run() {
        for (Task x : pipelineExecution.getTasks()) {
            x.setStatus(Status.PENDING);
        }
        pipelineExecution.setStatus(Status.IN_PROGRESS);
        pipelineExecution.setStartTime(new Timestamp(System.currentTimeMillis()));
        List<Thread> threads = new ArrayList<>(pipelineExecution.getTasks().size());
        for (Task x : pipelineExecution.getTasks()) {
            switch (x.getAction()) {
                case print: {
                    Thread thread = new PrintAction(x, pipeline, pipelineExecution);
                    threads.add(thread);
                    thread.start();
                    break;
                }
                case random: {
                    Thread thread = new RandomAction(x, pipeline, pipelineExecution);
                    threads.add(thread);
                    thread.start();
                    break;
                }
                case completed: {
                    Thread thread = new CompletedAction(x, pipeline, pipelineExecution);
                    threads.add(thread);
                    thread.start();
                    break;
                }
                case delay: {
                    Thread thread = new DelayAction(x, pipeline, pipelineExecution);
                    threads.add(thread);
                    thread.start();
                    break;
                }
            }
        }

        for (Thread x : threads) {
            try {
                x.join();
            } catch (InterruptedException e) {
                for (Thread y : threads) {
                    x.interrupt();
                }
                if (checkOnFail()) {
                    return;
                }
                pipelineExecution.setEndTime(new Timestamp(System.currentTimeMillis()));
                pipelineExecutionDAO.updatePipelineExecution(pipelineExecution);
                return;
            }
        }

        if (checkOnFail()) {
            return;
        }

        pipelineExecution.setStatus(Status.COMPLETED);
        pipelineExecution.setEndTime(new Timestamp(System.currentTimeMillis()));
        pipelineExecutionDAO.updatePipelineExecution(pipelineExecution);
    }
}
