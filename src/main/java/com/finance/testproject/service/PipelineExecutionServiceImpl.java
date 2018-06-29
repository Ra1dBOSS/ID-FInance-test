package com.finance.testproject.service;

import com.finance.testproject.model.*;
import com.finance.testproject.thread.ExecutionThread;
import org.springframework.stereotype.Service;

@Service
public class PipelineExecutionServiceImpl implements PipelineExecutionService {

    Thread executionThread;

    @Override
    public PipelineExecution executePipeline(Pipeline pipeline) {
        ExecutionThread executionThread = new ExecutionThread(pipeline);
        executionThread.start();
        return executionThread.getPipelineExecution();
    }

    @Override
    public PipelineExecution showPipelineExecutionStatus(Pipeline pipeline) {
        return null;
    }

    @Override
    public PipelineExecution stopPipelineExecution(Pipeline pipeline) {
        executionThread.interrupt();
        return null;
    }
}
