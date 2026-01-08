import java.io.Serializable;
import java.time.LocalDate;

class Task implements Serializable {
    int id;
    String taskName;
    String priority;
    String status;
    LocalDate dueDate;

    Task(int id, String taskName, String priority, LocalDate dueDate) {
        this.id = id;
        this.taskName = taskName;
        this.priority = priority;
        this.status = "PENDING";
        this.dueDate = dueDate;
    }

    void complete() {
        status = "COMPLETED";
    }

    public String toString() {
        return id + " | Task Name: " + taskName +
               " | Priority: " + priority +
               " | Status: " + status +
               " | Due: " + dueDate;
    }
}
