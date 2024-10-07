package ui;

import core.Member;
import observer.Observer;
import core.TASkOcupado;
import core.Task;
import java.util.Set;

public class TASkOcupadoController implements Observer {

    private TASkOcupado taskOcupado;

    public TASkOcupadoController(TASkOcupado taskOcupado) {
        this.taskOcupado = taskOcupado;
        this.taskOcupado.addObserver(this);
    }

    public void assignTask(String taskDescription, String memberName) {
        //.assignTask(taskDescription, memberName);
    }

    // FIXME
    // Para mí, no es necesario que el controller sea un observer
    @Override
    public void update(Object event) {
        System.out.println("[debuggin] controller update: \n" + event);
    }

    public Set<Member> obtainMembers() {
        return taskOcupado.getMembers();
    }

    public Set<Task> obtainTasks() {
        return taskOcupado.getTasks();
    }
}
