package com.finance.testproject.dao;

import com.finance.testproject.model.Pipeline;

public interface PipelineDAO {

    Pipeline getPipelineById(int id);

    void addPipeline(Pipeline pipeline);

    void updatePipeline(Pipeline pipeline);

    void deletePipeline(int id);

}
