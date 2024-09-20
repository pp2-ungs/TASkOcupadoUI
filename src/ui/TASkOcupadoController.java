package ui;

import core.Member;
import core.TASkOcupado;
import core.Observer;
import core.Task;

public class TASkOcupadoController implements Observer {

    private TASkOcupado taskOcupado;

    public TASkOcupadoController(TASkOcupado taskOcupado) {
        this.taskOcupado = taskOcupado;
        this.taskOcupado.addObserverToAssigner(this);
    }

    public void assignTask(String taskDescription, String memberName) {
        taskOcupado.assignTask(taskDescription, memberName);
    }

    @Override
    public void update(Task task, Member member, Object obj) {
    }
    
    public String[] obtainMembers() {
    	return taskOcupado.obtainMembers();
    }
    
    public String[] obtainTasks() {
    	return taskOcupado.obtainTasks();
    }
}
