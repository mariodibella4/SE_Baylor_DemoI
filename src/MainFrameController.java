import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//current bugs each action produces a new JFrame I'm sure this is an architecture issue
public class MainFrameController extends JFrame {
    public final String HOME_PAGE = "home page";
    public final String GUEST_REG_PAGE = "guest reg page";
    public final String GUEST_LOGIN_PAGE = "guest login page";
    private GuestLoginForm guestLoginForm;
    private GuestRegistrationForm guestRegistrationForm;
    private final CardLayout cardLayout;
    private JPanel mainPane;
    public MainFrameController(){
        super("Demo I");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //above sets the stage below is an example how to manifest the form with in the original frame.
        //technically its not a Form but a JPanel
         mainPane = new JPanel();
        mainPane.setPreferredSize(new Dimension(500,500));
        cardLayout=new CardLayout();
        mainPane.setLayout(cardLayout);
        guestRegistrationForm =new GuestRegistrationForm();
        guestLoginForm =new GuestLoginForm();
        mainPane.add(HOME_PAGE,new JPanel());
        mainPane.add(GUEST_REG_PAGE,guestRegistrationForm);
        mainPane.add(GUEST_LOGIN_PAGE,guestLoginForm);

        mainPane.setVisible(true);
        setLayout(new BorderLayout());
        add(mainPane,BorderLayout.CENTER);
        //pack();
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
        guestReg.addActionListener(e ->cardLayout.show(mainPane,GUEST_REG_PAGE));
        guestLogin.addActionListener(e -> cardLayout.show(mainPane,GUEST_LOGIN_PAGE));




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
