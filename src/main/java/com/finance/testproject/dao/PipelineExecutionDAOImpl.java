package com.finance.testproject.dao;

import com.finance.testproject.model.PipelineExecution;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class PipelineExecutionDAOImpl implements PipelineExecutionDAO {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public PipelineExecution getPipelineExecutionById(int id) {
        return entityManager.find(PipelineExecution.class, id);
    }

    @Override
    public void addPipelineExecution(PipelineExecution pipelineExecution) {
        entityManager.persist(pipelineExecution);
    }

    @Override
    public void updatePipelineExecution(PipelineExecution pipelineExecution) {
        PipelineExecution pipelineExecution1 = getPipelineExecutionById(pipelineExecution.getExecutionId());
        pipelineExecution1.setStatus(pipelineExecution.getStatus());
        pipelineExecution1.setPipeline(pipelineExecution.getPipeline());
        pipelineExecution1.setStartTime(pipelineExecution.getStartTime());
        pipelineExecution1.setEndTime(pipelineExecution.getEndTime());
        pipelineExecution1.setTasks(pipelineExecution.getTasks());
        entityManager.flush();
    }

    @Override
    public void deletePipelineExecution(int id) {
        entityManager.remove(getPipelineExecutionById(id));
    }

}
