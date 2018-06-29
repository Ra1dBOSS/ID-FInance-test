package com.finance.testproject.dao;

import com.finance.testproject.model.Pipeline;

import java.util.List;

public interface PipelineDAO {

    Pipeline getPipelineById(int id);

    List<Pipeline> getPipelineByName(String name);

    void addPipeline(Pipeline pipeline);

    void updatePipeline(Pipeline pipeline);

    void deletePipeline(int id);

}
