package com.finance.testproject.thread;

import com.finance.testproject.model.Pipeline;
import com.finance.testproject.model.Status;
import com.finance.testproject.model.Task;

import java.sql.Timestamp;

public class PrintAction extends AbstractAction {

    public PrintAction(Task task, Pipeline pipeline) {
        super(task, pipeline);
    }

    @Override
    public void run() {
        waitAnotherTasks();
        task.setStartTime(new Timestamp(System.currentTimeMillis()));
        System.out.println(task.getName());
        task.setStatus(Status.COMPLETED);
        task.setEndTime(new Timestamp(System.currentTimeMillis()));
    }
}
