package app.handlers;

import Servicers.CreditCardValidator;
import UI.ReservationForm;
import app.Reservation;

public class ReservationFormHandler {
public ReservationFormHandler(ReservationForm reservationForm){
    reservationForm.getEditReservation().addActionListener(e -> {
        setFieldEditableTrue(reservationForm);
        reservationForm.getEditReservation().setVisible(false);
        reservationForm.getCommitReservationButton().setVisible(true);
    });
    reservationForm.getCommitReservationButton().addActionListener(e1 -> {

        Reservation reservation= new Reservation(100001,reservationForm.getCheckinStr(),reservationForm.getCheckoutStr(),reservationForm.getFirstNameField().getText(),
                reservationForm.getLastNameField().getText(),Integer.valueOf(reservationForm.getNumberOfGuests().getText()),
                reservationForm.getRooms(),
                reservationForm.getCreditCardField().getText(),reservationForm.getCreditExpField().getText(),
                Integer.valueOf(reservationForm.getCreditCRVField().getText()));//CreditCardServicer
        Reservation.getReservations().add(reservation);
        setFieldsEditableFalse(reservationForm);
        reservationForm.getCommitReservationButton().setVisible(false);
        reservationForm.getEditReservation().setVisible(true);
    });
    new CreditCardValidator();
}
    private void setFieldsEditableFalse(ReservationForm reservationForm){
        reservationForm.getFirstNameField().setEditable(false);
        reservationForm.getLastNameField().setEditable(false);
        reservationForm.getEmailField().setEditable(false);
        reservationForm.getStreetField().setEditable(false);
        reservationForm.getCityField().setEditable(false);
        reservationForm.getCountryField().setEditable(false);
        reservationForm.getZipField().setEditable(false);
        reservationForm.getCreditCRVField().setEditable(false);
        reservationForm.getCreditExpField().setEditable(false);
        reservationForm.getCreditCardField().setEditable(false);

    }
    private void setFieldEditableTrue(ReservationForm reservationForm){
        reservationForm.getFirstNameField().setEditable(true);
        reservationForm.getLastNameField().setEditable(true);
        reservationForm.getEmailField().setEditable(true);
        reservationForm.getStreetField().setEditable(true);
        reservationForm.getCityField().setEditable(true);
        reservationForm.getCountryField().setEditable(true);
        reservationForm.getZipField().setEditable(true);
        reservationForm.getCreditCRVField().setEditable(true);
        reservationForm.getCreditExpField().setEditable(true);
        reservationForm.getCreditCardField().setEditable(true);
    }
}
