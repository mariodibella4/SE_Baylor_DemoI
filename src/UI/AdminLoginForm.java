package UI;

import javax.swing.*;
import java.awt.*;

public class AdminLoginForm extends JPanel {
    private JButton trial;
    public AdminLoginForm(){
        trial=new JButton("trial");
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(trial);
    }
}
