package com.finance.testproject.service;

import com.finance.testproject.model.Pipeline;
import com.finance.testproject.model.PipelineExecution;
import com.finance.testproject.thread.ExecutionThread;

public interface PipelineExecutionService {

    ExecutionThread executePipeline(Pipeline pipeline);

    PipelineExecution showPipelineExecutionStatus(Pipeline pipeline);

    PipelineExecution stopPipelineExecution(Pipeline pipeline);

}
