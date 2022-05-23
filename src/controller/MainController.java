/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import model.Időjárás;
import model.Kertészet;
import model.Növény;
import model.Vásárló;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import model.NövényTableRow;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class MainController implements Initializable {

    @FXML
    private Label PénzLabel;

    @FXML
    private Label labelIdőjárás;

    @FXML
    private TableView termékTáblázat;

    @FXML
    private Spinner mennyiség;

    @FXML
    private Button megvesz;

    Időjárás időjárás = new Időjárás();

    Kertészet kertészet = new Kertészet("Budai kertészet");

    Vásárló vásárló1 = new Vásárló();

    final ObservableList<NövényTableRow> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        kertészet.addNövény(new Növény("Paradicsom", 20, 100));

        Vásárló vásárló2 = new Vásárló(20000);
        vásárló1.vásárol(kertészet, kertészet.getNövényekByÁr().get(0), 2);

        ArrayList<Növény> növények = kertészet.getNövényekByÁr();

        for (int i = 0; i < növények.size(); i++) {
            System.out.println(növények.get(i).toString());
        }

        vásárló1.setTörzsvásárló(true);
        vásárló1.vásárol(kertészet, kertészet.getNövényekByÁr().get(0), 2);

        System.out.println(vásárló1.getPénz());

        időjárásFrissítés();

        TableColumn névCol = new TableColumn("Név");
        TableColumn árCol = new TableColumn("Ár");
        TableColumn mennyiségCol = new TableColumn("Mennyiség");

        termékTáblázat.getColumns().addAll(névCol, árCol, mennyiségCol);

        for (Növény növény : kertészet.getNövényekByÁr()) {
            data.add(new NövényTableRow(növény.getNév(), növény.getÁr() + "", (int) növény.getMennyiség() + ""));
        }

        névCol.setCellValueFactory(
                new PropertyValueFactory<>("név")
        );
        árCol.setCellValueFactory(
                new PropertyValueFactory<>("ár")
        );
        mennyiségCol.setCellValueFactory(
                new PropertyValueFactory<>("mennyiség")
        );

        termékTáblázat.setItems(data);
        fizetéstMegjelenít();

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);
        mennyiség.setValueFactory(valueFactory);
        mennyiség.setEditable(true);

        megvesz.setDisable(true);
    }

    @FXML
    private void időjárásFrissítésButtonAction(ActionEvent event) {
        időjárásFrissítés();
    }

    @FXML
    private void termékKiválaszt(MouseEvent event) {
        System.out.println(termékTáblázat.getItems().get(termékTáblázat.getSelectionModel().getFocusedIndex()));
        megvesz.setDisable(false);
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        vásárló1.fizetéstKap(10000);
        fizetéstMegjelenít();
    }

    @FXML
    private void fizet(ActionEvent event) {
        vásárló1.vásárol(kertészet, kertészet.getNövényekByÁr().get(termékTáblázat.getSelectionModel().getFocusedIndex()), Integer.parseInt(mennyiség.valueProperty().getValue() + ""));
        fizetéstMegjelenít();
        data.clear();
        for (Növény növény : kertészet.getNövényekByÁr()) {
            data.add(new NövényTableRow(növény.getNév(), növény.getÁr() + "", (int) növény.getMennyiség() + ""));
        }
        megvesz.setDisable(true);
    }

    private void időjárásFrissítés() {
        labelIdőjárás.setText(időjárás.get() + "");
    }

    private void fizetéstMegjelenít() {
        PénzLabel.setText(vásárló1.getPénz() + " Ft");
    }

}
