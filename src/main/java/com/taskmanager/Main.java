import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        int id = 1;

        while (true) {
            System.out.println("\n1.Add Task 2.View Tasks 3.Mark Completed 4.Delete Task 5.Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Task Name: ");
                    String taskName = sc.nextLine();
                    System.out.print("Priority (LOW/MEDIUM/HIGH): ");
                    String priority = sc.nextLine();
                    System.out.print("Due Date (YYYY-MM-DD): ");
                    LocalDate dueDate = LocalDate.parse(sc.nextLine());

                    manager.add(new Task(id, taskName, priority, dueDate));
                    id++;
                    System.out.println("Task added successfully");
                    break;

                case 2:
                    manager.showAll();
                    break;

                case 3:
                    System.out.print("Task ID: ");
                    manager.complete(Integer.parseInt(sc.nextLine()));
                    break;

                case 4:
                    System.out.print("Task ID: ");
                    manager.delete(Integer.parseInt(sc.nextLine()));
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
