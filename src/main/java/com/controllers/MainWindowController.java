package com.controllers;

import com.models.cars.Car;
import com.models.cars.Renault;
import com.models.codes.FirstCode;
import com.models.codes.SecondCode;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class MainWindowController implements Initializable {

    @FXML
    private ComboBox<Car> comboBox;

    @FXML
    private TextField security;

    @FXML
    private TextField resutOfSecurityRadioCode;

    private Map<FirstCode, SecondCode> codeMap;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Car renault = new Renault("Renault");
        comboBox.setItems(FXCollections.observableArrayList(renault));

        codeMap = new TreeMap<>();
    }

    @FXML
    void checkSecurityRadioCode(ActionEvent event) {

    }


}
