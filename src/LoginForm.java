import javax.swing.*;
import java.awt.*;

public abstract class LoginForm extends JPanel {
    private TextField username;
    private TextField password;
    private JButton submit;

    protected LoginForm() {
        username= new TextField();
        password=new TextField();
        submit = new JButton();
        Dimension dim=getPreferredSize();
        dim.width=400;
        setPreferredSize(dim);
        setBorder(BorderFactory.createTitledBorder("Guest Login"));
    }
}
