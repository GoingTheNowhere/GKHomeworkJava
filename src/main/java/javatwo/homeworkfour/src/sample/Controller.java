package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Controller {

    @FXML
    TextArea mainTextArea;

    @FXML
    TextField textField;

    public void getUserMessage(ActionEvent actionEvent) {
        if(textField.getText().trim().isEmpty()) {
            textField.clear();
            return;
        }
        mainTextArea.appendText(textField.getText() + "\n");
        textField.clear();
    }
}