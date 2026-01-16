import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        //int id = 1;

        while (true) {
            System.out.println("\n1.Add Task 2.View Tasks 3.Mark Completed 4.Delete Task 5.Exit");
            System.out.print("Choice: ");
            int choice;
            try {
              choice = Integer.parseInt(sc.nextLine());  
            } catch (NumberFormatException e) {
                // TODO: handle exception
                System.out.println("Please enter a number like 1,2,3,...");
                continue;
            }
            //sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Task Name: ");
                    String taskName = sc.nextLine();
                    System.out.print("Priority (LOW/MEDIUM/HIGH): ");
                    String priority = sc.nextLine();
                    System.out.print("Due Date (YYYY-MM-DD): ");
                    //LocalDate dueDate = LocalDate.parse(sc.nextLine());
                    LocalDate dueDate;
                    try {
                        dueDate = LocalDate.parse(sc.nextLine());
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println("Wrong date format , use YYYY-MM-DD");
                        break;
                    }
                    manager.add(new Task(manager.getNextId(), taskName, priority, dueDate));
                    // id++;
                    System.out.println("Task added successfully");
                    break;

                case 2:
                    manager.showAll();
                    break;

                case 3:
                    System.out.print("Task ID: ");
                    //manager.complete(Integer.parseInt(sc.nextLine()));
                    try {
                        int id = Integer.parseInt(sc.nextLine());
                        manager.complete(id);
                    } catch (NumberFormatException e) {
                        // TODO: handle exception
                        System.out.println("Task id must be a number");
                    }
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
