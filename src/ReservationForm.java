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
    private JLabel creditCardLabel;
    private JLabel creditExpLabel;
    private JLabel creditCRVLabel;
    private JLabel numberOfGuests;
    private JLabel numberOfRooms;
    private JLabel billing;

    private JTextField creditCardField;

    public JTextField getCreditCardField() {
        return creditCardField;
    }

    public JTextField getCreditExpField() {
        return creditExpField;
    }

    public JTextField getCreditCRVField() {
        return creditCRVField;
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

    private JTextField creditExpField;
    private JTextField creditCRVField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JTextField streetField;
    private JTextField cityField;
    private JTextField countryField;
    private JTextField zipField;

    public JButton getEditReservation() {
        return editReservation;
    }

    public JButton getCommitReservationButton() {
        return commitReservationButton;
    }

    private JButton editReservation;
    private JButton commitReservationButton;
    private JButton changeDatesButton;
    private String checkinStr;
    private String checkoutStr;
    public ReservationForm(Guest g,Room[]rooms){
        Dimension dim=getPreferredSize();
        setPreferredSize(dim);
        setBorder(BorderFactory.createTitledBorder("Reservation"));
        checkinStr=SearchRoomForm.getExpectedCheckin().getText();
         checkoutStr=SearchRoomForm.getExpectedCheckout().getText();
        billing=new JLabel("Billing Info:");
        numberOfGuests=new JLabel(String.valueOf(SearchRoomForm.getNumberOfGuestsList().getSelectedIndex()));
        creditCardLabel=new JLabel("Please Enter Credit Card:");
        creditExpLabel=new JLabel("Exp. Date XX/XX");
        creditCRVLabel=new JLabel("CRV:");
        checkInDate=new JLabel("Check In: "+checkinStr);//add
        checkOutDate=new JLabel("Check Out: "+checkoutStr);//add
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
        creditCardField=new JTextField(16);
        creditExpField=new JTextField(5);
        creditCRVField=new JTextField(4);
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
        gc.anchor = GridBagConstraints.LINE_START;
        add(checkInDate,gc);

        gc.gridx=1;
        gc.gridy=0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(checkOutDate,gc);
        gc.gridx=4;
        gc.gridy=0;
        gc.anchor = GridBagConstraints.EAST;
        add(editReservation,gc);
        editReservation.setVisible(false);
        //2nd Row
        gc.weightx=1;
        gc.weighty=.1;
        gc.gridx=0;
        gc.gridy=1;
        gc.fill=GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_START;
        add(billing,gc);
        gc.gridx=0;
        gc.gridy=2;
        gc.fill=GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_START;
        add(firstNameLabel,gc);

        gc.gridx=1;
        gc.gridy=2;
        gc.anchor = GridBagConstraints.LINE_START;
        add(firstNameField,gc);

        gc.weightx=1;
        gc.weighty=.1;
        gc.gridx=2;
        gc.gridy=2;
        gc.anchor = GridBagConstraints.LINE_START;
        add(lastNameLabel,gc);

        gc.gridx=3;
        gc.gridy=2;
        gc.anchor = GridBagConstraints.LINE_START;
        add(lastNameField,gc);

        //3rd Row
        gc.weightx=1;
        gc.weighty=.1;
        gc.gridx=0;
        gc.gridy=3;
        gc.anchor = GridBagConstraints.LINE_START;
        add(streetLabel,gc);

        gc.gridx=1;
        gc.gridy=3;
        gc.anchor = GridBagConstraints.LINE_START;
        add(streetField,gc);

        //4th Row
        gc.weightx=.1;
        gc.weighty=.1;
        gc.gridx=0;
        gc.gridy=4;
        gc.anchor = GridBagConstraints.LINE_START;
        add(cityLabel,gc);

        gc.gridx=1;
        gc.gridy=4;
        gc.anchor = GridBagConstraints.LINE_START;
        add(cityField,gc);

        gc.gridx=2;
        gc.gridy=4;
        gc.anchor = GridBagConstraints.LINE_START;
        add(countryLabel,gc);

        gc.gridx=3;
        gc.gridy=4;
        gc.anchor = GridBagConstraints.LINE_START;
        add(countryField,gc);

        gc.gridx=4;
        gc.gridy=4;
        gc.anchor = GridBagConstraints.LINE_START;
        add(zipLabel,gc);

        gc.gridx=5;
        gc.gridy=4;
        gc.anchor = GridBagConstraints.LINE_START;
        add(zipField,gc);

        //5th row
        gc.weightx=1;
        gc.weighty=.1;
        gc.gridx=0;
        gc.gridy=5;
        gc.anchor = GridBagConstraints.LINE_START;
        add(emailLabel,gc);

        gc.gridx=1;
        gc.gridy=5;
        gc.anchor = GridBagConstraints.LINE_START;
        add(emailField,gc);
        //6th row
        gc.weightx=1;
        gc.weighty=.1;
        gc.gridx=0;
        gc.gridy=6;
        gc.anchor = GridBagConstraints.LINE_START;
        add(creditCardLabel,gc);

        gc.gridx=1;
        gc.gridy=6;
        gc.anchor = GridBagConstraints.LINE_START;
        add(creditCardField,gc);
        gc.gridx=0;
        gc.gridy=7;
        gc.anchor = GridBagConstraints.LINE_START;
        add(creditExpLabel,gc);
        gc.gridx=1;
        gc.gridy=7;
        gc.anchor = GridBagConstraints.LINE_START;
        add(creditExpField,gc);
        gc.gridx=2;
        gc.gridy=7;
        gc.anchor = GridBagConstraints.LINE_START;
        add(creditCRVLabel,gc);
        gc.gridx=3;
        gc.gridy=7;
        gc.anchor = GridBagConstraints.LINE_START;
        add(creditCRVField,gc);
        //7th row
        commitReservationButton=new JButton("Commit Reservation");
        gc.weightx=1;
        gc.weighty=1;
        gc.gridx=1;
        gc.gridy=9;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(commitReservationButton,gc);

        editReservation.addActionListener(e -> {
            setFieldEditableTrue();
            editReservation.setVisible(false);
            commitReservationButton.setVisible(true);
        });
        commitReservationButton.addActionListener(e1 -> {

            Reservation reservation= new Reservation(100001,checkinStr,checkoutStr,firstNameField.getText(),
                                            lastNameField.getText(),Integer.valueOf(numberOfGuests.toString()),
                                            rooms,
                                            creditCardField.getText(),creditExpField.getText(),
                                            Integer.valueOf(creditCRVField.getText()));
            Reservation.getReservations().add(reservation);
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
        creditCRVField.setEditable(false);
        creditExpField.setEditable(false);
        creditCardField.setEditable(false);

    }
    private void setFieldEditableTrue(){
        firstNameField.setEditable(true);
        lastNameField.setEditable(true);
        emailField.setEditable(true);
        streetField.setEditable(true);
        cityField.setEditable(true);
        countryField.setEditable(true);
        zipField.setEditable(true);
        creditCRVField.setEditable(true);
        creditExpField.setEditable(true);
        creditCardField.setEditable(true);
    }
}
