import UI.AdminLoginForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements ActionListener {
    private JButton guestButton;
    private JButton clerkButton;
    private JButton adminButton;
    public Toolbar(){
        guestButton=new JButton("Guest");
        clerkButton =new JButton("app.Clerk");
        adminButton =new JButton("Admin");

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(guestButton);
        add(clerkButton);
        add(adminButton);

    }
    public  void actionPerformed(ActionEvent e){
        JButton clicked = (JButton)e.getSource();

        if(clicked==adminButton)
            new AdminLoginForm();
    }
}
