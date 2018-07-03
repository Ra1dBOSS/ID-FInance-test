package com.finance.testproject.thread;

import com.finance.testproject.model.Pipeline;
import com.finance.testproject.model.PipelineExecution;
import com.finance.testproject.model.Status;
import com.finance.testproject.model.Task;

import java.sql.Timestamp;

public class RandomAction extends AbstractAction {

    public RandomAction(Task task, Pipeline pipeline, PipelineExecution pipelineExecution) {
        super(task, pipeline, pipelineExecution);
    }

    @Override
    public void run() {
        try {
            waitAnotherTasks();
        } catch (InterruptedException e) {
            return;
        }
        task.setStartTime(new Timestamp(System.currentTimeMillis()));
        System.out.println(task.getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            return;
        }
        switch (1 + (int) (Math.random() * 4)) {
            case 1: {
                task.setStatus(Status.COMPLETED);
                break;
            }
            case 2: {
                task.setStatus(Status.SKIPPED);
                break;
            }
            case 3: {
                task.setStatus(Status.FAILED);
                return;
            }
            case 4: {
                task.setStatus(Status.IN_PROGRESS);
                break;
            }
        }
        task.setEndTime(new Timestamp(System.currentTimeMillis()));
    }
}
