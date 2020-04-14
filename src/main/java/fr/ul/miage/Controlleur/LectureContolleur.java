package fr.ul.miage.Controlleur;
import fr.ul.miage.Model.Utilisateur;
import fr.ul.miage.Model.data;
import fr.ul.miage.Model.lireCSV;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class LectureContolleur implements Initializable {

    @FXML
    private TableView<data> table;
    @FXML
    private DatePicker dateDebut;
    @FXML
    private DatePicker dateFin;

    private List<Utilisateur> listUtil;

    @FXML
    public void afficherPeriode() {
        Date date1= Date.from(Instant.from(dateDebut.getValue().atStartOfDay(ZoneId.systemDefault())));
        Date date2= Date.from(Instant.from(dateFin.getValue().atStartOfDay(ZoneId.systemDefault())));
        lireCSV lire= new lireCSV();

        ObservableList<data> studentsModels = FXCollections.observableList(lire.makeData(this.listUtil,date1,date2));
        table.setItems(studentsModels);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        String sDate1="31/12/1998 01:01";
        String sDate2="31/12/9999 23:59";
        Date date1= null,date2=null;
        try {
            date1 = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(sDate1);
            date2 = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(sDate2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        dateDebut.setValue(LocalDate.parse(sDate1, formatter));
        dateFin.setValue(LocalDate.parse(sDate2, formatter));

        lireCSV a= new lireCSV();
        this.listUtil=a.makeUtilisateur();
        ObservableList<data> studentsModels = FXCollections.observableList(a.makeData(this.listUtil,date1,date2));
        table.setItems(studentsModels);
        table.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        table.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("nbrAction"));
        table.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("nbrSession"));
        table.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("duree"));
    }

}
