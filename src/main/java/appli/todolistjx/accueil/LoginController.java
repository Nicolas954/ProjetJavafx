package appli.todolistjx.accueil;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import appli.todolistjx.StartApplication;
import model.utilisateur;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import repository.UtilisateurRepository;

import java.io.IOException;
import java.sql.SQLException;


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
    protected void onConnexionButtonClick() throws SQLException {
        String email = emailField.getText();
        String password = mdpField.getText();

        System.out.println("Email: " + email);
        System.out.println("Mot de passe: " + password);


        if (email==null || email.isEmpty() || password==null || password.isEmpty()) {
        erreurLabel.setText("Erreur : Veuillez remplir les champs vide!");
        return;
        }
        UtilisateurRepository utilisateurRepo = new UtilisateurRepository();
        utilisateur utilisateur = utilisateurRepo.getUtilisateurByEmail(email);

        if (emailField == null || !utilisateur.getMot_de_passe().equals(password)) {
            erreurLabel.setText("Erreur : Email ou mot de passe incorrect.");
            return;
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (!passwordEncoder.matches(password, utilisateur.getMot_de_passe())) {
            erreurLabel.setText("Erreur: Email ou mot de passe incorrect.");
            return;
        }
        else {
            System.out.println("Connexion en cours...");
            StartApplication.changeScene("AccueilView.fxml");
        }
    }

    @FXML
    private void onMotdepasseoublieButtonClick() {
        System.out.println("Action : Mot de passe oublié.");
        erreurLabel.setText("Envoi du nouveau mot de passe par émail!");
    }


    @FXML
    private void onInscriptionButtonClick() throws IOException {
        System.out.println("Action : Inscription.");
        StartApplication.changeScene("inscriptionView.fxml");
    }

}