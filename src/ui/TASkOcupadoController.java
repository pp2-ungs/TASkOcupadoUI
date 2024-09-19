package ui;

import core.TASkOcupado;
import obs.Observer;

public class TASkOcupadoController implements Observer {

    private TASkOcupado taskOcupado;

    public TASkOcupadoController(TASkOcupado taskOcupado) {
        this.taskOcupado = taskOcupado;
        //this.taskOcupado.addObserverToAssigner(this);
    }

    public void assignTask(String taskDescription, String memberName) {
        taskOcupado.assignTask(taskDescription, memberName);
    }

    @Override
    public void update(Object obj) {
    }
}
