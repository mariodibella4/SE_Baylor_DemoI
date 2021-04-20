package Servicers;

import app.Room;

import java.util.ArrayList;

public class ReservationSummaryRetriever {

    public static Object[][] reservationSummaryRetriever(Room[] rooms){
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
        return summary;

    }
}
