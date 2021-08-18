package Main;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private List<String> activityList;

    public ToDoList() {
        this.activityList = new ArrayList<String>();    // holds all activities logged

    }

    public int add(String activity) {               // adds the given String to the list if not already present.
        if (activity.isBlank()) {
            return 2;
        }

        for (String entry: this.activityList) {
            if (entry.toLowerCase().equals(activity.toLowerCase())) {
                return 1;
            }
        }

        this.activityList.add(activity);
        return 0;
    }

    public boolean remove(String activity) {            // removes the given String if present in list
        for (String entry: this.activityList) {
            if (activity.toLowerCase().equals(entry.toLowerCase())) {
                this.activityList.remove(entry);
                return true;
            }
        }

        return false;
    }

    public boolean exists(String activity) {            // checks if the given String exists in the list
        for (String entry: this.activityList) {
            if (activity.toLowerCase().equals(entry.toLowerCase())) {
                return true;
            }
        }

        return false;
    }

    public void replace(String activity, String newActivity) {   // replaces Strings activity with newActivity        
        int location;
        for (String entry: this.activityList) {
            if (activity.toLowerCase().equals(entry.toLowerCase())) {
                location = this.activityList.indexOf(entry);
                this.activityList.set(location, newActivity);
                return;
            }
        }
    }

    public String getTaskListAsString() {                           // gets the task list as a string
        StringBuilder tasks = new StringBuilder();
        for (String entry: this.activityList) {
            tasks.append("- " + entry + "\n");
        }

        return tasks.toString();
    }

    public List<String> getTaskList() {                         // returns String list of tasks
        return this.activityList;
    }
}
