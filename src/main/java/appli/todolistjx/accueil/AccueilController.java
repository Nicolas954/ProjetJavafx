package appli.todolistjx.accueil;
import appli.todolistjx.StartApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AccueilController implements Initializable {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
