package UserInterface;

import Main.ToDoList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUI implements ActionListener {
    private ToDoList tdList;

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
    private JButton editButton, newSubmitButton, endEditingButton;
    private String entry, newEntry;

    private JLabel welcomeLabel, currentToDoList, addFeedbackLabel, removeFeedbackLabel, editFeedbackLabel;
    

    public GUI() {
        this.tdList = new ToDoList();
    }

    public void start() {
        buildScreens();
    }

    public void buildScreens() {
        ToDoList tdList = new ToDoList();
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

    private void buildAddScreen() {
        addFeedbackLabel = new JLabel("");
        addEntry = new JTextField();
        addButton = new JButton("Add");
        endAddingButton = new JButton("Exit");
        addButton.addActionListener(this);
        endAddingButton.addActionListener(this);

        addPanel.add(addFeedbackLabel);
        addPanel.add(currentToDoList);
        addPanel.add(addEntry);
        addPanel.add(addButton);
        addPanel.add(endAddingButton);
    }

    private void buildRemoveScreen() {
        removeFeedbackLabel = new JLabel("");
        removeEntry = new JTextField();
        removeButton = new JButton("Remove");
        endRemovingButton = new JButton("Exit");
        removeButton.addActionListener(this);
        endRemovingButton.addActionListener(this);

        removePanel.add(removeFeedbackLabel);
        removePanel.add(currentToDoList);
        removePanel.add(removeEntry);
        removePanel.add(removeButton);
        removePanel.add(endRemovingButton);

    }

    private void buildEditScreen() {
        editFeedbackLabel = new JLabel("");
        editEntry = new JTextField();
        editButton = new JButton("Click to confirm entry to edit");
        newSubmitButton = new JButton("Click to submit new entry");
        endEditingButton = new JButton("Exit");
        editButton.addActionListener(this);
        endEditingButton.addActionListener(this);
        newSubmitButton.addActionListener(this);
        
        editPanel.add(editFeedbackLabel);
        editPanel.add(currentToDoList);
        editPanel.add(editEntry);
        editPanel.add(editButton);
        editPanel.add(endEditingButton);
    }

    public void showAddScreen() {
        frame.remove(panel);
        panel.setVisible(false);

        frame.add(addPanel, BorderLayout.CENTER);
        addPanel.setVisible(true);

        frame.validate();
    }

    private void showRemoveScreen() {
        frame.remove(panel);
        panel.setVisible(false);

        frame.add(removePanel, BorderLayout.CENTER);
        removePanel.setVisible(true);

        frame.validate();
    }

    public void showEditScreen() {
        frame.remove(panel);
        panel.setVisible(false);

        frame.add(editPanel, BorderLayout.CENTER);
        editPanel.setVisible(true);

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

        } else if (e.getSource() ==  addButton) {
            String entry = addEntry.getText();
            if (tdList.add(entry)) {
                addFeedbackLabel.setText(entry + " was added.");
            } else {
                addFeedbackLabel.setText("Item already in list.");
            }
            
        } else if (e.getSource() == removeButton) {
            String entry = removeEntry.getText();
            if (tdList.remove(entry)) {
                removeFeedbackLabel.setText(entry + " was removed.");
            } else {
                removeFeedbackLabel.setText("Item not in list.");
            }

        } else if (e.getSource() == editButton) {
            entry = editEntry.getText();
            if (tdList.exists(entry)) {
                editPanel.remove(editButton);
                editPanel.remove(endEditingButton);
                editPanel.add(newSubmitButton);
                editPanel.add(endEditingButton);

                frame.validate();
            } else {
                editFeedbackLabel.setText("Item not in list.");
                frame.validate();
            }
        } else if (e.getSource() == newSubmitButton) {
            newEntry = editEntry.getText();                         // editFeedbackLabel not updating for success
            tdList.replace(entry, newEntry);                        // 

            editPanel.remove(newSubmitButton);
            editPanel.remove(endEditingButton);
            editPanel.add(editButton);
            editPanel.add(endEditingButton);
            
            editFeedbackLabel.setText("Entry successfully edited.");
            frame.validate();

        } else if (e.getSource() == endAddingButton) {
            addPanel.setVisible(false);
            frame.remove(addPanel);
            homePanel();
        } else if (e.getSource() == endRemovingButton) {
            removePanel.setVisible(false);
            frame.remove(removePanel);
            homePanel();
        } else if (e.getSource() == endEditingButton) {
            editPanel.setVisible(false);
            frame.remove(editPanel);
            homePanel();
        }
    }

    public void homePanel() {
        panel.setVisible(true);
        frame.add(panel, BorderLayout.CENTER);
        frame.validate();
    }


}
