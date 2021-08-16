package Main;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private List<String> activityList;

    public ToDoList() {
        this.activityList = new ArrayList<String>();    // holds all activities logged

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

    public String getTaskListAsString() {                           // gets the task list as a string
        StringBuilder tasks = new StringBuilder();
        for (String entry: this.activityList) {
            tasks.append("- " + entry + "\n");
        }

        return tasks.toString();
    }

    public List<String> getTaskList() {
        return this.activityList;
    }
}
