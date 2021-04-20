package Servicers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WarningWindow {



    private static JFrame frame;

    public static JButton getCancelConfirm() {
        return cancelConfirm;
    }

    private static JButton cancelConfirm;
    public static void createWindow(String message, String title) {
        frame = new JFrame("Hotel De Mario");

        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if(title!="Cancel?")
        JOptionPane.showMessageDialog(frame, message, title, JOptionPane.WARNING_MESSAGE);
        else {
            frame.setSize(300, 100);
           createUI(frame,message,title);
            frame.setVisible(true);
        }
        //createUI(frame, message, title);

        //frame.setSize(560, 200);
        //frame.setLocationRelativeTo(null);

    }

    private static void createUI(final JFrame frame, String message, String title) {
        JPanel panel = new JPanel();
        LayoutManager layout = new FlowLayout();
        panel.setLayout(layout);
        JLabel q=new JLabel("Are You Sure You Want To Cancel?");
        cancelConfirm = new JButton("Yes");
        panel.add(q);
        panel.add(cancelConfirm);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
    }
}
