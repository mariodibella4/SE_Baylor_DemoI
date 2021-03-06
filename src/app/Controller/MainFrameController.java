package app.Controller;

import Servicers.LoginValidator;
import Servicers.ReservationTotalsCalculator;
import Servicers.RoomModel;
import UI.*;
import Servicers.Register;
import UI.splitpanes.ReservationFormAndTotalsSplitPane;
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
    public final String GUEST_PROFILE_PAGE = "guest profile page";
    public final String GUEST_SEARCH_PAGE = "guest search page";
    public final String GUEST_RESERVATION_PAGE = "guest reservation page";
    private GuestProfilePage guestProfilePage;
    private GuestLoginForm guestLoginForm;
    private GuestRegistrationForm guestRegistrationForm;
    private SearchRoomForm searchRoomForm;
    private BrowseAvailableRoomsPanel browseAvailableRoomsPanel;
    private JSplitPane searchRoomAndBrowse;
    private JSplitPane reservationFormAndTotals;

    public static JTabbedPane getResverationsTabbed() {
        return resverationsTabbed;
    }

    private static JTabbedPane resverationsTabbed= new JTabbedPane();
    private ReservationTotalsPane reservationTotalsPane;
    private boolean guestLoginBool=false;
    private boolean guestReservationBool=false;
    private final CardLayout cardLayout;
    private JPanel mainPane;
    private Guest guest;
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

        searchRoomAndBrowse= SearchRoomAndBrowseSplitPaneHandler.searchRoomAndBrowseSplitPane(searchRoomForm,browseAvailableRoomsPanel);


        mainPane.add(HOME_PAGE,new JPanel());
        mainPane.add(GUEST_REG_PAGE,guestRegistrationForm);
        mainPane.add(GUEST_LOGIN_PAGE,guestLoginForm);
        mainPane.add(GUEST_SEARCH_PAGE,searchRoomAndBrowse);
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
        JMenuItem guestLogin = new JMenuItem("Login");
        JMenuItem guestReg = new JMenuItem("Servicers.Register");
        JMenuItem guestProfile=new JMenuItem("Profile");
        JMenuItem guestLogout=new JMenuItem("Logout");
        JMenuItem searchPage=new JMenuItem("Search Available Rooms");
        JMenuItem reservationPage=new JMenuItem("Reservations");

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
        }else{
            guestMenu.add(guestLogin);
            guestMenu.addSeparator();
            guestMenu.add(guestReg);
            guestReg.addActionListener(e ->cardLayout.show(mainPane,GUEST_REG_PAGE));
            guestLogin.addActionListener(e -> cardLayout.show(mainPane,GUEST_LOGIN_PAGE));
        }

        JMenu adminMenu=new JMenu("Admin");
        JMenuItem adminLogin = new JMenuItem("Login");
        adminMenu.add(adminLogin);

        JMenu clerkMenu=new JMenu("app.Clerk");
        JMenuItem clerkLogin = new JMenuItem("Login");
        clerkMenu.add(clerkLogin);

        menuBar.add(clerkMenu);
        menuBar.add(guestMenu);
        menuBar.add(adminMenu);
        return menuBar;
    }
}
