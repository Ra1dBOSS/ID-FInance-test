package com.finance.testproject.dao;

import com.finance.testproject.model.Pipeline;
import com.finance.testproject.model.Task;
import com.finance.testproject.model.Transition;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class PipelineDAOImpl implements PipelineDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Pipeline getPipelineById(int id) {
        Pipeline pipeline = entityManager.find(Pipeline.class, id);
        return pipeline;
    }

    @Override
    public List<Pipeline> getPipelineByName(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Pipeline> criteriaQuery = criteriaBuilder.createQuery(Pipeline.class);
        Root<Pipeline> root = criteriaQuery.from(Pipeline.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("name"), name));
        List<Pipeline> pipelines = entityManager.createQuery(criteriaQuery).getResultList();
        return pipelines;
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
        for (Task x : pipeline.getTasks())
            for (Task t : pipeline1.getTasks())
                if (x.equals(t)) {
                    t.setDescription(x.getDescription());
                    t.setStatus(x.getStatus());
                    t.setStartTime(x.getStartTime());
                    t.setEndTime(x.getEndTime());
                    t.setAction(x.getAction());
                }
        for (Transition x : pipeline1.getTransitions())
            entityManager.remove(x);
        pipeline1.setTransitions(pipeline.getTransitions());
        entityManager.flush();
    }

    @Override
    public void deletePipeline(int id) {
        entityManager.remove(getPipelineById(id));
    }
}
