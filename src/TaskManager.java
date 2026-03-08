import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskManager {
    private List<Task> tasks;
    private int nextId;

    public TaskManager() {
        this.tasks = new ArrayList<>();
        this.nextId = 1;
    }

    public void addTask(String title, String description) {
        Task newTask = new Task(nextId++, title, description);
        tasks.add(newTask);
        System.out.println("Tarefa adicionada com sucesso! ID: " + newTask.getId());
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }
        System.out.println("\n--- Lista de Tarefas ---");
        for (Task task : tasks) {
            System.out.println(task.toString());
        }
        System.out.println("------------------------\n");
    }

    public void markTaskAsCompleted(int id) {
        Optional<Task> taskOpt = findTaskById(id);
        if (taskOpt.isPresent()) {
            Task task = taskOpt.get();
            if (!task.isCompleted()) {
                task.markAsCompleted();
                System.out.println("Tarefa " + id + " marcada como concluída!");
            } else {
                System.out.println("A tarefa " + id + " já está concluída.");
            }
        } else {
            System.out.println("Tarefa " + id + " não encontrada.");
        }
    }

    public void removeTask(int id) {
        Optional<Task> taskOpt = findTaskById(id);
        if (taskOpt.isPresent()) {
            tasks.remove(taskOpt.get());
            System.out.println("Tarefa " + id + " removida com sucesso!");
        } else {
            System.out.println("Tarefa " + id + " não encontrada.");
        }
    }

    private Optional<Task> findTaskById(int id) {
        return tasks.stream().filter(t -> t.getId() == id).findFirst();
    }
}
