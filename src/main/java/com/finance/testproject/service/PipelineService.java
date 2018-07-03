package com.finance.testproject.service;

import com.finance.testproject.model.Pipeline;
import com.finance.testproject.model.Task;
import com.finance.testproject.model.Transition;

import java.util.List;

public interface PipelineService {

    Pipeline createPipeline(String name, String description, List<Task> tasks, List<Transition> transactions);

    Pipeline findPipeline(int id);

    Pipeline findPipelineByName(String name);

    void deletePipeline(int id);

    void updatePipeline(Pipeline pipeline);



}
