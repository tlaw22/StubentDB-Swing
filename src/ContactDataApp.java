import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class ContactDataApp {

    private JFrame frame;
    private JPanel panel;
    private CardLayout layout;
    private JPanel inputPanel, outputPanel;
    private JLabel nameLabel, studentIDLabel, stopLocationLabel, routeNumberLabel, contactDateLabel, contactTimeLabel, subjectLabel, contactDetailLabel;
    private JTextField nameTextField, studentIDTextField, stopLocationTextField, routeNumberTextField, contactDateTextField, contactTimeTextField, subjectTextField;
    private JTextArea contactDetailTextArea;
    private JButton submitButton, closeButton;

    public ContactDataApp() {
        frame = new JFrame("Contact Data App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        layout = new CardLayout();
        panel.setLayout(layout);

        inputPanel = new JPanel();
        outputPanel = new JPanel();

        nameLabel = new JLabel("Name");
        studentIDLabel = new JLabel("Student ID");
        stopLocationLabel = new JLabel("Stop Location");
        routeNumberLabel = new JLabel("Route Number");
        contactDateLabel = new JLabel("Contact Date");
        contactTimeLabel = new JLabel("Contact Time");
        subjectLabel = new JLabel("Subject");
        contactDetailLabel = new JLabel("Contact Detail");

        nameTextField = new JTextField(30);
        studentIDTextField = new JTextField(30);
        stopLocationTextField = new JTextField(30);
        routeNumberTextField = new JTextField(30);
        contactDateTextField = new JTextField(30);
        contactTimeTextField = new JTextField(30);
        subjectTextField = new JTextField(30);
        contactDetailTextArea = new JTextArea(30, 30);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the contact data from the text fields
                String name = nameTextField.getText();
                String studentID = studentIDTextField.getText();
                String stopLocation = stopLocationTextField.getText();
                String routeNumber = routeNumberTextField.getText();
                String contactDate = contactDateTextField.getText();
                String contactTime = contactTimeTextField.getText();
                String subject = subjectTextField.getText();
                String contactDetail = contactDetailTextArea.getText();

                // Write the data to the XML file
                try {
                    FileWriter writer = new FileWriter("data.xml");
                    writer.write("<contact>\n");
                    writer.write("<name>" + name + "</name>\n");
                    writer.write("<studentID>" + studentID + "</studentID>\n");
                    writer.write("<stopLocation>" + stopLocation + "</stopLocation>\n");
                    writer.write("<routeNumber>" + routeNumber + "</routeNumber>\n");
                    writer.write("<contactDate>" + contactDate + "</contactDate>\n");
                    writer.write("<contactTime>" + contactTime + "</contactTime>\n");
                    writer.write("<subject>" + subject + "</subject>\n");
                    writer.write("<contactDetail>" + contactDetail + "</contactDetail>\n");
                    writer.write("</contact>");
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                // Display a dialog that lets the user know the XML file was written
                JOptionPane.showMessageDialog(frame, "The XML file was written successfully.");
            }
        });

        closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        inputPanel.add(nameLabel);
        inputPanel.add(nameTextField);
        inputPanel.add(studentIDLabel);
        inputPanel.add(studentIDTextField);
        inputPanel.add(stopLocationLabel);
        inputPanel.add(stopLocationTextField);
        inputPanel.add(routeNumberLabel);
        inputPanel.add(routeNumberTextField);
        inputPanel.add(contactDateLabel);
        inputPanel.add(contactDateTextField);
        inputPanel.add(contactTimeLabel);
        inputPanel.add(contactTimeTextField);
        inputPanel.add(subjectLabel);
        inputPanel.add(subjectTextField);
        inputPanel.add(contactDetailLabel);
        inputPanel.add(contactDetailTextArea);
        inputPanel.add(submitButton);
        inputPanel.add(closeButton);

        // Add the input and output panels to the panel
        panel.add(inputPanel, "input");
        panel.add(outputPanel, "output");

        // Set the initial card
        layout.show(panel, "input");

        // Add the panel to the frame
        frame.add(panel);

        // Set the frame size
        frame.setSize(400, 400);

        // Set the frame visible
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ContactDataApp();
    }
}