import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class BrowseAvailableRoomsPanel extends JPanel {
    public JTable getTable() {
        return table;
    }

    private JTable table;

    public JScrollPane getTablePane() {
        return tablePane;
    }

    private JScrollPane tablePane;

    public JButton getMakeRes() {
        return makeRes;
    }

    private JButton makeRes;
    public BrowseAvailableRoomsPanel(){
        Dimension dim=getPreferredSize();
        //dim.width=300;
        setPreferredSize(dim);
        setBorder(BorderFactory.createTitledBorder("Rooms Available"));
        String[][] rec = {
                { "King Bed", "Level: 5", "3 room Suite With gorgeous views and a butler","$1099" },
                { "King Bed", "Level: 4", "Studio With gorgeous views and luxury pullout couch","$799" },
                { "King Bed", "Level: 3", "Studio With gorgeous views","$599" },
                { "King Bed", "Level: Standard", "With gorgeous views","$699" },
                { "Two Queen Beds", "Level: Standard", "Studio With gorgeous views and Playstation","$699" },
                { "Two Queen Beds", "Level: Standard", "Studio With gorgeous views and Playstation","$699" },
        };
        String[] header = { "Type", "Quality", "Description","Current Rate/night*" };
        makeRes=new JButton("Make Reservation");
        makeRes.setVisible(false);
        table = new JTable(rec, header);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(false);
        table.setGridColor(Color.blue);
        table.setRowSelectionAllowed(true);
        table.setVisible(false);
        table.getTableHeader().setVisible(false);
        table.setRowHeight(20);
        table.getColumnModel().getColumn(2).setPreferredWidth(250);
        table.setMinimumSize(new Dimension(800,400));

        table.getSelectionModel().addListSelectionListener(e -> {
            makeRes.setVisible(true);
        });
        tablePane=new JScrollPane(table);
        tablePane.setSize(800,500);
        tablePane.setPreferredSize(new Dimension(800,400));
        tablePane.setVisible(false);
        //tablePane.setSize(new Dimension(800,500));
        add(tablePane);
        add(makeRes);
    }
}
