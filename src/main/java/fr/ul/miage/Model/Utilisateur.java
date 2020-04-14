package fr.ul.miage.Model;

import java.util.ArrayList;
import java.util.Date;

public class Utilisateur {
    private int id;
    private ArrayList<Session> listSession;

    public Utilisateur() {
        this.id=0;
        this.listSession= new ArrayList<Session>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Session> getListSession() {
        return listSession;
    }

    public void setListSession(ArrayList<Session> listSession) {
        this.listSession = listSession;
    }

    public int nbrAction(Date d1, Date d2){
        int i=0;
        for(Session ses: listSession){
            for(Date d: ses.getListDate()){
                if(d.after(d1) && d.before(d2)){
                    i++;
                }
            }
        }
        return i;
    }

    public int nbrSession(Date d1, Date d2){
        int i=0;
        for(Session ses: listSession){
            if(ses.getListDate().get(0).after(d1) && ses.getListDate().get(0).before(d2)){
                i++;
            }
        }
        return i;
    }

    public int getDuree(Date d1, Date d2){
        int duree=0;
        for(Session ses: listSession){
            if(ses.getListDate().get(0).after(d1) && ses.getListDate().get(0).before(d2)){
                duree+=ses.getDuree();
            }
        }
        return duree;
    }
}
