package com.finance.testproject.dao;

import com.finance.testproject.model.Pipeline;
import com.finance.testproject.model.Task;

public interface TaskDAO {

    Task getTaskById(int id);

    void addTask(Task task);

    void updateTask(Task task);

    void deleteTask(int id);


}
