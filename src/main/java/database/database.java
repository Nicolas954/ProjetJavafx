package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
    private String serveur = "localhost";
    private String nomDeLaBase = "bddjavafx";
    private String utilisateur = "admin";
    private String MotDePasse = "1234";

    public database() {
        this.serveur = serveur;
        this.nomDeLaBase = nomDeLaBase;
        this.utilisateur = utilisateur;
        this.MotDePasse = MotDePasse;

    }

    private String getUrl() {
        return "jdbc:mysql://" + serveur + "/" + nomDeLaBase + "?serverTimezone=UTC";
    }

    public Connection getConnexion() {
        try {
            Connection cnx = DriverManager.getConnection(this.getUrl(), this.utilisateur, this.MotDePasse);
            System.out.println("Etat de la connexion :");
            System.out.println(cnx.isClosed() ? "fermée" : "ouverte \r\n");
            return cnx;
        } catch (SQLException e) {
            System.out.println("Erreur lors de la tentative de connexion à la base de données");
            e.printStackTrace();
        }
        return null;
    }
}

