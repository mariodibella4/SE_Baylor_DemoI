import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;

public class BrowseAvailableRoomsPanel extends JPanel {
    public static JTable getTable() {
        return table;
    }

    private static JTable table;

    public JScrollPane getTablePane() {
        return tablePane;
    }

    private JScrollPane tablePane;

    public JButton getMakeRes() {
        return makeRes;
    }

    private JButton makeRes;
    private JComboBox<Integer> numberOfRooms;
    public BrowseAvailableRoomsPanel(){
        Dimension dim=getPreferredSize();
        //dim.width=300;
        setPreferredSize(dim);
        setBorder(BorderFactory.createTitledBorder("Rooms Available"));
        numberOfRooms=new JComboBox<>();
        for(Integer i=0;i<10;i++)//fix with get available rooms
            numberOfRooms.addItem(i);
        numberOfRooms.setEditable(true);
        numberOfRooms.setVisible(true);
        numberOfRooms.setSelectedIndex(0);
        Object[][] rec = {
                {0,"King Bed", "Level: 5", "3 room Suite With gorgeous views and a butler","$1099" },
                {0,"King Bed", "Level: 4", "Studio With gorgeous views and luxury pullout couch","$799" },
                {0,"King Bed", "Level: 3", "Studio With gorgeous views","$599" },
                {0,"King Bed", "Level: Standard", "With gorgeous views","$699" },
                {0,"Two Queen Beds", "Level: Standard", "Studio With gorgeous views and Playstation","$699" },
                {0,"Two Queen Beds", "Level: Standard", "Studio With gorgeous views and Playstation","$699" },
        };
        String[] header = { "Select Quantity","Type", "Quality", "Description","Current Rate/night*" };
        makeRes=new JButton("Make Reservation");
        makeRes.setVisible(false);
        table = new JTable(rec,header);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(false);
        table.setGridColor(Color.blue);
        table.setRowSelectionAllowed(true);
        table.setVisible(false);
        table.getTableHeader().setVisible(false);
        table.setRowHeight(20);
        table.getColumnModel().getColumn(3).setPreferredWidth(250);
        table.setMinimumSize(new Dimension(800,400));


        TableColumn comboBoxColumn = table.getColumnModel().getColumn(0);
        DefaultCellEditor defaultCellEditor=new DefaultCellEditor(numberOfRooms);
        comboBoxColumn.setCellEditor(defaultCellEditor);
        comboBoxColumn.setCellRenderer(new CheckBoxCellRenderer(numberOfRooms));
        table.repaint();


        tablePane=new JScrollPane(table);
        tablePane.setSize(800,500);
        tablePane.setPreferredSize(new Dimension(800,400));
        tablePane.setVisible(false);
        //tablePane.setSize(new Dimension(800,500));
        add(tablePane);
        add(makeRes);
    }
    class CheckBoxCellRenderer implements TableCellRenderer {
        JComboBox combo;
        public CheckBoxCellRenderer(JComboBox comboBox) {
            this.combo = new JComboBox();
            for (int i=0; i<comboBox.getItemCount(); i++){
                combo.addItem(comboBox.getItemAt(i));
            }
        }
        public Component getTableCellRendererComponent(JTable jtable,
                                                       Object value,
                                                       boolean isSelected,
                                                       boolean hasFocus,
                                                       int row, int column) {
             combo.setSelectedItem(value);
             if((Integer) value!=0)
                makeRes.setVisible(true);
            return combo;
        }
    }
}
