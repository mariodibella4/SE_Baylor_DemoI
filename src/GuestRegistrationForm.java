import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//work on validators
public class GuestRegistrationForm extends JPanel{

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



    GuestRegistrationForm(){
        Dimension dim=getPreferredSize();
        dim.width=400;
        setPreferredSize(dim);
        setBorder(BorderFactory.createTitledBorder("Guest Registration"));

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

        submitButton = new JButton("Register");

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
        gc.weightx=1;
        gc.weighty=1;
        gc.gridx=1;
        gc.gridy=6;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(submitButton,gc);

        submitButton.addActionListener(e ->  {
            Guest.addNewGuest(this);
                }
        );
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

    public JTextField getCityField() {
        return cityField;
    }

    public JTextField getCountryField() {
        return countryField;
    }

    public JTextField getZipField() {
        return zipField;
    }

    public JLabel getPasswordLabel() {
        return passwordLabel;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }
    public JButton getSubmitButton() {
        return submitButton;
    }

    private JButton submitButton;
}

