import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
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
                choice = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number (1-5).");
                sc.nextLine(); // Clear the invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Task Name: ");
                        String taskName = sc.nextLine();
                        
                        if (taskName.trim().isEmpty()) {
                            System.out.println("Error: Task name cannot be empty.");
                            break;
                        }
                        
                        System.out.print("Priority (LOW/MEDIUM/HIGH): ");
                        String priority = sc.nextLine().toUpperCase();
                        
                        if (!priority.equals("LOW") && !priority.equals("MEDIUM") && !priority.equals("HIGH")) {
                            System.out.println("Error: Priority must be LOW, MEDIUM, or HIGH.");
                            break;
                        }
                        
                        System.out.print("Due Date (YYYY-MM-DD): ");
                        String dateInput = sc.nextLine();
                        LocalDate dueDate;
                        
                        try {
                            dueDate = LocalDate.parse(dateInput);
                        } catch (DateTimeParseException e) {
                            System.out.println("Error: Invalid date format. Please use YYYY-MM-DD (e.g., 2024-12-31).");
                            break;
                        }

                        manager.add(new Task(manager.getNextId(), taskName, priority, dueDate));
                        // id++;
                        System.out.println("Task added successfully");
                    } catch (Exception e) {
                        System.out.println("Error: Failed to add task. Please try again.");
                    }
                    break;

                case 2:
                    manager.showAll();
                    break;

                case 3:
                    try {
                        System.out.print("Task ID: ");
                        String idInput = sc.nextLine();
                        int taskId = Integer.parseInt(idInput);
                        manager.complete(taskId);
                        System.out.println("Task marked as completed (if it exists).");
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Please enter a valid number for Task ID.");
                    } catch (Exception e) {
                        System.out.println("Error: Failed to mark task as completed.");
                    }
                    break;

                case 4:
                    try {
                        System.out.print("Task ID: ");
                        String idInput = sc.nextLine();
                        int taskId = Integer.parseInt(idInput);
                        manager.delete(taskId);
                        System.out.println("Task deleted (if it existed).");
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Please enter a valid number for Task ID.");
                    } catch (Exception e) {
                        System.out.println("Error: Failed to delete task.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}
