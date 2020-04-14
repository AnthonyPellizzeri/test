package fr.ul.miage.Model;


public class data {
    private int id;
    private int nbrSession;
    private int nbrAction;
    private int duree;

    public data(int id,int nbrSession,int nbrAction,int duree) {
        this.id =id;
        this.nbrSession = nbrSession;
        this.nbrAction = nbrAction;
        this.duree = duree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbrSession() {
        return nbrSession;
    }

    public void setNbrSession(int nbrSession) {
        this.nbrSession = nbrSession;
    }

    public int getNbrAction() {
        return nbrAction;
    }

    public void setNbrAction(int nbrAction) {
        this.nbrAction = nbrAction;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    @Override
    public String toString() {
        return "data{" +
                "id=" + id +
                ", nbrSession=" + nbrSession +
                ", nbrAction=" + nbrAction +
                ", duree=" + duree +
                '}';
    }
}
