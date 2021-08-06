import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoList {
    private List<String> activityList;
    private Scanner reader;

    public ToDoList(Scanner reader) {
        this.activityList = new ArrayList<>();
        this.reader = reader;
    }

    public void add(String activity) {
        if (this.activityList.contains(activity)) {
            System.out.println("Activity already exists.");
            reader.nextLine();
            return;
        }

        this.activityList.add(activity);
    }

    public void remove(String activity) {
        if (!(this.activityList.contains(activity))) {
            System.out.println("Activity does not exist.");
            reader.nextLine();
            return;
        }

        this.activityList.remove(activity);

    }

    public void edit(String activity) {

    }

    public void printList() {
        
        int index = 1;
        for (String entry: activityList) {
            System.out.println(index + " - " + entry);
            index += 1;
        }
    }
}
