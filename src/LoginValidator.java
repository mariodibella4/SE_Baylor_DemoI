import javax.swing.*;

public class LoginValidator {
    static GuestLoginForm guestTemp=new GuestLoginForm();
    static AdminLoginForm adminTemp=new AdminLoginForm();
    static ClerkLoginForm clerkTemp = new ClerkLoginForm();

    public  static Object loginValidator(JPanel form){

        String input=form.getClass().toString();
        String guest=guestTemp.getClass().toString();

        if(input.equals(guest)){
            return guestLoginValidator(form);
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
}
