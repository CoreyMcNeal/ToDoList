import java.util.Scanner;

public class UserInterface {
    private Scanner reader;
    
    public UserInterface() {
        this.reader = new Scanner(System.in);
    }

    public void start() {
        ToDoList list = new ToDoList(this.reader);
        list.add("Walk the dog");
        list.add("Water the plants");
        list.add("Water the plants");
        list.printList();
    }
}
