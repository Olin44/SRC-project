package pl.project;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class TextTranslatorController {
    @FXML
    public TextField toTranslateTextField;
    @FXML
    public TableView textToTranslateTableView;
    @FXML
    public Button sendToTranslateButton;
    @FXML
    public Button translateButton;
    @FXML
    public TableView translatedTextTableView;

    private static final int CAPACITY = 2;
    private static final Queue<String> queue = new ArrayBlockingQueue<>(CAPACITY);

    public void initialize(){
        TranslatorCore translatorCore = new TranslatorCore(queue);
        translatorCore.start();
    }

    public void sendToTranslate(ActionEvent actionEvent) {
        if (CAPACITY > queue.size()) {
            System.out.println("dodaje text");
            queue.add("Item z przycisku");
            if (CAPACITY == queue.size()) {
                Platform.runLater(() -> {
                    sendToTranslateButton.setDisable(true);
                });
            }
        }
    }

    public void translate(ActionEvent actionEvent) {
        synchronized (queue) {
            queue.notify();
        }
    }
}
