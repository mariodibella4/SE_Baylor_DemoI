package UI;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import Servicers.*;
import app.handlers.SearchRoomFormHandler;

public class SearchRoomForm extends JPanel {
    public JButton getSubmitButton() {
        return submitButton;
    }

    private JButton submitButton;

    public JButton getCheckinCal() {
        return checkinCal;
    }

    public JButton getCheckoutCal() {
        return checkoutCal;
    }

    private  JButton checkinCal;
    private  JButton checkoutCal;

    public static JTextField getExpectedCheckin() {
        return expectedCheckin;
    }

    public static JTextField getExpectedCheckout() {
        return expectedCheckout;
    }

    public static void setExpectedCheckin(JTextField expectedCheckin) {
        SearchRoomForm.expectedCheckin = expectedCheckin;
    }

    public static void setExpectedCheckout(JTextField expectedCheckout) {
        SearchRoomForm.expectedCheckout = expectedCheckout;
    }

    private static JTextField expectedCheckin;
    private static JTextField expectedCheckout;
    private JLabel checkIn;
    private JLabel checkOut;

    public JFrame getCalPopup() {
        return calPopup;
    }

    private JFrame calPopup;

    public JLabel getAstrisk() {
        return astrisk;
    }


    private JLabel astrisk;
    private JLabel numberOfGuests;

    public static JComboBox<Integer> getNumberOfGuestsList() {
        return numberOfGuestsList;
    }

    private static JComboBox<Integer> numberOfGuestsList;
    private JCheckBox checkBoxKing;
    private JCheckBox checkBoxTwoQueens;
    private JCheckBox corporateGuest;
    public SearchRoomForm(){
        Dimension dim=getPreferredSize();
        dim.width=300;
        setPreferredSize(dim);
        setBorder(BorderFactory.createTitledBorder("Search Available Rooms"));

        submitButton =new JButton("Search");
        checkinCal=new JButton("Cal");
       // checkinCal.setPreferredSize(new Dimension(50,20));
        checkoutCal=new JButton("Cal");
       // checkoutCal.setPreferredSize(new Dimension(50,20));
        expectedCheckin=new JTextField(6);
        expectedCheckout=new JTextField(6);
        checkIn=new JLabel("Check in:");
        checkOut=new JLabel("Check out:");
        numberOfGuests=new JLabel("Number of Guests:");
        Integer[] list=new Integer[]{1,2,3,4,5,6,7};
        numberOfGuestsList=new JComboBox(list);
        checkBoxKing=new JCheckBox("King Size Bed");
        checkBoxTwoQueens=new JCheckBox("Two Queens");
        corporateGuest=new JCheckBox("Corp Acct");
        astrisk=new JLabel("*excludes taxes and fees");
        calPopup=new JFrame();

        setLayout(new GridBagLayout());

        GridBagConstraints gc=new GridBagConstraints();
        gc.fill=GridBagConstraints.RELATIVE;
        //First ROW
        gc.weightx=.1;
        gc.weighty=.1;
        gc.gridx=0;
        gc.gridy=0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(checkIn,gc);

        gc.gridx=1;
        gc.gridy=0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(expectedCheckin,gc);
        gc.gridx=2;
        gc.gridy=0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(checkinCal,gc);
        //Second Row
        gc.weightx=.1;
        gc.weighty=.1;
        gc.gridx=0;
        gc.gridy=1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(checkOut,gc);

        gc.gridx=1;
        gc.gridy=1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(expectedCheckout,gc);
        gc.gridx=2;
        gc.gridy=1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(checkoutCal,gc);
        checkoutCal.setVisible(false);
        //Third Row
        gc.weightx=1;
        gc.weighty=.1;
        gc.gridx=0;
        gc.gridy=2;
        gc.anchor = GridBagConstraints.LINE_START;
        add(numberOfGuests,gc);

        gc.gridx=1;
        gc.gridy=2;
        gc.anchor = GridBagConstraints.LINE_START;
        add(numberOfGuestsList,gc);
        //Fourth Row

        gc.weightx=1;
        gc.weighty=.1;
        gc.gridx=0;
        gc.gridy=3;
        gc.anchor = GridBagConstraints.LINE_START;
        add(checkBoxKing,gc);

        gc.gridx=0;
        gc.gridy=4;
        gc.anchor = GridBagConstraints.LINE_START;
        add(checkBoxTwoQueens,gc);

        gc.gridx=0;
        gc.gridy=5;
        gc.anchor = GridBagConstraints.LINE_START;
        add(corporateGuest,gc);

        //Sixth Row
        gc.weightx=1;
        gc.weighty=.11;
        gc.gridx=0;
        gc.gridy=7;
        gc.anchor = GridBagConstraints.LINE_START;
        add(submitButton,gc);

        gc.weightx=1;
        gc.weighty=.11;
        gc.gridx=0;
        gc.gridy=8;
        gc.anchor = GridBagConstraints.LINE_START;
        add(astrisk,gc);
        astrisk.setVisible(false);

        new SearchRoomFormHandler(this);

    }
}
