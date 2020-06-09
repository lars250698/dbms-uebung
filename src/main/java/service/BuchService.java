package service;

import model.Buch;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuchService {

    public static Buch getBuchNotAusgeliehenByIsbn(String isbn) {
        List<Buch> books = Collections.emptyList();
        try {
            PreparedStatement statement = DatabaseService.getInstance().getConnection()
                    .prepareStatement("SELECT isbn, explnr, titel, autorname FROM buchex WHERE (isbn, explnr) NOT IN (SELECT isbn, explnr FROM ausleihe) AND isbn = ?");
            statement.setString(1, isbn);
            ResultSet resultSet = statement.executeQuery();
            books = parseBuchFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (books.isEmpty()) {
            return null;
        }
        return books.get(0);
    }

    public static List<Buch> getAusgelieheneBuecherByLeser(int leserId) {
        try {
            PreparedStatement statement = DatabaseService.getInstance().getConnection()
                    .prepareStatement("SELECT b.isbn, b.explnr, b.titel, b.autorname FROM ausleihe as A JOIN buchex AS B ON (a.isbn= b.isbn AND a.explnr = b.explnr) WHERE a.leserid = ?");
            statement.setInt(1, leserId);
            ResultSet resultSet = statement.executeQuery();
            return parseBuchFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private static List<Buch> parseBuchFromResultSet(ResultSet resultSet) throws SQLException {
        List<Buch> result = new ArrayList<>();
        while (resultSet.next()) {
            Buch buch = new Buch();
            buch.setIsbn(resultSet.getString("ISBN"));
            buch.setExemplarNummer(resultSet.getInt("EXPLNR"));
            buch.setTitel(resultSet.getString("Titel"));
            buch.setAutorname(resultSet.getString("Autorname"));
            result.add(buch);
        }
        return result;
    }
}
