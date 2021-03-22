import javax.swing.*;
import java.awt.*;

public class ReservationForm extends JPanel {
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel emailLabel;
    private JLabel streetLabel;
    private JLabel cityLabel;
    private JLabel countryLabel;
    private JLabel zipLabel;
    private JLabel checkInDate;
    private JLabel checkOutDate;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JTextField streetField;
    private JTextField cityField;
    private JTextField countryField;
    private JTextField zipField;

    private JButton editReservation;
    private JButton commitReservationButton;
    private JButton changeDatesButton;
    public ReservationForm(Guest g){
        Dimension dim=getPreferredSize();
        setPreferredSize(dim);
        setBorder(BorderFactory.createTitledBorder("Reservation"));
        String checkinStr=SearchRoomForm.getExpectedCheckin().getText();
        String checkoutStr=SearchRoomForm.getExpectedCheckout().getText();
        checkInDate=new JLabel("Check In: "+checkinStr);
        checkOutDate=new JLabel("Check Out: "+checkoutStr);
        firstNameLabel=new JLabel("First Name:  ");
        lastNameLabel = new JLabel("Last Name:  ");
        emailLabel = new JLabel("Email:  ");
        streetLabel = new JLabel("Street Address:  ");
        cityLabel = new JLabel("City:  ");
        countryLabel= new JLabel("Country:  ");
        zipLabel = new JLabel("Zipcode:  ");
        editReservation=new JButton("Edit");
        firstNameField=new JTextField(10);
        lastNameField=new JTextField(10);
        emailField =new JTextField(16);
        streetField=new JTextField(20);
        cityField=new JTextField(10);
        countryField=new JTextField(5);
        zipField=new JTextField(6);

        firstNameField.setText(g.getFirstName());
        lastNameField.setText(g.getLastName());
        emailField.setText(g.getEmail());
        streetField.setText(g.getStreet());
        cityField.setText(g.getCity());
        countryField.setText(g.getCountry());
        zipField.setText(g.getZip());

        setFieldEditableTrue();

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
        add(editReservation,gc);

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

        //7th row
        commitReservationButton=new JButton("Commit Reservation");
        gc.weightx=1;
        gc.weighty=1;
        gc.gridx=1;
        gc.gridy=6;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(commitReservationButton,gc);

        editReservation.addActionListener(e -> {
            setFieldEditableTrue();
            editReservation.setVisible(false);
            commitReservationButton.setVisible(true);
        });
        commitReservationButton.addActionListener(e1 -> {
            g.setFirstName(firstNameField.getText());
            g.setLastName(lastNameField.getText());
            g.setEmail(emailField.getText());
            g.setStreet(streetField.getText());
            g.setCity(cityField.getText());
            g.setCountry(countryField.getText());
            g.setZip(zipField.getText());
            setFieldsEditableFalse();
            commitReservationButton.setVisible(false);
            editReservation.setVisible(true);
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

    }
    private void setFieldEditableTrue(){
        firstNameField.setEditable(true);
        lastNameField.setEditable(true);
        emailField.setEditable(true);
        streetField.setEditable(true);
        cityField.setEditable(true);
        countryField.setEditable(true);
        zipField.setEditable(true);
    }
}
