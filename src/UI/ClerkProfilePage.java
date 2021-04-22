package UI;

import app.Admin;
import javax.swing.*;
import java.awt.*;
import app.Clerk;

public class ClerkProfilePage extends JPanel
{
    public JButton getLogout()
    {
        return logout;
    }

    private JLabel clerkIDLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel emailLabel;
    private JTextField clerkIDField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton logout;

    public ClerkProfilePage(Clerk c) {
        Dimension dim = getPreferredSize();
        dim.width = 400;
        setPreferredSize(dim);
        setBorder(BorderFactory.createTitledBorder("Clerk Profile"));
        logout = new JButton("Logout");

        clerkIDLabel = new JLabel("Clerk ID: ");
        firstNameLabel=new JLabel("First Name:  ");
        lastNameLabel = new JLabel("Last Name:  ");
        emailLabel = new JLabel("Email:  ");
        passwordLabel = new JLabel("Password:  ");

        clerkIDField = new JTextField(10);
        firstNameField=new JTextField(10);
        lastNameField=new JTextField(10);
        emailField =new JTextField(16);
        passwordField=new JPasswordField(10);

        clerkIDField.setText(String.valueOf(c.getClerkID()));
        firstNameField.setText(c.getFirstName());
        lastNameField.setText(c.getLastName());
        emailField.setText(c.getEmail());
        passwordField.setText(c.getPassword().toString());

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
        add(clerkIDLabel, gc);

        gc.gridx=1;
        gc.gridy=0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(clerkIDField, gc);


        //2nd Row
        gc.weightx=1;
        gc.weighty=.1;
        gc.gridx=0;
        gc.gridy=1;
        gc.anchor = GridBagConstraints.LINE_END;
        add(firstNameLabel, gc);

        gc.gridx=1;
        gc.gridy=1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(firstNameField, gc);

        //3rd row
        gc.weightx=1;
        gc.weighty=.1;
        gc.gridx=0;
        gc.gridy=2;
        gc.anchor = GridBagConstraints.LINE_END;
        add(lastNameLabel, gc);

        gc.gridx=1;
        gc.gridy=2;
        gc.anchor = GridBagConstraints.LINE_START;
        add(lastNameField, gc);


        //4th row
        gc.weightx=1;
        gc.weighty=.1;
        gc.gridx=0;
        gc.gridy=3;
        gc.anchor = GridBagConstraints.LINE_END;
        add(emailLabel, gc);

        gc.gridx=1;
        gc.gridy=3;
        gc.anchor = GridBagConstraints.LINE_START;
        add(emailField, gc);

        setFieldsEditableFalse();
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
