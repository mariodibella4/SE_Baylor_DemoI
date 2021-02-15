import javax.swing.*;
import java.awt.*;

public class AdminLogin extends JPanel {
    private JButton trial;
    public AdminLogin(){
        trial=new JButton("trial");
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(trial);
    }
}
