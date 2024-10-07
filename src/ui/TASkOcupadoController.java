package ui;

import core.Member;
import observer.Observer;
import core.TASkOcupado;
import core.Task;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TASkOcupadoController implements Observer {

    private TASkOcupado taskOcupado;
    private TASkOcupadoView taskOcupadoView;
    
    private Map<String, Task> tasks;
    private Map<String, Member> members;

    public TASkOcupadoController(TASkOcupado taskOcupado, TASkOcupadoView taskOcupadoView) {
        this.taskOcupado = taskOcupado;
        this.taskOcupado.addObserver(this);
        
        this.taskOcupadoView = taskOcupadoView;
        
        loadData();
    }
    
    private void loadData() {
        tasks = new HashMap<>();
        members = new HashMap<>();
        
        taskOcupado.getTasks().forEach(task -> tasks.put(task.toString(), task));
        taskOcupado.getMembers().forEach(member -> members.put(member.toString(), member));
        
        loadTasksComboBox();
        loadMembersComboBox();
    }

    public void assignTask(String task, String member) {
        taskOcupado.assignTask(tasks.get(task), members.get(member));
    }

    @Override
    public void update(Object event) {
        loadData(); // por si cambian miembros y tasks en el modelo
        System.out.println("[debuggin] controller update: \n" + event);
    }
    
    private void loadTasksComboBox() {
        Set<String> tasksSet = tasks.keySet();
        
        List<String> tasksList = new ArrayList<>(tasksSet);
        tasksList.sort(Comparator.comparing(String::toString));
        tasksList.addFirst("Select task");
        
        taskOcupadoView.loadTasksComboBox(toArray(tasksList));
    }

    private void loadMembersComboBox() {
        Set<String> membersSet = members.keySet();

        List<String> membersList = new ArrayList<>(membersSet);
        membersList.sort(Comparator.comparing(String::toString));
        membersList.addFirst("Select member");

        taskOcupadoView.loadMembersComboBox(toArray(membersList));
    }
    
    private String[] toArray(List<String> list) {
        String[] data = new String[list.size()];
              
        int i = 0;
        for (String s : list) {
            data[i++] = s;
        }
       
        return data;
    }
}
