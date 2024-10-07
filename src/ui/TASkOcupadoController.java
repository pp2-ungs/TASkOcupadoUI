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
        // aca va Task y Member :D
        taskOcupado.assignTask(taskDescription, memberName);
    }

    @Override
    public void update(Object event) {
        System.out.println("[debuggin] controller update: \n" + event);
    }

    @Override
    public String getName() {
        return "Controller";
    }
}
