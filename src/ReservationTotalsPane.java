import javax.swing.*;
import java.awt.*;

public class ReservationTotalsPane extends JPanel {

    ReservationTotalsPane(){
        Dimension dim=getPreferredSize();
        setPreferredSize(dim);
        setBorder(BorderFactory.createTitledBorder("Stay Total"));
    }
}
