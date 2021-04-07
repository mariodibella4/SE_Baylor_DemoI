import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ReservationTotalsPane extends JPanel {
    private JLabel totalBeforeTax;
    private JLabel totalAfterTax;
    private JLabel totalSalesTax;
    private JLabel totalCityTax;
    private JLabel totalServiceTax;
    private JLabel numberOfNights;
    private JLabel totalBeforeTaxLabel;
    private JLabel totalAfterTaxLabel;
    private JLabel totalSalesTaxLabel;
    private JLabel totalCityTaxLabel;
    private JLabel totalServiceTaxLabel;
    private JLabel numberOfNightsLabel;
    private JTable tableRooms;

    ReservationTotalsPane(ReservationTotalsCalculator reservationTotalsCalculator, Room[] rooms){
        Dimension dim=getPreferredSize();
        setPreferredSize(dim);
        setBorder(BorderFactory.createTitledBorder("Stay Description"));
         totalBeforeTax = new JLabel(String.valueOf(reservationTotalsCalculator.getTotalBeforeTax()));
        totalAfterTax = new JLabel(String.valueOf(reservationTotalsCalculator.getTotalAfterTax()));
          totalSalesTax = new JLabel(String.valueOf(reservationTotalsCalculator.getTotalSalesTax()));
          totalCityTax = new JLabel(String.valueOf(reservationTotalsCalculator.getTotalCityTax()));
          totalServiceTax = new JLabel(String.valueOf(reservationTotalsCalculator.getTotalServiceTax()));
          numberOfNights=new JLabel(String.valueOf(reservationTotalsCalculator.getNumberOfNights()));

         totalBeforeTaxLabel = new JLabel("Total Before Tax: ");
         totalAfterTaxLabel = new JLabel("Total: ");
         totalSalesTaxLabel = new JLabel("Sales Tax: ");
         totalServiceTaxLabel = new JLabel("Service Tax: ");
         numberOfNightsLabel = new JLabel("Number of Nights: ");
         totalCityTaxLabel = new JLabel("City Tax: ");

         int noKings=0;
         int noQueens=0;
        ArrayList<String> kingsLvl=new ArrayList<>();
        ArrayList<String> queensLvl=new ArrayList<>();
         for(int i=0;i<rooms.length;i++){
             if(rooms[i].getBedType()=="King"){
                 ++noKings;
                 if(rooms[i].getQuality()==2){
                     kingsLvl.add("Std");
                 }else
                    kingsLvl.add(String.valueOf(rooms[i].getQuality()));
             }else if(rooms[i].getBedType()=="Two Queen"){
                 ++noQueens;
                 if(rooms[i].getQuality()==2){
                     queensLvl.add("Std");
                 }else
                     queensLvl.add(String.valueOf(rooms[i].getQuality()));
             }
         }

         String[] headers={"No.","Type","Lvl"};
        Object[][] summary;String kL="";String qL="";
        if(kingsLvl.size()==1 && queensLvl.size()==1) {
            summary = new Object[2][3];
            summary[0][0]=noKings;
            summary[0][1]="Kng";
            for(String k : kingsLvl){
                kL+=k+" ";
            }
            summary[0][2]=kL;

            summary[1][0]=noQueens;
            summary[1][1]="Qs";
            for(String q : queensLvl){
                qL+=q+" ";
            }
            summary[1][2]=qL;
        }else{
            summary = new Object[1][3];
            if(noKings>0){
                summary[0][0]=noKings;
                summary[0][1]="Kng";
                for(String k : kingsLvl){
                    kL+=k+" ";
                }
                summary[0][2]=kL;
            }else{
                summary[0][0]=noQueens;
                summary[0][1]="Qs";
                for(String q : queensLvl){
                    qL+=q+" ";
                }
                summary[0][2]=qL;
            }
        }

         tableRooms=new JTable(summary,headers);
        tableRooms.getTableHeader().setVisible(true);
        add(tableRooms);
         setLayout(new GridBagLayout());

        GridBagConstraints gc=new GridBagConstraints();
        gc.fill=GridBagConstraints.RELATIVE;
        //First ROW
        gc.weightx=.1;
        gc.weighty=.1;
        gc.gridx=0;
        gc.gridy=0;
        gc.anchor = GridBagConstraints.CENTER;
        add(tableRooms,gc);

        gc.gridx=0;
        gc.gridy=1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(numberOfNightsLabel,gc);
        gc.gridx=1;
        gc.gridy=1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(numberOfNights,gc);
        //Second Row
      //  gc.weightx=.1;
        //gc.weighty=.1;
        gc.gridx=0;
        gc.gridy=2;
        gc.anchor = GridBagConstraints.LINE_START;
        add(totalBeforeTaxLabel,gc);

        gc.gridx=1;
        gc.gridy=2;
        gc.anchor = GridBagConstraints.LINE_START;
        add(totalBeforeTax,gc);
        gc.gridx=0;
        gc.gridy=3;
        gc.anchor = GridBagConstraints.LINE_START;
        add(totalSalesTaxLabel,gc);
        //Third Row
       // gc.weightx=1;
       // gc.weighty=.1;
        gc.gridx=1;
        gc.gridy=3;
        gc.anchor = GridBagConstraints.LINE_START;
        add(totalSalesTax,gc);

        gc.gridx=0;
        gc.gridy=4;
        gc.anchor = GridBagConstraints.LINE_START;
        add(totalCityTaxLabel,gc);
        //Fourth Row

       // gc.weightx=1;
        //gc.weighty=.1;
        gc.gridx=1;
        gc.gridy=4;
        gc.anchor = GridBagConstraints.LINE_START;
        add(totalCityTax,gc);

        gc.gridx=0;
        gc.gridy=5;
        gc.anchor = GridBagConstraints.LINE_START;
        add(totalServiceTaxLabel,gc);

        gc.gridx=1;
        gc.gridy=5;
        gc.anchor = GridBagConstraints.LINE_START;
        add(totalServiceTax,gc);

        //Sixth Row
       // gc.weightx=1;
      //  gc.weighty=.11;
        gc.gridx=0;
        gc.gridy=6;
        gc.anchor = GridBagConstraints.LINE_START;
        add(totalAfterTaxLabel,gc);
        gc.gridx=1;
        gc.gridy=6;
        gc.anchor = GridBagConstraints.LINE_START;
        add(totalAfterTax,gc);


    }
}
