package ui;

import core.Person;
import observer.Observer;
import core.TASkOcupado;
import core.Task;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TASkOcupadoController implements Observer {

    private TASkOcupado taskOcupado;
    private TASkOcupadoView taskOcupadoView;
    
    private Map<String, Task> tasks;
    private Map<String, Person> people;

    public TASkOcupadoController(TASkOcupado taskOcupado, TASkOcupadoView taskOcupadoView) {
        this.taskOcupado = taskOcupado;
        this.taskOcupado.addObserver(this);
        
        this.taskOcupadoView = taskOcupadoView;
        
        loadData();
    }
    
    private void loadData() {
        tasks = new HashMap<>();
        people = new HashMap<>();
        
        taskOcupado.getTasks().forEach(task -> tasks.put(task.toString(), task));
        taskOcupado.getPeople().forEach(person -> people.put(person.toString(), person));
        
        loadTasksComboBox();
        loadMembersComboBox();
    }

    public void assignTask(String task, String person) {
        taskOcupado.assignTask(tasks.get(task), people.get(person));
    }

    @Override
    public void update(Object event) {
        loadData(); // por si cambian miembros y tasks en el modelo
        System.out.println("[debugging] controller update: \n" + event);
    }
    
    private void loadTasksComboBox() {
        var tasksSet = tasks.keySet();
        
        var tasksList = new ArrayList<String>(tasksSet);
        tasksList.sort(Comparator.comparing(String::toString));
        tasksList.addFirst("Select task");
        
        var tasksArray = tasksList.toArray(new String[0]);
        taskOcupadoView.loadTasksComboBox(tasksArray);
    }

    private void loadMembersComboBox() {
        var peopleSet = people.keySet();

        var peopleList = new ArrayList<String>(peopleSet);
        peopleList.sort(Comparator.comparing(String::toString));
        peopleList.addFirst("Select person");

        var peopleArray = peopleList.toArray(new String[0]);
        taskOcupadoView.loadMembersComboBox(peopleArray); 
    }
    
}
