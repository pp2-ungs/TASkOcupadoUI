package ui;

import observer.Observer;
import core.TASkOcupado;


public class TASkOcupadoController implements Observer {

    private TASkOcupado taskOcupado;

    public TASkOcupadoController(TASkOcupado taskOcupado) {
        this.taskOcupado = taskOcupado;
        this.taskOcupado.addObserver(this);
    }

    public void assignTask(String taskDescription, String memberName) {
        taskOcupado.assignTask(taskDescription, memberName);
    }

    @Override
    public void update(Object event) {
        System.out.println("[debuggin] controller update: \n" + event);
    }


    public String[] obtainMembers() {
        return taskOcupado.obtainMembers();
    }

    public String[] obtainTasks() {
        return taskOcupado.obtainTasks();
    }
}
