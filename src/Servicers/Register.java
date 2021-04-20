package Servicers;

import UI.*;
import app.Guest;

import javax.swing.*;

public class Register {
    private static GuestRegistrationForm guestRegTemp=new GuestRegistrationForm();

    public static void Register(JPanel form){

        String input=form.getClass().toString();
        String guest=guestRegTemp.getClass().toString();

        if(input.equals(guest)){
            addNewGuest((GuestRegistrationForm)form);
        }
    }
    private static void addNewGuest(GuestRegistrationForm guestRegistrationForm){
        Guest.getRegisteredGuests().add(new
                Guest(1,guestRegistrationForm.getFirstNameField().getText(),
                guestRegistrationForm.getLastNameField().getText(),
                guestRegistrationForm.getEmailField().getText(),
                guestRegistrationForm.getStreetField().getText(),
                guestRegistrationForm.getCityField().getText(),
                guestRegistrationForm.getCountryField().getText(),
                guestRegistrationForm.getZipField().getText(),
                guestRegistrationForm.getPasswordField().getPassword()));

    }
}
