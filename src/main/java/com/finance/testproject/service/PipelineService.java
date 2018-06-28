package com.finance.testproject.service;

import com.finance.testproject.model.Pipeline;
import com.finance.testproject.model.Task;
import com.finance.testproject.model.Transition;

import java.util.List;
import java.util.Set;

public interface PipelineService {

    Pipeline createPipeline(String name, String description, List<Task> tasks, Set<Transition> transactions);

    Pipeline findPipeline(int id);

    void deletePipeline(int id);

    void updatePipeline(Pipeline pipeline);



}
