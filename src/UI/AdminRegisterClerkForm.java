package UI;

import javax.swing.*;
import java.awt.*;
import app.Admin;
import app.Clerk;

public class AdminRegisterClerkForm extends JPanel {
    private JButton submitButton;
    private JLabel firstNameLabel, lastNameLabel, emailLabel, passwordLabel;
    private JTextField firstNameField, lastNameField, emailField;
    private JPasswordField passwordField;

    public AdminRegisterClerkForm(){
        Dimension dim = getPreferredSize();
        dim.width = 400;
        setPreferredSize(dim);
        setBorder(BorderFactory.createTitledBorder("Manage Clerks Page"));

        submitButton = new JButton("Submit");
        firstNameLabel=new JLabel("First Name: ");
        lastNameLabel = new JLabel("Last Name: ");
        emailLabel = new JLabel("Email: ");
        passwordLabel = new JLabel("Password: ");

        firstNameField = new JTextField(10);
        lastNameField = new JTextField(10);
        emailField = new JTextField(16);
        passwordField = new JPasswordField(10);

        setFieldsEditableTrue();
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        // first row
        gc.weightx=1;
        gc.weighty=.1;
        gc.gridx=0;
        gc.gridy=0;
        gc.fill=GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        add(firstNameLabel,gc);

        gc.gridx=1;
        gc.gridy=0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(firstNameField,gc);

        //2nd Row
        gc.weightx=1;
        gc.weighty=.1;
        gc.gridx=0;
        gc.gridy=1;
        gc.anchor = GridBagConstraints.LINE_END;
        add(lastNameLabel,gc);

        gc.gridx=1;
        gc.gridy=1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(lastNameField,gc);

        //3rd Row
        gc.weightx=1;
        gc.weighty=.1;
        gc.gridx=0;
        gc.gridy=2;
        gc.anchor = GridBagConstraints.LINE_END;
        add(emailLabel, gc);

        gc.gridx=1;
        gc.gridy=2;
        gc.anchor = GridBagConstraints.LINE_START;
        add(emailField, gc);

        //4th Row
        gc.weightx=.1;
        gc.weighty=.1;
        gc.gridx=0;
        gc.gridy=3;
        gc.anchor = GridBagConstraints.LINE_END;
        add(passwordLabel, gc);

        gc.gridx=1;
        gc.gridy=3;
        gc.anchor = GridBagConstraints.LINE_START;
        add(passwordField, gc);


        submitButton = new JButton("Add Clerk");
        gc.weightx = 1;
        gc.weighty = 1;
        gc.gridx = 0;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(submitButton, gc);
        submitButton.setVisible(true);

        submitButton.addActionListener(e -> {
            Clerk c = new Clerk(
                    firstNameField.getText(),
                    lastNameField.getText(),
                    emailField.getText(),
                    passwordField.getPassword()
            );

            Clerk.addRegisteredClerk(c);
            System.out.println("CLERK REGISTERED!");

            firstNameField.setText("");
            lastNameField.setText("");
            emailField.setText("");
            passwordField.setText("");


        });
    }

    public JButton getSubmitButton() { return submitButton; }

    private void setFieldsEditableTrue(){
        firstNameField.setEditable(true);
        lastNameField.setEditable(true);
        emailField.setEditable(true);
        passwordField.setEditable(true);
    }
}
