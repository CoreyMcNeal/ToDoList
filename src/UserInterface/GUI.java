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

    private JPanel addPanel;
    private JTextField addEntry;
    private JButton addButton, endAddingButton;

    private JPanel removePanel;
    private JTextField removeEntry;
    private JButton removeButton, endRemovingButton;

    private JPanel editPanel;
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
        addPanel = new JPanel();
        removePanel = new JPanel();
        editPanel = new JPanel();
        
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        addPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        addPanel.setLayout(new GridLayout(0, 1));
        removePanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        removePanel.setLayout(new GridLayout(0, 1));
        editPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        editPanel.setLayout(new GridLayout(0, 1));

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

        frame.setSize(300, 300);
        frame.setVisible(true);

        buildAddScreen();
        buildRemoveScreen();
        buildEditScreen();
    }

    private void buildRemoveScreen() {
        removeEntry = new JTextField();
        removeButton = new JButton("Remove");
        endRemovingButton = new JButton("Exit");

        removePanel.add(currentToDoList);
        removePanel.add(removeEntry);
        removePanel.add(removeButton);
        removePanel.add(endRemovingButton);
    }

    private void buildAddScreen() {
        addEntry = new JTextField();
        addButton = new JButton("Add");
        endAddingButton = new JButton("Exit");

        addPanel.add(currentToDoList);
        addPanel.add(addEntry);
        addPanel.add(addButton);
        addPanel.add(endAddingButton);
    }

    private void buildEditScreen() {
        editEntry = new JTextField();
        editButton = new JButton("Click to confirm entry to edit");
        endEditingButton = new JButton("Exit");

        editPanel.add(currentToDoList);
        editPanel.add(editEntry);
        editPanel.add(editButton);
        editPanel.add(endEditingButton);
    }

    private void showRemoveScreen() {
        frame.remove(panel);
        frame.add(removePanel, BorderLayout.CENTER);

        frame.validate();
    }

    public void showAddScreen() {
        frame.remove(panel);
        frame.add(addPanel, BorderLayout.CENTER);

        frame.validate();
    }

    public void showEditScreen() {
        frame.remove(panel);
        frame.add(editPanel, BorderLayout.CENTER);

        frame.validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addToListButton) {
            showAddScreen();

        } else if (e.getSource() == removeFromListButton) {
            showRemoveScreen();

        } else if (e.getSource() == editFromListButton) {
            showEditScreen();

        } else if (e.getSource() == endAddingButton) {
            frame.remove(addPanel);
            frame.add(panel, BorderLayout.CENTER);

            frame.validate(); // don't know why this isn't working. addPanel is staying for some reason
        }
    }
}
