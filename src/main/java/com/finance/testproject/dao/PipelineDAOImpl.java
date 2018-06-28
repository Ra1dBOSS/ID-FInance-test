package com.finance.testproject.dao;

import com.finance.testproject.model.Pipeline;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class PipelineDAOImpl implements PipelineDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Pipeline getPipelineById(int id) {
        return entityManager.find(Pipeline.class, id);
    }

    @Override
    public void addPipeline(Pipeline pipeline) {
        entityManager.persist(pipeline);
    }

    @Override
    public void updatePipeline(Pipeline pipeline) {
        Pipeline pipeline1 = getPipelineById(pipeline.getId());
        pipeline1.setName(pipeline.getName());
        pipeline1.setDescription(pipeline.getDescription());
        pipeline1.setTasks(pipeline.getTasks());
        pipeline1.setTransitions(pipeline.getTransitions());
        entityManager.flush();
    }

    @Override
    public void deletePipeline(int id) {

    }
}
