package UserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class GUI implements ActionListener{
    private JFrame frame;
    private JPanel panel;
    private JButton addToListButton;
    private JButton removeFromListButton;
    private JButton editFromListButton;
    private JLabel welcomeLabel;

    public void start() {
        buildInitialScreen();
    }

    public void buildInitialScreen() {
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
        panel.add(editFromListButton);


        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    private void addToListClicked() {

    }

    private void removeFromListClicked() {
        
    }

    private void editFromListClicked() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addToListButton) {
            
        } else if (e.getSource() == removeFromListButton) {
            
        }
        
    }

    private void hideWelcomeAndButtons() {
        addToListButton.setVisible(false);
        removeFromListButton.setVisible(false);
        editFromListButton.setVisible(false);
        welcomeLabel.setVisible(false);
    }

    private void showWelcomeAndButtons() {
        addToListButton.setVisible(true);
        removeFromListButton.setVisible(true);
        editFromListButton.setVisible(true);
        welcomeLabel.setVisible(true);
    }
}
