import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class GuestLoginForm extends JPanel{
    public JButton getSubmitButton() {
        return submitButton;
    }

    private JButton submitButton;
    private JLabel passwordLabel;
    private JLabel emailLabel;

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    private JPasswordField passwordField;
    private JTextField emailField;

    public boolean isSuccessfulLogin() {
        return successfulLogin;
    }

    public void setSuccessfulLogin(boolean successfulLogin) {
        this.successfulLogin = successfulLogin;
    }

    private boolean successfulLogin;
    public GuestLoginForm() {
        Dimension dim=getPreferredSize();
        dim.width=400;
        setPreferredSize(dim);
        setBorder(BorderFactory.createTitledBorder("Guest Login"));

        passwordField= new JPasswordField(10);
        emailField = new JTextField(10);
        submitButton = new JButton("Submit");
        emailLabel =new JLabel("Email: ");
        passwordLabel=new JLabel("Password: ");

        setLayout(new GridBagLayout());

        GridBagConstraints gc=new GridBagConstraints();
        //First ROW
        gc.weightx=1;
        gc.weighty=.1;
        gc.gridx=0;
        gc.gridy=0;
        gc.fill=GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        add(emailLabel,gc);

        gc.gridx=1;
        gc.gridy=0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(emailField,gc);
        //Second Row
        gc.weightx=1;
        gc.weighty=.1;
        gc.gridx=0;
        gc.gridy=1;
        gc.anchor = GridBagConstraints.LINE_END;
        add(passwordLabel,gc);

        gc.gridx=1;
        gc.gridy=1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(passwordField,gc);
        //Third Row
        gc.weightx=1;
        gc.weighty=1;
        gc.gridx=1;
        gc.gridy=2;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(submitButton,gc);



    }
}
