package UI;

import javax.swing.*;
import java.awt.*;

public class AdminLoginForm extends JPanel {
    private JButton submitButton;
    private JLabel passwordLabel;
    //private JLabel emailLabel;
    private JPasswordField passwordField;
    //private JTextField emailField;

    public AdminLoginForm(){
        Dimension dim = getPreferredSize();
        dim.width = 400;
        setPreferredSize(dim);
        setBorder(BorderFactory.createTitledBorder("Admin Login"));

        passwordField = new JPasswordField(10);
        submitButton = new JButton("Login");
        passwordLabel = new JLabel("Password: ");

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        //First Row
        gc.weightx = 1;
        gc.weighty = .1;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        add(passwordLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(passwordField, gc);

        //Second Row
        gc.weightx = 1;
        gc.weighty = 1;
        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(submitButton, gc);
    }

    public JButton getSubmitButton() {
        return submitButton;
    }
    public JPasswordField getPasswordField() {
        return passwordField;
    }

}
