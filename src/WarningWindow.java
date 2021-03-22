import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WarningWindow {



    public static void createWindow(String message, String title) {
        JFrame frame = new JFrame("Swing Tester");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(frame, message, title, JOptionPane.WARNING_MESSAGE);
        //createUI(frame, message, title);

        //frame.setSize(560, 200);
        //frame.setLocationRelativeTo(null);
        //frame.setVisible(true);
    }

    private static void createUI(final JFrame frame, String message, String title) {
        JPanel panel = new JPanel();
        LayoutManager layout = new FlowLayout();
        panel.setLayout(layout);
        JButton button = new JButton("Click Me!");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, message, title, JOptionPane.WARNING_MESSAGE);
            }
        });

        panel.add(button);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
    }
}
