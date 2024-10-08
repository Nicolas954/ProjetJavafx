package appli.todolistjx;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.utilisateur;
import repository.UtilisateurRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class InscriptionController {

    @FXML
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField mdpField;

    @FXML
    private PasswordField confirmationField;

    @FXML
    private Label erreursLabel;

    @FXML
    private Button inscriptionButton;

    @FXML
    private Button retourButton;


    @FXML
    private void onInscriptionButtonClick() {
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String email = emailField.getText();
        String mot_de_passe = mdpField.getText();
        String confpassword = confirmationField.getText();


        System.out.println("Nom : " + nom);
        System.out.println("Prenom: " + prenom);
        System.out.println("Email: " + email);
        System.out.println("Mot de passe: " + mot_de_passe);
        System.out.println("Mot de passe confirmé: " + confpassword);


        if (nom.isEmpty() || prenom.isEmpty() ||email.isEmpty() || mot_de_passe.isEmpty() ||confpassword.isEmpty()) {
            erreursLabel.setText("Erreur : Veuillez remplir tous les champs.");
            return;
        }

        if (!mdpField.getText().equals(confirmationField.getText())) {
            erreursLabel.setText("Erreur : les mots de passe ne correspondent pas !");
            return;
        }

        else {
            erreursLabel.setText("");
            System.out.println("Inscription en cours...");
        }
        utilisateur utilisateur = new utilisateur(0, nomField.getText(), prenomField.getText(), emailField.getText(), mdpField.getText());

        UtilisateurRepository utilisateurRepo = new UtilisateurRepository();
        boolean success = false;
        try {
            success = utilisateurRepo.inscription(utilisateur);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        if (success) {
            erreursLabel.setText("Utilisateur bien ajouté !");

            nomField.clear();
            prenomField.clear();
            emailField.clear();
            mdpField.clear();
            confirmationField.clear();
        } else {
            erreursLabel.setText("Erreur lors de l'ajout de l'utilisateur.");
        }
    }


    @FXML
    private void onRetourButtonClick() throws IOException {
        System.out.println("Retour à la page de connexion.");
        StartApplication.changeScene("loginView.fxml");
    }
}
