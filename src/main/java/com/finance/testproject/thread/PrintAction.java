package com.finance.testproject.thread;

import com.finance.testproject.model.Pipeline;
import com.finance.testproject.model.PipelineExecution;
import com.finance.testproject.model.Status;
import com.finance.testproject.model.Task;

import java.sql.Timestamp;

public class PrintAction extends AbstractAction {

    public PrintAction(Task task, Pipeline pipeline, PipelineExecution pipelineExecution) {
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
        task.setStatus(Status.COMPLETED);
        task.setEndTime(new Timestamp(System.currentTimeMillis()));
    }
}
