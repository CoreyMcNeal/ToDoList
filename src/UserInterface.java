import java.util.Scanner;

public class UserInterface {
    private Scanner reader;
    
    public UserInterface() {
        this.reader = new Scanner(System.in);
    }

    public void start() {
        ToDoList list = new ToDoList(this.reader);

        while (true) {
            System.out.println("Welcome to the ToDoList!");
            System.out.print("enter ->");
            reader.nextLine();

            System.out.println("Options: \n" + 
                                " 1 - Add to list \n" + 
                                " 2 - Remove from list \n" + 
                                " 3 - Edit entry \n" + 
                                "\n" +
                                " 0 - Exit");
            
            int userChoice = checkEntry();
            System.out.println(userChoice);
        }
    }

    public int checkEntry() {
        while (true) {
            try {
                System.out.print("Choice: ");
                int choice = Integer.valueOf(reader.nextLine());
                if (choice != 1 && choice != 2 && choice != 3 && choice != 0) {
                    System.out.println("Not a valid choice. Try again.");
                    System.out.print("enter ->");
                    reader.nextLine();
                    continue;
                }

                return choice;
            } catch (Exception e) {
                System.out.println("Not a valid choice. Try again.");
                System.out.print("enter ->");
                reader.nextLine();
                continue;
            }
        }
    }
}

