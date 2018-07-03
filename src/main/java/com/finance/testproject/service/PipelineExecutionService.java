package com.finance.testproject.service;

import com.finance.testproject.model.Pipeline;
import com.finance.testproject.model.PipelineExecution;
import com.finance.testproject.thread.ExecutionThread;

public interface PipelineExecutionService {

    PipelineExecution executePipeline(String name);

    PipelineExecution showPipelineExecutionStatus(int executionId);

    PipelineExecution stopPipelineExecution(int executionId);

}
