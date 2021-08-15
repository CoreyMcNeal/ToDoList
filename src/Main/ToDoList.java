package Main;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private List<String> activityList;

    public ToDoList() {
        
        this.activityList = new ArrayList<>();

    }

    public boolean add(String activity) {
        if (this.activityList.contains(activity)) {
            return false;
        }

        this.activityList.add(activity);
        return true;
    }

    public boolean remove(String activity) {
        if (!(this.activityList.contains(activity))) {
            return false;
        }
        this.activityList.remove(activity);

        return true;
    }

    public boolean exists(String activity) {
        if (!(this.activityList.contains(activity))) {
            return false;
        }
    
        return true;
    }

    public void replace(String activity, String newActivity) {
        int activityIndex = this.activityList.indexOf(activity);
        this.activityList.set(activityIndex, newActivity);
    }

    public boolean edit(String activity) {

        int activityIndex = this.activityList.indexOf(activity);
        this.activityList.set(activityIndex, activity);

        return true;
    }

    public void printList() {
        
        int index = 1;
        for (String entry: activityList) {
            System.out.println(index + " - " + entry);
            index += 1;
        }
    }
}
