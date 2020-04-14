package fr.ul.miage.Model;

import java.util.ArrayList;
import java.util.Date;

public class Session {
    private ArrayList<Date> listDate;

    public Session() {
        this.listDate = new ArrayList<Date>();
    }

    public ArrayList<Date> getListDate() {
        return listDate;
    }

    public void setListDate(ArrayList<Date> listDate) {
        this.listDate = listDate;
    }

    public int getDuree(){
        int diff =  (int) (listDate.get(0).getTime() - listDate.get(listDate.size()-1).getTime());
        int resu;
        if(diff<0){
            resu=-diff;
        }
        else{resu=diff;}
        int nbMinutes = resu / 60000;
        return nbMinutes;

    }

    @Override
    public String toString() {
        return "Session{" +
                "listDate=" + listDate +
                '}';
    }


}
