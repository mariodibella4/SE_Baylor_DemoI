import javax.swing.*;
import java.awt.*;

public class ReservationFormAndTotalsSplitPane {

    public static JSplitPane reservationFormAndTotalsSplitPane(ReservationForm reservationForm,ReservationTotalsPane reservationTotalsPane){
        reservationForm.setSize(new Dimension(800,600));
        JSplitPane splitPane=new JSplitPane(SwingConstants.VERTICAL,reservationForm,reservationTotalsPane);
        splitPane.setOrientation(SwingConstants.VERTICAL);
        reservationTotalsPane.setVisible(true);
        splitPane.setDividerLocation(750);
        return splitPane;
    }
}
