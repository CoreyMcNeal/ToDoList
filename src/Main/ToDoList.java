package Main;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private List<String> activityList;

    public ToDoList() {
        this.activityList = new ArrayList<>();    // holds all activities logged

    }

    public boolean add(String activity) {               // adds the given String to the list if not already present.
        if (this.activityList.contains(activity)) {
            return false;
        }

        this.activityList.add(activity);
        return true;
    }

    public boolean remove(String activity) {            // removes the given String if present in list
        if (!(this.activityList.contains(activity))) {
            return false;
        }
        this.activityList.remove(activity);

        return true;
    }

    public boolean exists(String activity) {            // checks if the given String exists in the list
        if (!(this.activityList.contains(activity))) {
            return false;
        }
    
        return true;
    }

    public void replace(String activity, String newActivity) {   // replaces Strings acitivty with newActivity
        int activityIndex = this.activityList.indexOf(activity);
        this.activityList.set(activityIndex, newActivity);
    }

    public String getTaskList() {
        StringBuilder tasks = new StringBuilder();
        for (String entry: this.activityList) {
            tasks.append("- " + entry + "\n");
        }

        return tasks.toString();
    }

    public void printList() {                               // prints each of the entries in the activity list
        
        int index = 1;
        for (String entry: activityList) {
            System.out.println(index + " - " + entry);
            index += 1;
        }
    }
}
