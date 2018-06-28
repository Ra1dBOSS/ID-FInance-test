package com.finance.testproject.dao;

import com.finance.testproject.model.PipelineExecution;

public interface PipelineExecutionDAO {

    PipelineExecution getPipelineExecutionById(int id);

    void addPipelineExecution(PipelineExecution pipelineExecution);

    void updatePipelineExecution(PipelineExecution pipelineExecution);

    void deletePipelineExecution(int id);

}
