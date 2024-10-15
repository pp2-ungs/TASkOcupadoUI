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

public class TASkOcupadoController implements Observer {

    private TASkOcupado taskOcupado;
    private TASkOcupadoView taskOcupadoView;

    private Map<String, Task> tasks;
    private Map<String, Member> members;
    private Map<String, Observer> notificators;

    public TASkOcupadoController(TASkOcupado taskOcupado, TASkOcupadoView taskOcupadoView) {
        this.taskOcupado = taskOcupado;
        this.taskOcupado.addObserver(this);

        this.taskOcupadoView = taskOcupadoView;

        loadData();
    }

    private void loadData() {
        tasks = new HashMap<>();
        members = new HashMap<>();
        notificators = new HashMap<>();

        taskOcupado.getTasks().forEach(task -> tasks.put(task.toString(), task));
        taskOcupado.getMembers().forEach(member -> members.put(member.toString(), member));
        taskOcupado.getNotificators().forEach(notificator -> notificators.put(notificator.getClass().getSimpleName(), notificator));

        loadTasksComboBox();
        loadMembersComboBox();
        loadNotificationMethodsComboBox();
        loadNotificationMethodsTable();
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

        String[] tasksArray = tasksList.toArray(new String[0]);
        taskOcupadoView.loadTasksComboBox(tasksArray);
    }

    private void loadMembersComboBox() {
        Set<String> membersSet = members.keySet();

        List<String> membersList = new ArrayList<>(membersSet);
        membersList.sort(Comparator.comparing(String::toString));
        membersList.addFirst("Select member");

        String[] membersArray = membersList.toArray(new String[0]);
        taskOcupadoView.loadMembersComboBox(membersArray);
    }

    private void loadNotificationMethodsComboBox() {
        Set<String> notificatorsSet = notificators.keySet();

        List<String> notificatorsList = new ArrayList<>(notificatorsSet);
        notificatorsList.sort(Comparator.comparing(String::toString));
        notificatorsList.addFirst("Notify by");

        String[] notificatorsArray = notificatorsList.toArray(new String[0]);
        taskOcupadoView.loadNotificationMethodsComboBox(notificatorsArray);
    }

    private void loadNotificationMethodsTable() {
        Set<String> notificatorsSet = notificators.keySet();
        // Convertir a un array bidimensional para la tabla
        String[][] notificatorsArray = notificatorsSet
                .stream()
                .map(notificator -> new String[]{notificator})
                .toArray(String[][]::new);

        taskOcupadoView.loadNotificationMethodsTable(notificatorsArray);
    }

    public void activeNotificator(String notificator) {
        taskOcupado.activeTaskAssignerObserver(notificators.get(notificator));
    }

    public void deactiveNotificator(String notificator) {
        taskOcupado.deactiveObserverToTaskAssigner(notificators.get(notificator));
    }

}
