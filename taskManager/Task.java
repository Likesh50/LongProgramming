import java.util.ArrayList;

public class Task {
    private int id;
    private String title;
    private String description;
    private String priority;
    private ArrayList<Task> subtasks;

    public Task(int id, String title, String description, String priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.subtasks = new ArrayList<>();
    }

    public void addSubtask(Task subtask) {
        subtasks.add(subtask);
    }

    public ArrayList<Task> getSubtasks() {
        return subtasks;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Task ID: " + id +
               "\nTitle: " + title +
               "\nDescription: " + description +
               "\nPriority: " + priority + "\n";
    }
}
