import java.io.*;
import java.util.ArrayList;
import java.util.List;

class TaskManager {
    List<Task> tasks = new ArrayList<>();
    final String FILE = "tasks.dat";
    int nextId = 1;

    TaskManager() {
        load();
        for (Task t : tasks) {
            if (t.id >= nextId) {
                nextId = t.id + 1;
            }
        }
    }

    void add(Task t) {
        tasks.add(t);
        save();
    }

    void delete(int id) {
        tasks.removeIf(t -> t.id == id);
        save();
    }

    void complete(int id) {
        for (Task t : tasks) {
            if (t.id == id) {
                t.complete();
                break;
            }
        }
        save();
    }

    void showAll() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found");
            return;
        }
        for (Task t : tasks) {
            System.out.println(t);
        }
    }

    void save() {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(FILE))) {
            out.writeObject(tasks);
        } catch (IOException e) {
            System.out.println("Save failed");
        }
    }

    @SuppressWarnings("unchecked")
    void load() {
        File f = new File(FILE);
        if (!f.exists()) return;

        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(FILE))) {
            tasks = (List<Task>) in.readObject();
        } catch (Exception e) {
            System.out.println("Load failed");
        }
    }
}
