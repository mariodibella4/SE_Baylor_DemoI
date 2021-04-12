package UI;

import javax.swing.*;
import java.awt.*;
import app.*;
import app.handlers.ReservationFormHandler;

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

    public JLabel getNumberOfGuests() {
        return numberOfGuests;
    }

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

    public String getCheckinStr() {
        return checkinStr;
    }

    public String getCheckoutStr() {
        return checkoutStr;
    }

    public Room[] getRooms() {
        return rooms;
    }

    private Room[] rooms;
    private String checkoutStr;
    public ReservationForm(Guest g,Room[]rooms){
        Dimension dim=getPreferredSize();
        setPreferredSize(dim);
        setBorder(BorderFactory.createTitledBorder("app.Reservation"));
        this.rooms=rooms;
        this.checkinStr=SearchRoomForm.getExpectedCheckin().getText();
        this.checkoutStr=SearchRoomForm.getExpectedCheckout().getText();
        this.billing=new JLabel("Billing Info:");
        this.numberOfGuests=new JLabel(String.valueOf(SearchRoomForm.getNumberOfGuestsList().getSelectedIndex()));
        this.creditCardLabel=new JLabel("Please Enter Credit Card:");
        this.creditExpLabel=new JLabel("Exp. Date XX/XX");
        this.creditCRVLabel=new JLabel("CRV:");
        this.checkInDate=new JLabel("Check In: "+checkinStr);//add
        this.checkOutDate=new JLabel("Check Out: "+checkoutStr);//add
        this.firstNameLabel=new JLabel("First Name:  ");
        this.lastNameLabel = new JLabel("Last Name:  ");
        this.emailLabel = new JLabel("Email:  ");
        this.streetLabel = new JLabel("Street Address:  ");
        this.cityLabel = new JLabel("City:  ");
        this.countryLabel= new JLabel("Country:  ");
        this.zipLabel = new JLabel("Zipcode:  ");
        this.editReservation=new JButton("Edit");
        this.firstNameField=new JTextField(10);
        this.lastNameField=new JTextField(10);
        this.emailField =new JTextField(16);
        this.streetField=new JTextField(20);
        this.cityField=new JTextField(10);
        this.countryField=new JTextField(5);
        this.zipField=new JTextField(6);
        this.creditCardField=new JTextField(16);
        this.creditExpField=new JTextField(5);
        this.creditCRVField=new JTextField(4);
        this.firstNameField.setText(g.getFirstName());
        this.lastNameField.setText(g.getLastName());
        this.emailField.setText(g.getEmail());
        this.streetField.setText(g.getStreet());
        this.cityField.setText(g.getCity());
        this.countryField.setText(g.getCountry());
        this.zipField.setText(g.getZip());


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
        commitReservationButton=new JButton("Commit app.Reservation");
        gc.weightx=1;
        gc.weighty=1;
        gc.gridx=1;
        gc.gridy=9;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(commitReservationButton,gc);

        new ReservationFormHandler(this);
/*
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
        });*/
    }

}
