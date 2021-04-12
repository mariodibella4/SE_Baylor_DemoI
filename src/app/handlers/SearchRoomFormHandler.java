package app.handlers;

import Servicers.DatePicker;
import Servicers.WarningWindow;
import UI.SearchRoomForm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SearchRoomFormHandler {
   public SearchRoomFormHandler(SearchRoomForm searchRoomForm){
       searchRoomForm.getCheckinCal().addActionListener(e -> {
           String date =new DatePicker(searchRoomForm.getCalPopup()).setPickedDate();
           LocalDate localDate=LocalDate.parse(date, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
           long daysCheckin=localDate.toEpochDay();

           LocalDate localDateCi=LocalDate.now();
           long daysToday=localDateCi.toEpochDay();
           DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");

           if(daysCheckin-daysToday<0)
               WarningWindow.createWindow("Please Select "+dtf.format(localDateCi)+" or a future date.","Oops");
           else {
               SearchRoomForm.getExpectedCheckin().setText(date);
               searchRoomForm.getCheckoutCal().setVisible(true);
           }
       });
       searchRoomForm.getCheckoutCal().addActionListener(e -> {
           String date =new DatePicker(searchRoomForm.getCalPopup()).setPickedDate();
           LocalDate localDate=LocalDate.parse(date, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
           long daysCheckout=localDate.toEpochDay();
           String checkinDate=SearchRoomForm.getExpectedCheckin().getText();
           LocalDate localDateCi=LocalDate.parse(checkinDate, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
           long daysCheckin=localDateCi.toEpochDay();
           if(daysCheckout-daysCheckin<=0){
               WarningWindow.createWindow("Please Select Dates greater than "+checkinDate,"Oops");
           }else
               SearchRoomForm.getExpectedCheckout().setText(date);
       });
   }
}
