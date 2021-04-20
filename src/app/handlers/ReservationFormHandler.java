package app.handlers;

import Servicers.CreditCardValidator;
import Servicers.WarningWindow;
import UI.ReservationForm;
import app.Controller.MainFrameController;
import app.Reservation;

import javax.swing.*;
import java.util.ArrayList;

public class ReservationFormHandler {
    private Reservation oldReservation;
    private boolean editPressed=false;
    private int increment;
    private int index=0;
public ReservationFormHandler(ReservationForm reservationForm){
    reservationForm.getEditReservation().addActionListener(e -> {
        setFieldEditableTrue(reservationForm);
        reservationForm.getEditReservation().setVisible(false);
        for(Reservation reservation : Reservation.getReservations() ){
            index++;
            if(reservation.getFirstName().equals(reservationForm.getFirstNameField().getText()) &&
                    reservation.getLastName().equals(reservationForm.getLastNameField().getText()) &&
                    reservation.getCheckIn().equals( reservationForm.getCheckinStr()) &&
                    reservation.getCheckOut().equals(reservationForm.getCheckoutStr())){
                         index--;
                         oldReservation=reservation;
                         editPressed=true;
            }
        }

        reservationForm.getCommitReservationButton().setVisible(true);
    });
    reservationForm.getCommitReservationButton().addActionListener(e1 -> {
        if(editPressed){
            Reservation.getReservations().remove(index);
            oldReservation.setCC(reservationForm.getCreditCardField().getText());
            oldReservation.setCRV(Integer.parseInt(reservationForm.getCreditCRVField().getText()));
            oldReservation.setExp(reservationForm.getCreditExpField().getText());
            oldReservation.setFirstName(reservationForm.getFirstNameField().getText());
            oldReservation.setLastName(reservationForm.getLastNameField().getText());
            oldReservation.setEmail(reservationForm.getEmailField().getText());
            oldReservation.setStreetAddr(reservationForm.getStreetField().getText());
            oldReservation.setCity(reservationForm.getCityField().getText());
            oldReservation.setCountry(reservationForm.getCountryField().getText());
            oldReservation.setZipcode(reservationForm.getZipField().getText());
            Reservation.getReservations().add(oldReservation);
            editPressed=false;
            index=0;
            setFieldsEditableFalse(reservationForm);
            reservationForm.getCommitReservationButton().setVisible(false);
            reservationForm.getEditReservation().setVisible(true);
        }else {
            Reservation reservation = new Reservation(reservationForm.getGuestID(),100001+Reservation.getReservations().size(), reservationForm.getCheckinStr(), reservationForm.getCheckoutStr(), reservationForm.getFirstNameField().getText(),
                    reservationForm.getLastNameField().getText(), Integer.valueOf(reservationForm.getNumberOfGuests().getText()),
                    reservationForm.getRooms(),reservationForm.getEmailField().getText(),reservationForm.getStreetField().getText(),
                    reservationForm.getCityField().getText(),reservationForm.getCountryField().getText(),reservationForm.getZipField().getText(),
                    reservationForm.getCreditCardField().getText(), reservationForm.getCreditExpField().getText(),
                    Integer.parseInt(reservationForm.getCreditCRVField().getText()));//CreditCardServicer

            int tracker=0;
            for(Reservation res : Reservation.getReservations() ){
                if(res.getGuestID()==reservationForm.getGuestID()){
                    tracker++;
                }
            }

            Reservation.getReservations().add(reservation);

            MainFrameController.getResverationsTabbed().setTitleAt(tracker,"Reservation ID: "+reservation.getRes_ID());

            setFieldsEditableFalse(reservationForm);
            reservationForm.getCommitReservationButton().setVisible(false);
            reservationForm.getEditReservation().setVisible(true);
            reservationForm.getCancelReservation().setVisible(true);
        }
    });
    reservationForm.getCancelReservation().addActionListener(e -> {
        WarningWindow.createWindow("Are You Sure You Would Like to Cancel?","Cancel?");
        WarningWindow.getCancelConfirm().addActionListener(e1 -> {
            for(Reservation reservation : Reservation.getReservations() ){

                if(reservation.getFirstName().equals(reservationForm.getFirstNameField().getText()) &&
                        reservation.getLastName().equals(reservationForm.getLastNameField().getText()) &&
                        reservation.getCheckIn().equals( reservationForm.getCheckinStr()) &&
                        reservation.getCheckOut().equals(reservationForm.getCheckoutStr())){
                    Reservation.getReservations().remove(reservation);
                    MainFrameController.getResverationsTabbed().remove(MainFrameController.getResverationsTabbed().getSelectedIndex());
                    break;
                }
            }
        });

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
