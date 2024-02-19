package com.example.logic;

import java.sql.*;
import java.util.ArrayList;

public class DbSql {
    Connection connection;
    public DbSql() {
        connection = null;
        Statement stmt = null;
        try {
            String url = "jdbc:mysql://localhost:3306/studieadministration";
            connection = DriverManager.getConnection(url,"root","");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void opretStuderende(Studerende studerende) throws Exception {
        try {
            String sql = "INSERT INTO studerende (fnavn, enavn, adr, postnr, mobil, klasse) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, studerende.getFnavn());
            stmt.setString(2, studerende.getEnavn());
            stmt.setString(3, studerende.getAdresse());
            stmt.setString(4, studerende.getPostnr());
            stmt.setString(5, studerende.getMobil());
            stmt.setString(6, String.valueOf(studerende.getKlasse()));
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }
    public void opretFag(Fag fag) throws Exception {
        try {
            String sql = "INSERT INTO fag (fagnr, fagNavn) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, fag.getFagnr());
            stmt.setString(2, fag.getFagNavn());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }
    public void tilmeldFag(int stdnr, int fagnr) throws Exception {
        try {
            String sql = "INSERT INTO studfag (stdnr, fagnr, kar) VALUES (?, ?, NULL)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, stdnr);
            stmt.setInt(2, fagnr);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }


    public Studerende hentStamoplysninger(int stdnr) throws SQLException {
        Studerende studerende = null;
        String sqlStuderende = "SELECT * FROM studerende WHERE stdnr = ?";
        PreparedStatement stmtStuderende = connection.prepareStatement(sqlStuderende);
        stmtStuderende.setInt(1, stdnr);
        ResultSet rsStuderende = stmtStuderende.executeQuery();
        if (rsStuderende.next()) {
            studerende = new Studerende();
            studerende.setStdnr(rsStuderende.getInt("stdnr"));
            studerende.setFnavn(rsStuderende.getString("fnavn"));
            studerende.setEnavn(rsStuderende.getString("enavn"));
            studerende.setAdresse(rsStuderende.getString("adr"));
            studerende.setPostnr(rsStuderende.getString("postnr"));
            studerende.setMobil(rsStuderende.getString("mobil"));
            studerende.setKlasse(rsStuderende.getString("klasse").charAt(0));

            ArrayList<Fag> tilmeldteFag = new ArrayList<>();
            String sqlFag = "SELECT f.fagnr, f.fagNavn FROM fag f JOIN studfag sf ON f.fagnr = sf.fagnr WHERE sf.stdnr = ?";
            PreparedStatement stmtFag = connection.prepareStatement(sqlFag);
            stmtFag.setInt(1, stdnr);
            ResultSet rsFag = stmtFag.executeQuery();
            while (rsFag.next()) {
                Fag fag = new Fag();
                fag.setFagnr(rsFag.getInt("fagnr"));
                fag.setFagNavn(rsFag.getString("fagNavn"));
                tilmeldteFag.add(fag);
            }
            studerende.setTilmeldteFag(tilmeldteFag);

            rsFag.close();
            stmtFag.close();
        }
        rsStuderende.close();
        stmtStuderende.close();
        return studerende;
    }

}
