package UserInterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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

    private JPanel listPanel;
    private JLabel listHeader;
    private JScrollPane scrollPane;
    private JList<String> taskList;
    private DefaultListModel<String> model = new DefaultListModel<String>();

    public GUI() {
        this.tdList = new ToDoList();
    }

    public void start() {
        buildScreens();
    }

    private void buildScreens() {            // calls Add, Remove, Edit, and Confirm builder methods, along with creating
        frame = new JFrame();               // the necessary panels dimensions
        panel = new JPanel();
        addPanel = new JPanel();
        removePanel = new JPanel();
        editPanel = new JPanel();
        confirmPanel = new JPanel();
        listPanel = new JPanel();
        
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
        listPanel.setBorder(BorderFactory.createEmptyBorder(80, 10, 20, 10));
        listPanel.setLayout(new GridLayout(0, 1));

        buildHomePanel();
        buildAddPanel();
        buildRemovePanel();
        buildEditPanel();
        buildConfirmPanel();
        buildListPanel();

        frame.add(panel, BorderLayout.CENTER);
        frame.add(listPanel, BorderLayout.WEST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("ToDoList");
        frame.setSize(700, 400);
        frame.setVisible(true);
    }

    private void buildHomePanel() {                                                     //builds home panel
        welcomeLabel = new JLabel("Welcome to the ToDoList!", SwingConstants.CENTER);

        addToListButton = new JButton("Add To List");
        removeFromListButton = new JButton("Remove from List");
        editFromListButton = new JButton("Edit from list");

        addToListButton.addActionListener(this);
        removeFromListButton.addActionListener(this);
        editFromListButton.addActionListener(this);
        
        panel.add(welcomeLabel);
        panel.add(new JLabel(notepadIcon));
        panel.add(addToListButton);
        panel.add(removeFromListButton);
        panel.add(editFromListButton);
    }

    private void buildAddPanel() {             //builds the Add to List panel

        addFeedbackLabel = new JLabel("");
        addEntry = new JTextField();
        addButton = new JButton("Add");
        endAddingButton = new JButton("Exit");

        addButton.addActionListener(this);
        addEntry.addActionListener(this);
        endAddingButton.addActionListener(this);

        addPanel.add(addFeedbackLabel);
        addPanel.add(addEntry);
        addPanel.add(addButton);
        addPanel.add(endAddingButton);
    }

    private void buildRemovePanel() {          //builds the remove from list panel

        removeFeedbackLabel = new JLabel("");
        removeEntry = new JTextField();
        removeButton = new JButton("Remove");
        endRemovingButton = new JButton("Exit");

        removeButton.addActionListener(this);
        removeEntry.addActionListener(this);
        endRemovingButton.addActionListener(this);

        removePanel.add(removeFeedbackLabel);
        removePanel.add(removeEntry);
        removePanel.add(removeButton);
        removePanel.add(endRemovingButton);

    }

    private void buildEditPanel() {                       //builds the edit list panel
        editFeedbackLabel = new JLabel("");
        editEntry = new JTextField();
        editButton = new JButton("Confirm entry to edit");
        endEditingButton = new JButton("Exit");

        editButton.addActionListener(this);
        editEntry.addActionListener(this);
        endEditingButton.addActionListener(this);
        
        editPanel.add(editFeedbackLabel);
        editPanel.add(editEntry);
        editPanel.add(editButton);
        editPanel.add(endEditingButton);
    }

    private void buildConfirmPanel() {          // builds the confirm panel

        confirmFeedbackLabel = new JLabel("");
        confirmEntry = new JTextField();
        confirmButton = new JButton("Confirm edit");
        endConfirmButton = new JButton("Exit");

        confirmButton.addActionListener(this);
        confirmEntry.addActionListener(this);
        endConfirmButton.addActionListener(this);

        confirmPanel.add(confirmFeedbackLabel);
        confirmPanel.add(confirmEntry);
        confirmPanel.add(confirmButton);
        confirmPanel.add(endConfirmButton);
    }

    private void buildListPanel() {
        tdList.getTaskList().stream()
                            .forEach(entry -> model.addElement(entry));

        listHeader = new JLabel("Tasks:");
        taskList = new JList<String>();
        taskList.setModel(model);
        scrollPane = new JScrollPane(taskList);
        taskList.setFixedCellWidth(200);
        listPanel.add(listHeader);
        listPanel.add(scrollPane);
    }

    private void showAddPanel() {   // removes home panel and displays add panel
        frame.remove(panel);
        panel.setVisible(false);

        frame.add(addPanel, BorderLayout.CENTER);
        addPanel.setVisible(true);
        addEntry.requestFocus();

        frame.validate();
    }

    private void showRemovePanel() { // removes home panel and displays remove panel
        frame.remove(panel);
        panel.setVisible(false);

        frame.add(removePanel, BorderLayout.CENTER);
        removePanel.setVisible(true);
        removeEntry.requestFocus();

        frame.validate();
    }

    private void showEditPanel() {          // removes home panel and displays edit panel
        frame.remove(panel);
        panel.setVisible(false);

        frame.add(editPanel, BorderLayout.CENTER);
        editPanel.setVisible(true);
        editEntry.requestFocus();

        frame.validate();
    }

    private void showConfirmPanel() {        // removes edit panel and displays the confirm panel
        frame.remove(editPanel);
        editPanel.setVisible(false);

        frame.add(confirmPanel, BorderLayout.CENTER);
        confirmPanel.setVisible(true);
        confirmEntry.requestFocus();

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
            addEntry.setText("");
            int result = this.tdList.add(entry);
            if (result == 0) {
                addFeedbackLabel.setText(entry + " was added.");
                refreshTaskListAndFrame();
            } else if (result == 1){
                addFeedbackLabel.setText("Item already in list.");
            } else if (result == 2) {
                addFeedbackLabel.setText("Entry was blank, please try again.");
            }
            
        } else if (e.getSource() == removeButton || e.getSource() == removeEntry) {
            String entry = removeEntry.getText();
            removeEntry.setText("");
            if (this.tdList.remove(entry)) {
                removeFeedbackLabel.setText(entry + " was removed.");
                refreshTaskListAndFrame();
            } else {
                removeFeedbackLabel.setText("Item not in list.");
            }

        } else if (e.getSource() == editButton || e.getSource() == editEntry) {           
            entry = editEntry.getText();       
            editEntry.setText("");                 
            if (this.tdList.exists(entry)) {
                showConfirmPanel();

            } else {
                editFeedbackLabel.setText("Item not in list.");
                frame.validate();
            }

        } else if (e.getSource() == confirmButton || e.getSource() == confirmEntry) {    
            newEntry = confirmEntry.getText();
            if (this.tdList.exists(newEntry)) {
                confirmFeedbackLabel.setText("Entry already in list.");
            } else {
                confirmEntry.setText("");            
                this.tdList.replace(entry, newEntry);                        
                confirmButton.setEnabled(false);

                confirmFeedbackLabel.setText("Entry successfully edited.");
                refreshTaskListAndFrame();
            } 

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

    private void homePanel(JPanel currentPanel) {    //hides and removes current panel and displays the home panel
        currentPanel.setVisible(false);
        clearLabelsAndEntries();
        frame.remove(currentPanel);

        panel.setVisible(true);
        frame.add(panel, BorderLayout.CENTER);
        frame.validate();
    }

    private void clearLabelsAndEntries() { // clears all feedback labels and entry boxes for all panels
        addFeedbackLabel.setText("");
        removeFeedbackLabel.setText("");
        editFeedbackLabel.setText("");
        confirmFeedbackLabel.setText("");
        addEntry.setText("");
        removeEntry.setText("");
        editEntry.setText("");
        confirmEntry.setText(""); 
    }

    private void refreshTaskListAndFrame() {
        model.clear();
        tdList.getTaskList().stream()
                            .forEach(entry -> model.addElement(entry));
        
        frame.validate();
    }
}
