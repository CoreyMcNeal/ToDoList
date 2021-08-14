package UserInterface;

import Main.ToDoList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class GUI implements ActionListener{
    private Scanner reader = new Scanner(System.in);

    private JFrame frame;
    private JPanel panel;
    private JButton addToListButton, removeFromListButton, editFromListButton;

    private JTextField addEntry;
    private JButton addButton, endAddingButton;
    private JTextField removeEntry;
    private JButton removeButton, endRemovingButton;
    private JTextField editEntry;
    private JButton editButton, endEditingButton;

    private JLabel welcomeLabel, currentToDoList;

    public void start() {
        buildScreens();
    }

    public void buildScreens() {
        ToDoList tdList = new ToDoList(reader);
        frame = new JFrame();
        panel = new JPanel();
        
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0,1));


        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Testing GUI");

        welcomeLabel = new JLabel("Welcome to the ToDoList!", SwingConstants.CENTER);
        panel.add(welcomeLabel);

        addToListButton = new JButton("Add To List");
        addToListButton.addActionListener(this);
        panel.add(addToListButton);

        removeFromListButton = new JButton("Remove from List");
        removeFromListButton.addActionListener(this);
        panel.add(removeFromListButton);

        editFromListButton = new JButton("Edit from list");
        editFromListButton.addActionListener(this);
        panel.add(editFromListButton);

        currentToDoList = new JLabel("");
        buildAddScreen();
        buildRemoveScreen();
        buildEditScreen();

        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    private void buildRemoveScreen() {
        addEntry = new JTextField();
        removeButton = new JButton("Remove");
        endRemovingButton = new JButton("Exit");
        addEntry.setVisible(false);
        removeButton.setVisible(false);
        endRemovingButton.setVisible(false);
        panel.add(addEntry);
        panel.add(removeButton);
        panel.add(endRemovingButton);
    }

    private void buildAddScreen() {
        removeEntry = new JTextField();
        addButton = new JButton("Add");
        endAddingButton = new JButton("Exit");
        removeEntry.setVisible(false);
        addButton.setVisible(false);
        endAddingButton.setVisible(false);
        panel.add(removeEntry);
        panel.add(addButton);
        panel.add(endAddingButton);
    }

    private void buildEditScreen() {
        editEntry = new JTextField();
        editButton = new JButton("Click to confirm entry to edit");
        endEditingButton = new JButton("Exit");
        editEntry.setVisible(false);
        editButton.setVisible(false);
        endEditingButton.setVisible(false);
        panel.add(editEntry);
        panel.add(editButton);
        panel.add(endEditingButton);
    }

    private void showRemoveScreen() {
        currentToDoList.setVisible(true);
        removeEntry.setVisible(true);
        removeButton.setVisible(true);
        endRemovingButton.setVisible(true);
        panel.validate();
    }

    public void showAddScreen() {
        currentToDoList.setVisible(true);
        addEntry.setVisible(true);
        addButton.setVisible(true);
        endAddingButton.setVisible(true);
        panel.validate();
    }

    public void showEditScreen() {
        currentToDoList.setVisible(true);
        editEntry.setVisible(true);
        editButton.setVisible(true);
        endEditingButton.setVisible(true);
        panel.validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addToListButton) {
            System.out.println("1st");
            hideWelcomeAndButtons();
            showRemoveScreen();
        } else if (e.getSource() == removeFromListButton) {
            System.out.println("2nd");
            hideWelcomeAndButtons();
            showRemoveScreen();
        } else if (e.getSource() == editFromListButton) {
            System.out.println("3rd");
            hideWelcomeAndButtons();
            showEditScreen();
        }
        
    }

    private void hideWelcomeAndButtons() {
        addToListButton.setVisible(false);
        removeFromListButton.setVisible(false);
        editFromListButton.setVisible(false);
        welcomeLabel.setVisible(false);
        panel.revalidate();
    }

    private void showWelcomeAndButtons() {
        addToListButton.setVisible(true);
        removeFromListButton.setVisible(true);
        editFromListButton.setVisible(true);
        welcomeLabel.setVisible(true);
        panel.revalidate();
    }
}
