package fr.ul.miage.Model;
import fr.ul.miage.App;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

public class lireCSV {
    private static final Logger LOG= Logger.getLogger(App.class.getName());


    public CSVParser buildCSVPARSER() throws IOException {
        App app = new App();
        Reader in;
        in = new FileReader(app.getFilename());
        CSVFormat csvf = CSVFormat.DEFAULT.withCommentMarker('#').withDelimiter(';').withFirstRecordAsHeader();
        return new CSVParser(in,csvf);
    }

    public List<Utilisateur> makeUtilisateur(){

        HashMap<Integer, ArrayList<Date>> map= new HashMap<>();
        HashMap<Integer, ArrayList<Session>> sessions;

        ArrayList<Utilisateur> listUtil= new ArrayList<>();

        lireCSV app = new lireCSV();
        String idStr,dateStr;
        int id;
        Date date;
        try {

            CSVParser p = app.buildCSVPARSER();
            for(CSVRecord r: p){
                idStr= r.get(0);
                dateStr = r.get(1);
                date=makeDate(dateStr);
                id=Integer.parseInt(idStr);
                if(!map.containsKey(id)) {
                    // si elle n'existe pas
                    map.put(id, new ArrayList<>());
                    ArrayList<Date> list = map.get(id);
                    list.add(date);
                    map.put(id, list);
                }else {
                    map.get(id).add(date);
                }
            }
        }catch (IOException e){
            LOG.severe("ERREUR de lecture dans le fichier CSV");
        }

        sessions=creerSession(map);

        Utilisateur util;
        //creer les utilisateurs avec la hashmap sessions
        for (Map.Entry mapentry : sessions.entrySet()) {
            util= new Utilisateur();
            util.setId((Integer) mapentry.getKey());
            util.setListSession(sessions.get(mapentry.getKey()));
            listUtil.add(util);
        }
        return listUtil;
    }

    public List<data> makeData(List<Utilisateur> listUtil,Date date1, Date date2){
        List<data> list = new ArrayList<>();
        for(Utilisateur u:listUtil){
            list.add(new data(u.getId(),u.nbrSession(date1,date2),u.nbrAction(date1,date2),u.getDuree(date1,date2)));
        }
        return list;
    }


    private static HashMap<Integer, ArrayList<Session>> creerSession(HashMap<Integer, ArrayList<Date>> map){
        HashMap<Integer, ArrayList<Session>> liste= new HashMap<>();
        ArrayList<Session> sessions= new ArrayList<>();
        Session session= new Session();

        //parcourir les id
        for (Map.Entry mapentry : map.entrySet()) {
            // pour toutes les dates de cet utilisateur
            for(Date d:map.get(mapentry.getKey())){
                //faire la session

                // si c'est la première
                if(sessions.size()==0){
                    session= new Session();
                    session.getListDate().add(d);
                    sessions.add(session);
                }else if(entre2date(session.getListDate().get(session.getListDate().size()-1),d)){
                    //si les date<30 minutes
                    sessions.get(sessions.size()-1).getListDate().add(d);
                }else {
                    session= new Session();
                    session.getListDate().add(d);
                    sessions.add(session);
                }

            }
            liste.put((Integer) mapentry.getKey(),sessions);
            sessions= new ArrayList<>();
        }

        return liste;
    }
    private static boolean entre2date(Date d1, Date d2){
        int diff =  (int) (d1.getTime() - d2.getTime());
        int resu;
        if(diff<0){
            resu=-diff;
        }
        else{resu=diff;}
        int nbMinutes = resu / 60000;
        if(nbMinutes<=30){
            return true;
        }else {
            return false;
        }
    }
    public static Date makeDate(String s){
        String[] tabData;
        tabData=s.split(",");

        // enlever espace pour l'heure
        tabData[1]=tabData[1].trim();

        String[] strData;
        String mois= "";
        strData=tabData[0].split(" ");
        switch (strData[1]){
            case "janv.":
            case "janv":
                mois="01";
                break;
            case "févr.":
            case "févr":
                mois="02";
                break;
            case "mars.":
            case "mars":
                mois="03";
                break;
            case "avril.":
            case "avril":
                mois="04";
                break;
            case "mai.":
            case "mai":
                mois="05";
                break;
            case "juin.":
            case "juin":
                mois="06";
                break;
            case "juil.":
            case "juil":
                mois="07";
                break;
            case "août.":
            case "août":
                mois="08";
                break;
            case "sept.":
            case "sept":
                mois="09";
                break;
            case "oct.":
            case "oct":
                mois="10";
                break;
            case "nov.":
            case "nov":
                mois="11";
                break;
            case "déc.":
            case "déc":
                mois="12";
                break;
            default:
                System.out.println("probleme lecture mois");
                break;
        }
        String strDate= mois + "-" + strData[0] + "-20" + strData[2] + " " + tabData[1];

        String pattern = "MM-dd-yyyy HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = simpleDateFormat.parse(strDate);
        } catch (ParseException e) {
            System.out.println("problème lecture date");
        }
        return date;
    }

}
