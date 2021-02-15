import javax.swing.*;
import java.awt.*;

public class GuestLoginForm extends JPanel{
    private JButton heyButton;
    private JPanel panel1;
    public GuestLoginForm() {
        Dimension dim=getPreferredSize();
        dim.width=400;
        setPreferredSize(dim);
        setBorder(BorderFactory.createTitledBorder("Guest Login"));
    }
}
