package appli.todolistjx.accueil;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import appli.todolistjx.StartApplication;

import java.io.IOException;


public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField mdpField;

    @FXML
    private Label erreurLabel;

    @FXML
    private Button connexionButton;

    @FXML
    private Button motDePasseOublieButton;

    @FXML
    private Button inscriptionButton;


    @FXML
    protected void onConnexionButtonClick() {
        String email = emailField.getText();
        String password = mdpField.getText();

        System.out.println("Email: " + email);
        System.out.println("Mot de passe: " + password);

        if (email==null || email.length()==0 || password==null || password.length()==0) {
        erreurLabel.setText("Erreur de connexion!");
        } else {
            System.out.println("Connexion en cours...");
        }
    }

    @FXML
    private void onMotdepasseoublieButtonClick() {
        System.out.println("Action : Mot de passe oublié.");
    }

    @FXML
    private void onInscriptionButtonClick() throws IOException {
        System.out.println("Action : Inscription.");
        //StartApplication.changeScene(new String[]{"inscriptionView"}); // (difficultés pour faire fonctionner le changeScene)
    }

}