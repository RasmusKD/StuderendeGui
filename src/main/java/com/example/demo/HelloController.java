package com.example.demo;

import com.example.logic.DbSql;
import com.example.logic.Fag;
import com.example.logic.Studerende;
import com.example.logic.UseCase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    private UseCase useCase = new UseCase(new DbSql());

    @FXML
    private TextField searchfield;

    @FXML
    private Label resultLabel;

    @FXML
    private void hentStamoplysninger(ActionEvent actionEvent) {
        try {
            int stdnr = Integer.parseInt(searchfield.getText());
            Studerende studerende = useCase.hentStamoplysninger(stdnr);
            if (studerende != null) {
                String studerendeInfo = formatStuderendeInfo(studerende);
                resultLabel.setText(studerendeInfo);
            } else {
                resultLabel.setText("Ingen studerende fundet med det studienummer.");
            }
        } catch (Exception e) {
            resultLabel.setText("Fejl ved søgning: " + e.getMessage());
        }
    }

    public String formatStuderendeInfo(Studerende studerende) {
        StringBuilder sb = new StringBuilder();
        sb.append("Studienummer: ").append(studerende.getStdnr()).append("\n");
        sb.append("Fornavn: ").append(studerende.getFnavn()).append("\n");
        sb.append("Efternavn: ").append(studerende.getEnavn()).append("\n");
        sb.append("Adresse: ").append(studerende.getAdresse()).append("\n");
        sb.append("Postnummer: ").append(studerende.getPostnr()).append("\n");
        sb.append("Mobil: ").append(studerende.getMobil()).append("\n");
        sb.append("Klasse: ").append(studerende.getKlasse()).append("\n");
        sb.append("Tilmeldte fag:\n");
        for (Fag fag : studerende.getTilmeldteFag()) {
            sb.append(fag.getFagNavn()).append("\n");
        }

        return sb.toString();
    }

}
