import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {
    private HashMap<Integer, Task> tasks;
    private int taskIdCounter;

    public TaskManager() {
        tasks = new HashMap<>();
        taskIdCounter = 1;
    }

    public Task createTask(String title, String description, String priority) {
        Task task = new Task(taskIdCounter, title, description, priority);
        tasks.put(taskIdCounter, task);
        taskIdCounter++;
        return task;
    }

    public boolean createSubtask(int parentId, String title, String description, String priority) {
        Task parent = tasks.get(parentId);
        if (parent != null) {
            Task subtask = new Task(taskIdCounter, title, description, priority);
            parent.addSubtask(subtask);
            tasks.put(taskIdCounter, subtask);
            taskIdCounter++;
            return true;
        }
        return false;
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }

        for (Task task : tasks.values()) {
            System.out.println(task);
        }
    }

    public void viewSubtasks(int taskId) {
        Task parent = tasks.get(taskId);
        if (parent != null) {
            ArrayList<Task> subtasks = parent.getSubtasks();
            if (subtasks.isEmpty()) {
                System.out.println("No subtasks for task ID " + taskId);
            } else {
                for (Task sub : subtasks) {
                    System.out.println(sub);
                }
            }
        } else {
            System.out.println("Task ID not found.");
        }
    }

    public void searchTasks(String keyword) {
        boolean found = false;
        for (Task task : tasks.values()) {
            if (task.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                task.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(task);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching tasks found.");
        }
    }

    public void writeTaskToFile(int taskId, String filename) {
        Task task = tasks.get(taskId);
        if (task != null) {
            try (FileWriter writer = new FileWriter(filename, true)) {
                writer.write(task.toString() + "\n");
                for (Task sub : task.getSubtasks()) {
                    writer.write("  Subtask:\n" + sub.toString() + "\n");
                }
                System.out.println("Task written to file successfully.");
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }
        } else {
            System.out.println("Task not found.");
        }
    }
}
