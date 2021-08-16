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

    private JFrame frame;                                   // homepage panel objects declared
    private JPanel panel;
    private JButton addToListButton, removeFromListButton, editFromListButton;

    private JLabel addPanelTasks;
    private JPanel addPanel;                                // add panel objects declared
    private JTextField addEntry;
    private JButton addButton, endAddingButton;

    private JLabel removePanelTasks;
    private JPanel removePanel;                             // remove panel objects declared
    private JTextField removeEntry;
    private JButton removeButton, endRemovingButton;

    private JLabel editPanelTasks;
    private JPanel editPanel;                               // editing panel objects declared
    private JTextField editEntry;
    private JButton editButton, newSubmitButton, endEditingButton;
    private String entry, newEntry;

    private JLabel confirmPanelTasks;
    private JPanel confirmPanel;
    private JTextField confirmEntry;
    private JButton confirmButton, endConfirmButton;

    private JLabel welcomeLabel, addFeedbackLabel, removeFeedbackLabel, editFeedbackLabel;
    private JLabel confirmFeedbackLabel;

    public GUI() {
        this.tdList = new ToDoList();
    }

    public void start() {
        buildScreens();
    }

    public void buildScreens() {            //calls Add, Remove, Edit, and Confirm builder methods, along with creating
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
        frame.setTitle("Testing GUI");
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    private void buildHomePanel() {
        welcomeLabel = new JLabel("Welcome to the ToDoList!", SwingConstants.CENTER);

        addToListButton = new JButton("Add To List");
        addToListButton.addActionListener(this);

        removeFromListButton = new JButton("Remove from List");
        removeFromListButton.addActionListener(this);

        editFromListButton = new JButton("Edit from list");
        editFromListButton.addActionListener(this);

        panel.add(welcomeLabel);
        panel.add(addToListButton);
        panel.add(removeFromListButton);
        panel.add(editFromListButton);
    }

    private void buildAddPanel() {             //builds the Add to List panel
        addPanelTasks = new JLabel("");
        addFeedbackLabel = new JLabel("");
        addEntry = new JTextField();
        addButton = new JButton("Add");
        endAddingButton = new JButton("Exit");
        addButton.addActionListener(this);
        endAddingButton.addActionListener(this);

        addPanel.add(addPanelTasks);
        addPanel.add(addFeedbackLabel);
        addPanel.add(addEntry);
        addPanel.add(addButton);
        addPanel.add(endAddingButton);
    }

    private void buildRemovePanel() {          //builds the remove from list panel
        removePanelTasks = new JLabel("");
        removeFeedbackLabel = new JLabel("");
        removeEntry = new JTextField();
        removeButton = new JButton("Remove");
        endRemovingButton = new JButton("Exit");
        removeButton.addActionListener(this);
        endRemovingButton.addActionListener(this);

        removePanel.add(removePanelTasks);
        removePanel.add(removeFeedbackLabel);
        removePanel.add(removeEntry);
        removePanel.add(removeButton);
        removePanel.add(endRemovingButton);

    }

    private void buildEditPanel() {     
        editPanelTasks = new JLabel("");       //builds the edit list panel
        editFeedbackLabel = new JLabel("");
        editEntry = new JTextField();
        editButton = new JButton("Confirm entry to edit");
        newSubmitButton = new JButton("Click to submit new entry");
        endEditingButton = new JButton("Exit");
        editButton.addActionListener(this);
        endEditingButton.addActionListener(this);
        newSubmitButton.addActionListener(this);
        
        editPanel.add(editPanelTasks);
        editPanel.add(editFeedbackLabel);
        editPanel.add(editEntry);
        editPanel.add(editButton);
        editPanel.add(endEditingButton);
    }

    private void buildConfirmPanel() {          // builds the confirm panel
        confirmPanelTasks = new JLabel("");
        confirmFeedbackLabel = new JLabel("");
        confirmEntry = new JTextField();
        confirmButton = new JButton("Confirm edit");
        endConfirmButton = new JButton("Exit");
        confirmButton.addActionListener(this);
        endConfirmButton.addActionListener(this);

        confirmPanel.add(confirmPanelTasks);
        confirmPanel.add(confirmFeedbackLabel);
        confirmPanel.add(confirmEntry);
        confirmPanel.add(confirmButton);
        confirmPanel.add(endConfirmButton);
    }

    public void showAddPanel() {   // removes home panel and displays add panel
        addPanelTasks.setText(tdList.getTaskList());
        frame.remove(panel);
        panel.setVisible(false);

        frame.add(addPanel, BorderLayout.CENTER);
        addPanel.setVisible(true);

        frame.validate();
    }

    private void showRemovePanel() { // removes home panel and displays remove panel
        removePanelTasks.setText(tdList.getTaskList());
        frame.remove(panel);
        panel.setVisible(false);

        frame.add(removePanel, BorderLayout.CENTER);
        removePanel.setVisible(true);

        frame.validate();
    }

    public void showEditPanel() {          // removes home panel and displays edit panel
        editPanelTasks.setText(tdList.getTaskList());
        frame.remove(panel);
        panel.setVisible(false);

        frame.add(editPanel, BorderLayout.CENTER);
        editPanel.setVisible(true);

        frame.validate();
    }

    public void showConfirmPanel() {        // removes edit panel and displays the confirm panel
        confirmPanelTasks.setText(tdList.getTaskList());
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
                showConfirmPanel();

            } else {
                editFeedbackLabel.setText("Item not in list.");
                frame.validate();
            }

        } else if (e.getSource() == confirmButton) {    
            newEntry = confirmEntry.getText();                
            tdList.replace(entry, newEntry);                        

            confirmFeedbackLabel.setText("Entry successfully edited.");
            frame.validate();

        } else if (e.getSource() == endAddingButton) {  //exits add to list panel
            homePanel(addPanel);
        } else if (e.getSource() == endRemovingButton) { //exits remove from list panel
            homePanel(removePanel);
        } else if (e.getSource() == endEditingButton) { // exits edit list panel
            homePanel(editPanel);
        } else if (e.getSource() == endConfirmButton) { // exits confirm entry panel
            homePanel(confirmPanel);
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


}
