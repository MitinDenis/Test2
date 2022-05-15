package com.example.apmini;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.apmini.DB;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.w3c.dom.events.MouseEvent;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button;

    @FXML
    private TextField textfield;

    @FXML
    private VBox vbox;

    DB db = null;

    @FXML
    void initialize() {
        db = new DB();
        button.setOnAction(event -> {           //addEventHandler(MouseEvent. );
            try {
                if (!textfield.getText().trim().equals("")) {
                    for(int i = 0; i<Integer.parseInt(String.valueOf(textfield)); i++){
                        db.insertsensor(String.valueOf(Math.random())); //!!!
                    }
                    loadInfo();
                    textfield.setText("");
                }
            }catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        loadInfo();
    }
    private void loadInfo() {
        try {
            vbox.getChildren().clear();
            ArrayList<String> sensors = db.getSensors();
            for (int i = 0; i < sensors.size(); i++)
                vbox.getChildren().add(new Label(sensors.get(i)));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
