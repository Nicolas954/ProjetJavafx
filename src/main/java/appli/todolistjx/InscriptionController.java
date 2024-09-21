package appli.todolistjx;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    private Label erreursLabel; // Label pour afficher les erreurs

    @FXML
    private Button inscriptionButton; // Bouton d'inscription

    @FXML
    private Button retourButton; // Bouton de retour à la connexion

    // Méthode appelée lors du clic sur le bouton d'inscription
    @FXML
    private void onInscriptionButtonClick() {
        String name = nomField.getText();
        String firstname = prenomField.getText();
        String email = emailField.getText();
        String password = mdpField.getText();
        String confpassword = confirmationField.getText();

        // Affiche les valeurs saisies dans la console
        System.out.println("Nom : " + name);
        System.out.println("Prenom: " + firstname);
        System.out.println("Email: " + email);
        System.out.println("Mot de passe: " + password);
        System.out.println("Mot de passe confirmé: " + confpassword);

        // Vérification simple (à améliorer plus tard)
        if (name.isEmpty() || firstname.isEmpty() ||email.isEmpty() || password.isEmpty() || confpassword.isEmpty()) {
            erreursLabel.setText("Veuillez remplir tous les champs.");
        } else {
            erreursLabel.setText("");
            System.out.println("Inscription en cours...");
        }
    }

    @FXML
    private void onRetourButtonClick() {
        System.out.println("Retour à la page de connexion.");
        // StartApplication.changeScene("login.fxml"); // (difficultés pour faire fonctionner le changeScene)
    }
}
