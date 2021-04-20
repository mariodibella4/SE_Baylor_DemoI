package UI;

import Servicers.*;
import app.Room;

import javax.swing.*;
import java.awt.*;
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

    public ReservationTotalsPane(ReservationTotalsCalculator reservationTotalsCalculator, Room[] rooms){
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

        Object[][] summary = ReservationSummaryRetriever.reservationSummaryRetriever(rooms);

        String[] headers={"No.","Type","Lvl"};
         tableRooms=new JTable(summary,headers);
        tableRooms.setVisible(true);
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
