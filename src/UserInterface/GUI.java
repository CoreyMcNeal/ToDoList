package UserInterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Main.ToDoList;

public class GUI implements ActionListener {
    private ToDoList tdList;
    private ImageIcon notepadIcon = new ImageIcon("src/images/notepadMessage.png");

    private JFrame frame;                                   // homepage panel objects declared
    private JPanel panel;
    private JButton addToListButton, removeFromListButton, editFromListButton;

    private JPanel addPanel;                                // add panel objects declared
    private JTextField addEntry;
    private JButton addButton, endAddingButton;

    private JPanel removePanel;                             // remove panel objects declared
    private JTextField removeEntry;
    private JButton removeButton, endRemovingButton;

    private JPanel editPanel;                               // editing panel objects declared
    private JTextField editEntry;
    private JButton editButton, endEditingButton;
    private String entry, newEntry;

    private JPanel confirmPanel;                            // confirm panel objects declared
    private JTextField confirmEntry;
    private JButton confirmButton, endConfirmButton;

    private JLabel welcomeLabel, addFeedbackLabel, removeFeedbackLabel, editFeedbackLabel;
    private JLabel confirmFeedbackLabel;

    private JButton showListHomeButton, showListAddButton, showListRemoveButton;    // ShowList buttons declared
    private JButton showListEditButton, showListConfirmButton;

    public GUI() {
        this.tdList = new ToDoList();
    }

    public void start() {
        buildScreens();
    }

    public void buildScreens() {            // calls Add, Remove, Edit, and Confirm builder methods, along with creating
        frame = new JFrame();               // the necessary panels dimensions
        panel = new JPanel();
        addPanel = new JPanel();
        removePanel = new JPanel();
        editPanel = new JPanel();
        confirmPanel = new JPanel();
        
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));      
        panel.setLayout(new GridLayout(0, 1));
        addPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        addPanel.setLayout(new GridLayout(0, 1));
        removePanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        removePanel.setLayout(new GridLayout(0, 1));
        editPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        editPanel.setLayout(new GridLayout(0, 1));
        confirmPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        confirmPanel.setLayout(new GridLayout(0, 1));

        buildHomePanel();
        buildAddPanel();
        buildRemovePanel();
        buildEditPanel();
        buildConfirmPanel();

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("ToDoList");
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    private void buildHomePanel() {                                                     //builds home panel
        welcomeLabel = new JLabel("Welcome to the ToDoList!", SwingConstants.CENTER);

        addToListButton = new JButton("Add To List");
        removeFromListButton = new JButton("Remove from List");
        editFromListButton = new JButton("Edit from list");
        showListHomeButton = new JButton("Show List");

        addToListButton.addActionListener(this);
        removeFromListButton.addActionListener(this);
        editFromListButton.addActionListener(this);
        showListHomeButton.addActionListener(this);
        
        panel.add(welcomeLabel);
        panel.add(new JLabel(notepadIcon));
        panel.add(addToListButton);
        panel.add(removeFromListButton);
        panel.add(editFromListButton);
        panel.add(showListHomeButton);
    }

    private void buildAddPanel() {             //builds the Add to List panel

        addFeedbackLabel = new JLabel("");
        addEntry = new JTextField();
        addButton = new JButton("Add");
        showListAddButton = new JButton("Show List");
        endAddingButton = new JButton("Exit");

        showListAddButton.addActionListener(this);
        addButton.addActionListener(this);
        addEntry.addActionListener(this);
        endAddingButton.addActionListener(this);

        addPanel.add(addFeedbackLabel);
        addPanel.add(addEntry);
        addPanel.add(addButton);
        addPanel.add(showListAddButton);
        addPanel.add(endAddingButton);
    }

    private void buildRemovePanel() {          //builds the remove from list panel

        removeFeedbackLabel = new JLabel("");
        removeEntry = new JTextField();
        removeButton = new JButton("Remove");
        showListRemoveButton = new JButton("Show List");
        endRemovingButton = new JButton("Exit");

        showListRemoveButton.addActionListener(this);
        removeButton.addActionListener(this);
        removeEntry.addActionListener(this);
        endRemovingButton.addActionListener(this);

        removePanel.add(removeFeedbackLabel);
        removePanel.add(removeEntry);
        removePanel.add(removeButton);
        removePanel.add(showListRemoveButton);
        removePanel.add(endRemovingButton);

    }

    private void buildEditPanel() {                       //builds the edit list panel
        editFeedbackLabel = new JLabel("");
        editEntry = new JTextField();
        editButton = new JButton("Confirm entry to edit");
        showListEditButton = new JButton("Show List");
        endEditingButton = new JButton("Exit");

        showListEditButton.addActionListener(this);
        editButton.addActionListener(this);
        editEntry.addActionListener(this);
        endEditingButton.addActionListener(this);
        
        editPanel.add(editFeedbackLabel);
        editPanel.add(editEntry);
        editPanel.add(editButton);
        editPanel.add(showListEditButton);
        editPanel.add(endEditingButton);
    }

    private void buildConfirmPanel() {          // builds the confirm panel

        confirmFeedbackLabel = new JLabel("");
        confirmEntry = new JTextField();
        confirmButton = new JButton("Confirm edit");
        showListConfirmButton = new JButton("Show List");
        endConfirmButton = new JButton("Exit");

        showListConfirmButton.addActionListener(this);
        confirmButton.addActionListener(this);
        confirmEntry.addActionListener(this);
        endConfirmButton.addActionListener(this);

        confirmPanel.add(confirmFeedbackLabel);
        confirmPanel.add(confirmEntry);
        confirmPanel.add(confirmButton);
        confirmPanel.add(showListConfirmButton);
        confirmPanel.add(endConfirmButton);
    }

    public void showAddPanel() {   // removes home panel and displays add panel
        frame.remove(panel);
        panel.setVisible(false);

        frame.add(addPanel, BorderLayout.CENTER);
        addPanel.setVisible(true);

        frame.validate();
    }

    private void showRemovePanel() { // removes home panel and displays remove panel
        frame.remove(panel);
        panel.setVisible(false);

        frame.add(removePanel, BorderLayout.CENTER);
        removePanel.setVisible(true);

        frame.validate();
    }

    public void showEditPanel() {          // removes home panel and displays edit panel
        frame.remove(panel);
        panel.setVisible(false);

        frame.add(editPanel, BorderLayout.CENTER);
        editPanel.setVisible(true);

        frame.validate();
    }

    public void showConfirmPanel() {        // removes edit panel and displays the confirm panel
        frame.remove(editPanel);
        editPanel.setVisible(false);

        frame.add(confirmPanel, BorderLayout.CENTER);
        confirmPanel.setVisible(true);

        frame.validate();
    }

    @Override  
    public void actionPerformed(ActionEvent e) {        //Button logic, directs to different conditionals based on 
        if (e.getSource() == addToListButton) {         //the button clicked
            showAddPanel();

        } else if (e.getSource() == removeFromListButton) {
            showRemovePanel();

        } else if (e.getSource() == editFromListButton) {
            showEditPanel();

        } else if (e.getSource() ==  addButton || e.getSource() == addEntry) {
            String entry = addEntry.getText();
            int result = this.tdList.add(entry);
            if (result == 0) {
                addFeedbackLabel.setText(entry + " was added.");
            } else if (result == 1){
                addFeedbackLabel.setText("Item already in list.");
            } else if (result == 2) {
                addFeedbackLabel.setText("Entry was blank, please try again.");
            }
            
        } else if (e.getSource() == removeButton || e.getSource() == removeEntry) {
            String entry = removeEntry.getText();
            if (this.tdList.remove(entry)) {
                removeFeedbackLabel.setText(entry + " was removed.");
            } else {
                removeFeedbackLabel.setText("Item not in list.");
            }

        } else if (e.getSource() == editButton || e.getSource() == editEntry) {           
            entry = editEntry.getText();                        
            if (this.tdList.exists(entry)) {
                showConfirmPanel();

            } else {
                editFeedbackLabel.setText("Item not in list.");
                frame.validate();
            }

        } else if (e.getSource() == confirmButton || e.getSource() == confirmEntry) {    
            newEntry = confirmEntry.getText();                
            this.tdList.replace(entry, newEntry);                        
            confirmButton.setEnabled(false);

            confirmFeedbackLabel.setText("Entry successfully edited.");
            frame.validate();

        } else if (e.getSource() == showListHomeButton) {                           // shows list in popup box
            showTasksInWindow();
        } else if (e.getSource() == showListAddButton) {
            showTasksInWindow();
        } else if (e.getSource() == showListRemoveButton) {
            showTasksInWindow();
        } else if (e.getSource() == showListEditButton) {
            showTasksInWindow();
        } else if (e.getSource() == showListConfirmButton) {
            showTasksInWindow();
        }else if (e.getSource() == endAddingButton) {                       //exits add to list panel
            homePanel(addPanel);
        } else if (e.getSource() == endRemovingButton) {                    //exits remove from list panel
            homePanel(removePanel);
        } else if (e.getSource() == endEditingButton) {                     // exits edit list panel
            homePanel(editPanel);
        } else if (e.getSource() == endConfirmButton) {                     // exits confirm entry panel
            homePanel(confirmPanel);
            confirmButton.setEnabled(true);
        }
    }

    public void homePanel(JPanel currentPanel) {    //hides and removes current panel and displays the home panel
        currentPanel.setVisible(false);
        clearLabelsAndEntries();
        frame.remove(currentPanel);

        panel.setVisible(true);
        frame.add(panel, BorderLayout.CENTER);
        frame.validate();
    }

    public void clearLabelsAndEntries() { // clears all feedback labels and entry boxes for all panels
        addFeedbackLabel.setText("");
        removeFeedbackLabel.setText("");
        editFeedbackLabel.setText("");
        confirmFeedbackLabel.setText("");
        addEntry.setText("");
        removeEntry.setText("");
        editEntry.setText("");
        confirmEntry.setText(""); 
    }

    public void showTasksInWindow() {
        JOptionPane.showMessageDialog(frame, this.tdList.getTaskListAsString(),
        "List of Tasks", JOptionPane.INFORMATION_MESSAGE, notepadIcon);
    }
}
