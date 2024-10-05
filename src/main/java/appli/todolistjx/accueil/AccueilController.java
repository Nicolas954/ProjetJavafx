package appli.todolistjx.accueil;
import appli.todolistjx.StartApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AccueilController {

        @FXML
        private Label welcomeLabel;

        @FXML
        public void initialize() {

            welcomeLabel.setText("Bienvenue dans l'application !");
        }

        @FXML
        private void onDeconnexionButtonClick() {

            Stage stage = (Stage) welcomeLabel.getScene().getWindow();
            StartApplication.changeScene("loginView.fxml");
        }
    }
