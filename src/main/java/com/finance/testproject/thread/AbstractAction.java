package com.finance.testproject.thread;

import com.finance.testproject.model.Pipeline;
import com.finance.testproject.model.Task;
import com.finance.testproject.model.Transition;

public abstract class AbstractAction extends Thread {

    protected Task task;

    protected Pipeline pipeline;

    public AbstractAction(Task task, Pipeline pipeline) {
        this.task = task;
        this.pipeline = pipeline;
    }

    public Task getTask() {
        return task;
    }

    protected void waitAnotherTasks() {
        boolean f = true;
        while (f) {
            f = false;
            for (Transition x : pipeline.getTransitions()) {
                if (x.getTarget().equals(task.getName())) {
                    for (Task t : pipeline.getTasks()) {
                        if ((t.getName().equals(x.getSource())) || (t.getEndTime() == null)) {
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
