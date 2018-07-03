package com.finance.testproject.thread;

import com.finance.testproject.model.*;

public abstract class AbstractAction extends Thread {

    protected volatile Task task;

    protected volatile PipelineExecution pipelineExecution;

    protected volatile Pipeline pipeline;

    

    public AbstractAction(Task task, Pipeline pipeline, PipelineExecution pipelineExecution) {
        this.task = task;
        this.pipeline = pipeline;
        this.pipelineExecution = pipelineExecution;
    }

    public Task getTask() {
        return task;
    }

    protected void waitAnotherTasks() throws InterruptedException {
        boolean f = true;
        while (f) {
            f = false;
            for (Transition x : pipeline.getTransitions()) {
                if (x.getTarget().equals(task.getName())) {
                    for (Task t : pipelineExecution.getTasks()) {
                        if ((t.getName().equals(x.getSource())) && (t.getStatus() == Status.FAILED)) {
                            throw new InterruptedException();
                        }
                        if ((t.getName().equals(x.getSource())) && (t.getEndTime() == null)) {
                            f = true;
                            break;
                        }
                    }
                    if (f) break;
                }
            }
        }
    }

}
