import javax.swing.*;
import java.awt.*;

public class SearchRoomAndBrowseSplitPane  {

   public static JSplitPane searchRoomAndBrowseSplitPane(SearchRoomForm searchRoomForm,BrowseAvailableRoomsPanel browseAvailableRoomsPanel){
       searchRoomForm.setSize(new Dimension(300,300));
       JSplitPane splitPane=new JSplitPane(SwingConstants.VERTICAL,searchRoomForm,browseAvailableRoomsPanel);
       splitPane.setOrientation(SwingConstants.VERTICAL);
       browseAvailableRoomsPanel.setVisible(true);
       searchRoomForm.getSubmitButton().addActionListener(e -> {
           splitPane.setDividerLocation(300);
           searchRoomForm.getAstrisk().setVisible(true);
           browseAvailableRoomsPanel.getTablePane().setVisible(true);
           browseAvailableRoomsPanel.getTable().getTableHeader().setVisible(true);
           browseAvailableRoomsPanel.getTable().setVisible(true);
       });
       return splitPane;
   }
}
