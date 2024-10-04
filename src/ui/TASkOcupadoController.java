package ui;

import core.Observer;
import core.TaskAssignerAdapter;

public class TASkOcupadoController implements Observer {

    private TaskAssignerAdapter taskAssignerAdapter;

    public TASkOcupadoController(TaskAssignerAdapter taskAssignerAdapter) {
        this.taskAssignerAdapter = taskAssignerAdapter;
        this.taskAssignerAdapter.addObserver(this);
    }

    public void assignTask(String taskDescription, String memberName) {
        taskAssignerAdapter.assignTask(taskDescription, memberName);
    }

    // FIXME
    // Para mí, no es necesario que el controller sea un observer
    @Override
    public void update(Object event) {
        System.out.println("?controller update: \n" + event);
    }

    public String[] obtainMembers() {
        return taskAssignerAdapter.obtainMembers();
    }

    public String[] obtainTasks() {
        return taskAssignerAdapter.obtainTasks();
    }
}
