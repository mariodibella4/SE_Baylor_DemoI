import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrameController extends JFrame {
    private Toolbar toolbar ;
    private GuestLoginForm guestLoginForm;
    public MainFrameController(){
        super("Demo I");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //above sets the stage below is an example how to manifest the form with in the original frame.
        //technically its not a Form but a JPanel 
        guestLoginForm =new GuestLoginForm();
        guestLoginForm.setVisible(false);
        add(guestLoginForm);

        setJMenuBar(createMenuBar());


    }
    private JMenuBar createMenuBar(){
        JMenuBar menuBar = new JMenuBar();


        JMenu guestMenu=new JMenu("Guest");
        JMenuItem guestLogin = new JMenuItem("Login");
        JMenuItem guestReg = new JMenuItem("Register");
        guestMenu.add(guestLogin);
        guestMenu.addSeparator();
        guestMenu.add(guestReg);
        guestLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               JMenuItem item =(JMenuItem)e.getSource();
                guestLoginForm.setVisible(true);
            }
        });


        JMenu adminMenu=new JMenu("Admin");
        JMenuItem adminLogin = new JMenuItem("Login");
        adminMenu.add(adminLogin);

        JMenu clerkMenu=new JMenu("Clerk");
        JMenuItem clerkLogin = new JMenuItem("Login");
        clerkMenu.add(clerkLogin);

        menuBar.add(clerkMenu);
        menuBar.add(guestMenu);
        menuBar.add(adminMenu);
        return menuBar;
    }
}
