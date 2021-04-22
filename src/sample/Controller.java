package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {
    @FXML
    TextField msgField;
    @FXML
    TextArea textArea;
    @FXML
    Button sentBtn;



    public void clickSendBtn(ActionEvent actionEvent) {
        textArea.appendText("person1: " + msgField.getText() + "\n");
        System.out.println(msgField.getText());
        msgField.clear();
    }




    public void onKeyPressed(KeyEvent keyEvent) {
        sentBtn.setOnKeyPressed(event -> {
            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                textArea.appendText("person1: " + msgField.getText() + "\n");
                System.out.println(msgField.getText());
                msgField.clear();
            }
        });
    }

    public void actionPerformed(ActionEvent actionEvent) {
        textArea.appendText("person1: " + msgField.getText() + "\n");
        System.out.println(msgField.getText());
        msgField.clear();
    }
}
