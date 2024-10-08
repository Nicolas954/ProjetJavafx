package repository;

import database.database;
import javafx.scene.control.TextField;
import model.utilisateur;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.*;

public class UtilisateurRepository {

    public boolean inscription(utilisateur utilisateur) throws SQLException{
        Connection maConnextion= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bddjavafx","root",""
        );

        String nom= utilisateur.getNom();
        String prenom= utilisateur.getPrenom();
        String email= utilisateur.getEmail();
        String mot_de_passe= utilisateur.getMot_de_passe();

        database db = new database();
        Connection cnx = db.getConnexion();


        try {
            PreparedStatement requete = cnx.prepareStatement("INSERT INTO utilisateur (nom, prenom, email, mot_de_passe) VALUES (?, ?, ?, ?)");
            requete.setString(1, utilisateur.getNom());
            requete.setString(2, utilisateur.getPrenom());
            requete.setString(3, utilisateur.getEmail());

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(utilisateur.getMot_de_passe());
            requete.setString(4, hashedPassword);

            int rowsAffected = requete.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Erreur" + e.getMessage());
            return false;
        } finally {
            try {
                if (cnx != null) cnx.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public utilisateur getUtilisateurByEmail(String email) throws SQLException {
        Connection maConnextion= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bddjavafx","root",""
        );
        utilisateur user =null;
        database db = new database();
        Connection cnx = db.getConnexion();


        try {
            PreparedStatement requete = cnx.prepareStatement("INSERT INTO utilisateur (nom, prenom, email, mot_de_passe) VALUES (?, ?, ?, ?)");
            requete.setString(1,email);
            ResultSet rs = requete.executeQuery();
           while(rs.next()){
               rs.getInt(1);
               rs.getString(2);
               user = new utilisateur(rs.getInt(1),rs.getString(2));
           }

        } catch (SQLException e) {
            System.err.println("Erreur" + e.getMessage());
            return null;
        }
        return user;
    }
}
