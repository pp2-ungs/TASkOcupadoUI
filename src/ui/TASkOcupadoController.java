package ui;

import core.Member;
import observer.Observer;
import core.TASkOcupado;
import core.Task;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TASkOcupadoController implements Observer {

    private TASkOcupado taskOcupado;
    private Map<String, Task> tasks;
    private Map<String, Member> members;

    public TASkOcupadoController(TASkOcupado taskOcupado) {
        this.taskOcupado = taskOcupado;
        this.taskOcupado.addObserver(this);
        
        taskOcupado.getTasks().forEach(task -> tasks.put(task.toString(), task));
        taskOcupado.getMembers().forEach(member -> members.put(member.toString(), member));
    }

    public void assignTask(String task, String member) {
        taskOcupado.assignTask(tasks.get(task), members.get(member));
    }

    @Override
    public void update(Object event) {
        System.out.println("[debuggin] controller update: \n" + event);
    }


    public Set<String> obtainTasks() {
        return tasks.keySet();
    }

    public Set<String> obtainMembers() {
        return members.keySet();
    }
}
