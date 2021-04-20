package Servicers;

import UI.AdminLoginForm;
import UI.ClerkLoginForm;

import javax.swing.*;
import UI.*;
import app.*;
public class LoginValidator {
    private static GuestLoginForm guestTemp=new GuestLoginForm();
    private static AdminLoginForm adminTemp=new AdminLoginForm();
    private static ClerkLoginForm clerkTemp = new ClerkLoginForm();

    public  static Object loginValidator(JPanel form){

        String input=form.getClass().toString();
        String guest=guestTemp.getClass().toString();
        String admin=adminTemp.getClass().toString();
        String clerk=clerkTemp.getClass().toString();

        if(input.equals(guest)){
            return guestLoginValidator(form);
        }

        else if(input.equals(admin)){
            return adminLoginValidator(form);
        }

        else if(input.equals(clerk)){
          //  return clerkLoginValidator(form);
        }

       return null;
    }
    public static Guest guestLoginValidator(JPanel form){

        GuestLoginForm guestLoginForm=(GuestLoginForm)form;
        String emailAttempt = guestLoginForm.getEmailField().getText();
        char[] passwordAttempt=guestLoginForm.getPasswordField().getPassword();
        String passwordInput=new String(passwordAttempt);
        for(Guest g : Guest.getRegisteredGuests()) {
            String passwordGotten = new String(g.getPassword());
            if (passwordInput.equals(passwordGotten) && emailAttempt.equals(g.getEmail()))
                return g;
        }
        return null;
    }

    public static Admin adminLoginValidator(JPanel form) {
        AdminLoginForm adminLoginForm = (AdminLoginForm)form;
        char[] passwordAttempt = adminLoginForm.getPasswordField().getPassword();
        String passwordInput = new String(passwordAttempt);

        for(Admin a : Admin.getRegisteredAdmins()) {
            String passwordGotten = new String(a.getPassword());
            if(passwordInput.equals(passwordGotten))
                return a;
        }

        return null;
    }
}
