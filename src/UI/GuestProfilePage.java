package UI;

import app.Guest;

import javax.swing.*;
import java.awt.*;

public class GuestProfilePage extends JPanel {
    public JButton getLogout() {
        return logout;
    }
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel emailLabel;
    private JLabel streetLabel;
    private JLabel cityLabel;
    private JLabel countryLabel;
    private JLabel zipLabel;
    private JTextField firstNameField;

    private JTextField lastNameField;
    private JTextField emailField;
    private JTextField streetField;
    private JTextField cityField;
    private JTextField countryField;
    private JTextField zipField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;

    private JButton editButton;
    private JButton logout;
    private JButton saveButton;
    public GuestProfilePage(Guest g){
        Dimension dim=getPreferredSize();
        dim.width=400;
        setPreferredSize(dim);
        setBorder(BorderFactory.createTitledBorder("Guest Profile"));
        logout=new JButton("Logout");

        firstNameLabel=new JLabel("First Name:  ");
        lastNameLabel = new JLabel("Last Name:  ");
        emailLabel = new JLabel("Email:  ");
        streetLabel = new JLabel("Street Address:  ");
        cityLabel = new JLabel("City:  ");
        countryLabel= new JLabel("Country:  ");
        zipLabel = new JLabel("Zipcode:  ");
        passwordLabel = new JLabel("Password:  ");

        firstNameField=new JTextField(10);
        lastNameField=new JTextField(10);
        emailField =new JTextField(16);
        streetField=new JTextField(20);
        cityField=new JTextField(10);
        countryField=new JTextField(5);
        zipField=new JTextField(6);
        passwordField=new JPasswordField(10);

        firstNameField.setText(g.getFirstName());
        lastNameField.setText(g.getLastName());
        emailField.setText(g.getEmail());
        streetField.setText(g.getStreet());
        cityField.setText(g.getCity());
        countryField.setText(g.getCountry());
        zipField.setText(g.getZip());
        passwordField.setText(g.getPassword().toString());

        setFieldsEditableFalse();

        setLayout(new GridBagLayout());

        GridBagConstraints gc=new GridBagConstraints();

        //First Row
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
        gc.gridx=4;
        gc.gridy=0;
        gc.anchor = GridBagConstraints.EAST;
        add(logout,gc);

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
        add(streetLabel,gc);

        gc.gridx=1;
        gc.gridy=2;
        gc.anchor = GridBagConstraints.LINE_START;
        add(streetField,gc);

        //4th Row
        gc.weightx=.1;
        gc.weighty=.1;
        gc.gridx=0;
        gc.gridy=3;
        gc.anchor = GridBagConstraints.LINE_END;
        add(cityLabel,gc);

        gc.gridx=1;
        gc.gridy=3;
        gc.anchor = GridBagConstraints.LINE_START;
        add(cityField,gc);

        gc.gridx=2;
        gc.gridy=3;
        gc.anchor = GridBagConstraints.CENTER;
        add(countryLabel,gc);

        gc.gridx=3;
        gc.gridy=3;
        gc.anchor = GridBagConstraints.CENTER;
        add(countryField,gc);

        gc.gridx=4;
        gc.gridy=3;
        gc.anchor = GridBagConstraints.LINE_END;
        add(zipLabel,gc);

        gc.gridx=5;
        gc.gridy=3;
        gc.anchor = GridBagConstraints.LINE_START;
        add(zipField,gc);

        //5th row
        gc.weightx=1;
        gc.weighty=.1;
        gc.gridx=0;
        gc.gridy=4;
        gc.anchor = GridBagConstraints.LINE_END;
        add(emailLabel,gc);

        gc.gridx=1;
        gc.gridy=4;
        gc.anchor = GridBagConstraints.LINE_START;
        add(emailField,gc);
        //6th row
        gc.weightx=1;
        gc.weighty=.1;
        gc.gridx=0;
        gc.gridy=5;
        gc.anchor = GridBagConstraints.LINE_END;
        add(passwordLabel,gc);

        gc.gridx=1;
        gc.gridy=5;
        gc.anchor = GridBagConstraints.LINE_START;
        add(passwordField,gc);
        //7th row
        editButton=new JButton("Edit");
        gc.weightx=1;
        gc.weighty=1;
        gc.gridx=1;
        gc.gridy=6;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(editButton,gc);

        saveButton=new JButton("Save");
        gc.weightx=1;
        gc.weighty=1;
        gc.gridx=1;
        gc.gridy=6;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(saveButton,gc);
        saveButton.setVisible(false);

        editButton.addActionListener(e -> {
            setFieldEditableTrue();
            editButton.setVisible(false);
            saveButton.setVisible(true);
        });
        saveButton.addActionListener(e1 -> {
            g.setFirstName(firstNameField.getText());
            g.setLastName(lastNameField.getText());
            g.setEmail(emailField.getText());
            g.setStreet(streetField.getText());
            g.setCity(cityField.getText());
            g.setCountry(countryField.getText());
            g.setZip(zipField.getText());
            g.setPassword(passwordField.getPassword());
            setFieldsEditableFalse();
            saveButton.setVisible(false);
            editButton.setVisible(true);
        });
    }
    private void setFieldsEditableFalse(){
        firstNameField.setEditable(false);
        lastNameField.setEditable(false);
        emailField.setEditable(false);
        streetField.setEditable(false);
        cityField.setEditable(false);
        countryField.setEditable(false);
        zipField.setEditable(false);
        passwordField.setEditable(false);

    }
    private void setFieldEditableTrue(){
        firstNameField.setEditable(true);
        lastNameField.setEditable(true);
        emailField.setEditable(true);
        streetField.setEditable(true);
        cityField.setEditable(true);
        countryField.setEditable(true);
        zipField.setEditable(true);
        passwordField.setEditable(true);
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

    public JTextField getStreetField() {
        return streetField;
    }

    public JTextField getCityField() { return cityField; }

    public JTextField getCountryField() {
        return countryField;
    }

    public JTextField getZipField() {
        return zipField;
    }
}
