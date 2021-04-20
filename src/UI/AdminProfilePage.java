package UI;

import app.Admin;
import javax.swing.*;
import java.awt.*;

public class AdminProfilePage extends JPanel {
    public JButton getLogout() {
        return logoutButton;
    }

    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel emailLabel;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton editButton;
    private JButton logoutButton;
    private JButton saveButton;

    public AdminProfilePage(Admin a) {
        Dimension dim = getPreferredSize();
        dim.width = 400;
        setPreferredSize(dim);
        setBorder(BorderFactory.createTitledBorder("Admin Profile"));
        logoutButton = new JButton("Logout");

        firstNameLabel=new JLabel("First Name:  ");
        lastNameLabel = new JLabel("Last Name:  ");
        emailLabel = new JLabel("Email:  ");
        passwordLabel = new JLabel("Password:  ");

        firstNameField=new JTextField(10);
        lastNameField=new JTextField(10);
        emailField =new JTextField(16);
        passwordField=new JPasswordField(10);

        firstNameField.setText(a.getFirstName());
        lastNameField.setText(a.getLastName());
        emailField.setText(a.getEmail());
        passwordField.setText(a.getPassword().toString());

        setFieldsEditableFalse();
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        //First Row
        gc.weightx=1;
        gc.weighty=.1;
        gc.gridx=0;
        gc.gridy=0;
        gc.fill=GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        add(firstNameLabel, gc);

        gc.gridx=1;
        gc.gridy=0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(firstNameField, gc);
        gc.gridx=4;
        gc.gridy=0;
        gc.anchor = GridBagConstraints.EAST;
        add(logoutButton, gc);

        //2nd Row
        gc.weightx=1;
        gc.weighty=.1;
        gc.gridx=0;
        gc.gridy=1;
        gc.anchor = GridBagConstraints.LINE_END;
        add(lastNameLabel, gc);

        gc.gridx=1;
        gc.gridy=1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(lastNameField, gc);

        //3rd row
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

    }


    private void setFieldsEditableFalse() {
        firstNameField.setEditable(false);
        lastNameField.setEditable(false);
        emailField.setEditable(false);
        passwordField.setEditable(false);
    }


    public JTextField getFirstNameField() {
        return firstNameField;
    }

    public JTextField getLastNameField() {
        return lastNameField;
    }

    public JTextField getEmailField() {
        return emailField;
    }


}
