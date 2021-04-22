package app.Controller;

import Servicers.LoginValidator;
import Servicers.ReservationTotalsCalculator;
import Servicers.RoomModel;
import UI.*;
import Servicers.Register;
import UI.splitpanes.ReservationFormAndTotalsSplitPane;
//import UI.splitpanes.SearchRoomAndBrowseSplitPane;
import app.Admin;
import app.Clerk;
import app.handlers.SearchRoomAndBrowseSplitPaneHandler;
import app.Guest;
import app.Room;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;

//current bugs each action produces a new JFrame I'm sure this is an architecture issue
public class MainFrameController extends JFrame {
    public final String HOME_PAGE = "home page";

    public final String GUEST_REG_PAGE = "guest reg page";
    public final String GUEST_LOGIN_PAGE = "guest login page";
    public final String CLERK_LOGIN_PAGE = "clerk login page";
    public final String GUEST_PROFILE_PAGE = "guest profile page";
    public final String CLERK_PROFILE_PAGE = "clerk profile page";
    public final String ADMIN_PROFILE_PAGE = "admin profile page";
    public final String GUEST_SEARCH_PAGE = "guest search page";
    public final String GUEST_RESERVATION_PAGE = "guest reservation page";
    public final String ADMIN_LOGIN_PAGE = "admin login page";
    public final String ADMIN_REGISTER_CLERK_FORM = "manage clerks page";
    private GuestProfilePage guestProfilePage;
    private ClerkProfilePage clerkProfilePage;
    private GuestLoginForm guestLoginForm;
    private ClerkLoginForm clerkLoginForm;
    private GuestRegistrationForm guestRegistrationForm;
    private SearchRoomForm searchRoomForm;
    private AdminLoginForm adminLoginForm;
    private AdminProfilePage adminProfilePage;
    private AdminRegisterClerkForm adminRegisterClerkForm;
    private BrowseAvailableRoomsPanel browseAvailableRoomsPanel;
    private JSplitPane searchRoomAndBrowse;
    private JSplitPane reservationFormAndTotals;

    public static JTabbedPane getResverationsTabbed() {
        return resverationsTabbed;
    }

    private static JTabbedPane resverationsTabbed= new JTabbedPane();
    private ReservationTotalsPane reservationTotalsPane;
    private boolean guestLoginBool=false;
    private boolean adminLoginBool = false;
    private boolean clerkLoginBool = false;
    private boolean guestReservationBool=false;
    private final CardLayout cardLayout;
    private JPanel mainPane;
    private Guest guest;
    private Admin admin;
    private Clerk clerk;

    public MainFrameController(){
        super("Demo I");
        setSize(1200,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //above sets the stage below is an example how to manifest the form with in the original frame.
        //technically its not a Form but a JPanel
        mainPane = new JPanel();
        mainPane.setPreferredSize(new Dimension(800,500));
        cardLayout=new CardLayout();
        mainPane.setLayout(cardLayout);

        guestRegistrationForm =new GuestRegistrationForm();
        guestLoginForm =new GuestLoginForm();
        searchRoomForm=new SearchRoomForm();
        browseAvailableRoomsPanel=new BrowseAvailableRoomsPanel();
        adminLoginForm = new AdminLoginForm();
        adminRegisterClerkForm = new AdminRegisterClerkForm();
        clerkLoginForm = new ClerkLoginForm();

        Admin superAdmin = new Admin();
        Admin.addRegisteredAdmin(superAdmin);

        searchRoomAndBrowse= SearchRoomAndBrowseSplitPaneHandler.searchRoomAndBrowseSplitPane(searchRoomForm,browseAvailableRoomsPanel);

        mainPane.add(HOME_PAGE,new JPanel());
        mainPane.add(GUEST_REG_PAGE,guestRegistrationForm);
        mainPane.add(GUEST_LOGIN_PAGE,guestLoginForm);
        mainPane.add(GUEST_SEARCH_PAGE,searchRoomAndBrowse);
        mainPane.add(ADMIN_LOGIN_PAGE, adminLoginForm);
        mainPane.add(ADMIN_REGISTER_CLERK_FORM, adminRegisterClerkForm);
        mainPane.add(CLERK_LOGIN_PAGE, clerkLoginForm);

//Guest Controller eventually will be a facade of controllers
        guestLoginForm.getSubmitButton().addActionListener(e ->{

                    guest = (Guest) LoginValidator.loginValidator(guestLoginForm);
                    try{
                    if(guest.getPassword()!=null){
                        //clean it up
                        guestProfilePage= new GuestProfilePage(guest);
                        mainPane.add(GUEST_PROFILE_PAGE,guestProfilePage);
                        guestLoginBool=true;
                        cardLayout.show(mainPane,GUEST_PROFILE_PAGE);
                        guestProfilePage.getLogout().addActionListener(ev ->
                        {cardLayout.show(mainPane,HOME_PAGE);});
                        setJMenuBar(createMenuBar());
                    }
                    }catch (NullPointerException e1){
                        System.out.println("Remember to register!");
                    }
            });
        guestRegistrationForm.getSubmitButton().addActionListener(e ->  {
                    Register.Register(guestRegistrationForm);
                    cardLayout.show(mainPane,GUEST_LOGIN_PAGE);
                }
        );
        makeReservation(browseAvailableRoomsPanel);

        // Admin Login Verification
        adminLoginForm.getSubmitButton().addActionListener(e ->{
            admin = (Admin) LoginValidator.loginValidator(adminLoginForm);
            try {
                if (admin.getPassword() != null) {

                    adminProfilePage = new AdminProfilePage(admin);
                    mainPane.add(ADMIN_PROFILE_PAGE, adminProfilePage);
                    adminLoginBool = true;
                    cardLayout.show(mainPane, ADMIN_PROFILE_PAGE);

                    adminProfilePage.getLogout().addActionListener(ev ->
                    {
                        cardLayout.show(mainPane, HOME_PAGE);
                    });
                    setJMenuBar(createMenuBar());
                }
            }catch (NullPointerException e1) {
                System.out.println("Incorrect Admin Login Credentials!");
            }
        });

        // Add Clerk Submit Button Handler
        adminRegisterClerkForm.getSubmitButton().addActionListener(e5 ->{
            cardLayout.show(mainPane, ADMIN_PROFILE_PAGE);
        });


        // Clerk Login Validator
        clerkLoginForm.getSubmitButton().addActionListener(e ->{
            clerk = (Clerk) LoginValidator.loginValidator(clerkLoginForm);
            try {
                if(clerk.getPassword() != null){
                    clerkProfilePage = new ClerkProfilePage(clerk);
                    mainPane.add(CLERK_PROFILE_PAGE, clerkProfilePage);
                    clerkLoginBool = true;
                    System.out.println("CLERK LOGGED IN");
                    cardLayout.show(mainPane, CLERK_PROFILE_PAGE);

                    clerkProfilePage.getLogout().addActionListener(ev2 ->{
                        cardLayout.show(mainPane, HOME_PAGE);
                    });
                    setJMenuBar(createMenuBar());
                }
            }catch (NullPointerException e3) {
                System.out.println("Invalid Clerk Credentials!");
            }
        });

        mainPane.setVisible(true);
        setLayout(new BorderLayout());
        add(mainPane,BorderLayout.CENTER);
        setJMenuBar(createMenuBar());

    }

    private void makeReservation(BrowseAvailableRoomsPanel browseAvailableRoomsPanel){
        browseAvailableRoomsPanel.getMakeRes().addActionListener(e -> {
            finishReservation(reservationTotalsPane);
            //refresh
            searchRoomForm.getCheckoutCal().setVisible(false);
            SearchRoomForm.getExpectedCheckin().setText("");
            SearchRoomForm.getExpectedCheckout().setText("");
            searchRoomForm.getCheckBoxKing().setSelected(false);
            searchRoomForm.getCheckBoxTwoQueens().setSelected(false);
            searchRoomForm.getCorporateGuest().setSelected(false);
            browseAvailableRoomsPanel.getTablePane().setVisible(false);
            browseAvailableRoomsPanel.getMakeRes().setVisible(false);
        });
    }

    private void finishReservation(ReservationTotalsPane reservationTotalsPane){
        JTable table=BrowseAvailableRoomsPanel.getTable();
        int rows =table.getRowCount();
        int j=0;
        for(int i=0;i<rows;i++){
            if(table.getModel().getValueAt(i,0).toString()!="0"){
                j+=(int) table.getModel().getValueAt(i,0);
            }
        }
        Room[] rooms=new Room[j];
        int l=0;
        for(int i=0;i<rows;i++){
            if(table.getModel().getValueAt(i,0).toString()!="0"){
                int k=0;
                while(k<(int) table.getModel().getValueAt(i,0)) {
                    rooms[l++] = RoomModel.getAvailableRooms().get(i);
                    k++;
                }
            }
        }
        reservationTotalsPane=new ReservationTotalsPane(new ReservationTotalsCalculator(SearchRoomForm.getExpectedCheckin().getText(),
                SearchRoomForm.getExpectedCheckout().getText(),rooms),rooms);
        reservationFormAndTotals= ReservationFormAndTotalsSplitPane.
                reservationFormAndTotalsSplitPane(new ReservationForm(guest,rooms),reservationTotalsPane);
        resverationsTabbed.add("New Reservation",reservationFormAndTotals);
        mainPane.add(GUEST_RESERVATION_PAGE,resverationsTabbed);
        guestReservationBool=true;
        setJMenuBar(createMenuBar());
        cardLayout.show(mainPane,GUEST_RESERVATION_PAGE);
    }


    private JMenuBar createMenuBar(){
        JMenuBar menuBar = new JMenuBar();

        JMenu guestMenu=new JMenu("Guest");
        JMenu adminMenu = new JMenu("Admin");
        JMenuItem guestLogin = new JMenuItem("Login");
        JMenuItem adminLogin = new JMenuItem("Login");
        JMenuItem guestReg = new JMenuItem("Register");
        JMenuItem guestProfile=new JMenuItem("Profile");
        JMenuItem adminProfile = new JMenuItem("Profile");
        JMenuItem guestLogout=new JMenuItem("Logout");
        JMenuItem adminLogout = new JMenuItem("Logout");
        JMenuItem searchPage=new JMenuItem("Search Available Rooms");
        JMenuItem reservationPage=new JMenuItem("Reservations");
        JMenuItem manageClerks = new JMenuItem("Manage Clerks");
        JMenu clerkMenu = new JMenu("Clerk");
        JMenuItem clerkLogin = new JMenuItem("Login");
        JMenuItem clerkProfile = new JMenuItem("Profile");
        JMenuItem clerkLogout = new JMenuItem("Logout");


        if(guestLoginBool){
            guestMenu.add(guestProfile);
            guestMenu.addSeparator();
            guestMenu.add(searchPage);
            guestMenu.addSeparator();
            guestMenu.add(guestLogout);
            if(guestReservationBool){
                guestMenu.addSeparator();
                guestMenu.add(reservationPage);
                reservationPage.addActionListener(e -> {
                    cardLayout.show(mainPane,GUEST_RESERVATION_PAGE);
                });
            }

            guestProfile.addActionListener(e ->cardLayout.show(mainPane,GUEST_PROFILE_PAGE));
            guestLogout.addActionListener(e -> {
                cardLayout.show(mainPane,HOME_PAGE);
                guestLoginBool=false;
                guestReservationBool=false;
                setJMenuBar(createMenuBar());
            });
            searchPage.addActionListener(e ->{
                cardLayout.show(mainPane,GUEST_SEARCH_PAGE);
            });
        }
        else{
            guestMenu.add(guestLogin);
            guestMenu.addSeparator();
            guestMenu.add(guestReg);
            guestReg.addActionListener(e ->cardLayout.show(mainPane,GUEST_REG_PAGE));
            guestLogin.addActionListener(e -> cardLayout.show(mainPane,GUEST_LOGIN_PAGE));
        }

        if(adminLoginBool){
            adminMenu.add(adminProfile);
            adminMenu.addSeparator();
            adminMenu.add(manageClerks);
            adminMenu.addSeparator();
            adminMenu.add(adminLogout);

            adminProfile.addActionListener(e ->cardLayout.show(mainPane, ADMIN_PROFILE_PAGE));
            manageClerks.addActionListener(e -> cardLayout.show(mainPane, ADMIN_REGISTER_CLERK_FORM));

            adminLogout.addActionListener(e -> {
                cardLayout.show(mainPane, HOME_PAGE);
                adminLoginBool = false;
                setJMenuBar(createMenuBar());
            });
        }
        else{
            adminMenu.add(adminLogin);
            adminMenu.addSeparator();
            adminLogin.addActionListener(e -> cardLayout.show(mainPane,ADMIN_LOGIN_PAGE));
        }

        if(clerkLoginBool) {
            clerkMenu.add(clerkProfile);
            clerkMenu.addSeparator();
            clerkMenu.add(clerkLogout);

            clerkProfile.addActionListener(e -> cardLayout.show(mainPane, CLERK_PROFILE_PAGE));

            clerkLogout.addActionListener(e -> {
                cardLayout.show(mainPane, HOME_PAGE);
                clerkLoginBool = false;
                setJMenuBar(createMenuBar());
            });
        }
        else {
            clerkMenu.add(clerkLogin);
            clerkMenu.addSeparator();
            clerkLogin.addActionListener(e -> cardLayout.show(mainPane, CLERK_LOGIN_PAGE));
        }

        menuBar.add(clerkMenu);
        menuBar.add(guestMenu);
        menuBar.add(adminMenu);
        return menuBar;
    }



}
