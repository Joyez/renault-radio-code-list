package com.controllers;

import com.loaders.ReadSave;
import com.models.cars.Car;
import com.models.cars.Renault;
import com.models.codes.Code;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    @FXML
    private ComboBox<Car> comboBox;

    @FXML
    private TextField security;

    @FXML
    private TextField resutOfSecurityRadioCode;

    private Map<Code,Code> codeMap;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Car renault = new Renault("Renault");
        comboBox.setItems(FXCollections.observableArrayList(renault));
        codeMap = ReadSave.readCodes();
    }

    @FXML
    void checkSecurityRadioCode(ActionEvent event) {
        security.getText();
        codeMap.entrySet().stream().filter(pre -> pre.getKey().getNumberCode().equals(security.getText())).forEach(e-> resutOfSecurityRadioCode.setText(e.getValue().toString()));
    }


}
