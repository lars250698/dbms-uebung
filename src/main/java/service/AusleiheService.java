package service;

import model.Buch;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AusleiheService {

    public static void ausleihen(int leserId, String isbn) {
        Buch nichtAusgeliehen = BuchService.getBuchNotAusgeliehenByIsbn(isbn);
        if (nichtAusgeliehen == null) {
            System.out.println("Alle Bücher mit ISBN " + isbn + " sind bereits ausgeliehen. Ausleihe konnte nicht vorgenommen werden");
            return;
        }
        try {
            PreparedStatement statement = DatabaseService.getInstance().getConnection()
                    .prepareStatement("INSERT INTO ausleihe (isbn, explnr, datum, leserid) VALUES (?,?,?,?)");
            statement.setString(1, nichtAusgeliehen.getIsbn());
            statement.setInt(2, nichtAusgeliehen.getExemplarNummer());
            statement.setDate(3, new Date((new java.util.Date().getTime())));
            statement.setInt(4, leserId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
