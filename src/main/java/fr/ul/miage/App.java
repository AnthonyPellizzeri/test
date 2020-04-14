package fr.ul.miage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.commons.cli.*;

import java.util.logging.Logger;

public class App extends Application {

    private static final Logger LOG = Logger.getLogger(App.class.getName());
    private static String filename = null;

    public String getFilename() {
        return filename;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/Hello.fxml"));
        primaryStage.setTitle("TP1");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        //options
        Options options = new Options();
        Option input = new Option("i", "input", true, "Nom du fichier .csv contenant la liste des données");
        input.setRequired(true);
        options.addOption(input);
        //parser la ligne de commande
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine line = parser.parse(options, args);
            if (line.hasOption("i")) {
                filename = line.getOptionValue("i");
            }
        } catch (ParseException exp) {
            LOG.severe("Erreur dans la ligne de commande");
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("Main", options);
            System.exit(1);
        }
        launch(args);
    }

}
