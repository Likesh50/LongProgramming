import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true) {
            System.out.println("\n==== Task Manager Menu ====");
            System.out.println("1. Create Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Create Subtask");
            System.out.println("4. View Subtasks");
            System.out.println("5. Search");
            System.out.println("6. Add Task Content to File");
            System.out.println("7. Stop Program");
            System.out.print("Enter your choice: ");

            int choice = getIntInput(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String desc = scanner.nextLine();
                    System.out.print("Enter priority (High/Medium/Low or leave blank): ");
                    String priority = scanner.nextLine();
                    if (priority.isEmpty()) priority = "Normal";
                    Task newTask = taskManager.createTask(title, desc, priority);
                    System.out.println("Task created with ID: " + newTask.getId());
                    break;

                case 2:
                    taskManager.viewTasks();
                    break;

                case 3:
                    System.out.print("Enter parent task ID: ");
                    int parentId = getIntInput(scanner);
                    System.out.print("Enter subtask title: ");
                    String stitle = scanner.nextLine();
                    System.out.print("Enter subtask description: ");
                    String sdesc = scanner.nextLine();
                    System.out.print("Enter subtask priority: ");
                    String spriority = scanner.nextLine();
                    if (spriority.isEmpty()) spriority = "Normal";
                    boolean added = taskManager.createSubtask(parentId, stitle, sdesc, spriority);
                    System.out.println(added ? "Subtask added." : "Parent task not found.");
                    break;

                case 4:
                    System.out.print("Enter task ID to view subtasks: ");
                    int viewId = getIntInput(scanner);
                    taskManager.viewSubtasks(viewId);
                    break;

                case 5:
                    System.out.print("Enter keyword to search: ");
                    String keyword = scanner.nextLine();
                    taskManager.searchTasks(keyword);
                    break;

                case 6:
                    System.out.print("Enter task ID to write to file: ");
                    int fileId = getIntInput(scanner);
                    System.out.print("Enter file name (e.g., tasks.txt): ");
                    String filename = scanner.nextLine();
                    taskManager.writeTaskToFile(fileId, filename);
                    break;

                case 7:
                    System.out.println("Exiting Task Manager. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // Helper method to safely get integers
    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}
