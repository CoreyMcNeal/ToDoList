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

    public void add() {
        System.out.print("Activity to add: ");
        String activity = reader.nextLine();
        if (this.activityList.contains(activity)) {
            System.out.println("Activity already exists.");
            reader.nextLine();
            return;
        }

        this.activityList.add(activity);
        System.out.println("Added.");
        System.out.println();
    }

    public void remove() {
        System.out.print("Activity to remove: ");
        String activity = reader.nextLine();
        if (!(this.activityList.contains(activity))) {
            System.out.println("Activity does not exist.");
            reader.nextLine();
            return;
        }

        this.activityList.remove(activity);
        System.out.println("Removed.");
        System.out.println();
    }

    public void edit() {
        String activity = reader.nextLine();
        if (!(this.activityList.contains(activity))) {
            System.out.println("Activity does not exist.");
            reader.nextLine();
            return;
        }

        int activityIndex = this.activityList.indexOf(activity);

        System.out.println("Chosen Activity: " + this.activityList.get(activityIndex));
        System.out.print("Change to: ");

        String newActivity = reader.nextLine();
        this.activityList.set(activityIndex, newActivity);
        System.out.println("Changed.");
        System.out.println();
    }

    public void printList() {
        
        int index = 1;
        for (String entry: activityList) {
            System.out.println(index + " - " + entry);
            index += 1;
        }
    }
}
