package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


public class Controller {


    @FXML
    private TextField inputField;
    @FXML
    private ListView<String> listView;
    @FXML
    private TableView<RowWord> tableView;
    @FXML
    private TableColumn<RowWord, String> wordColumn;
    @FXML
    private TableColumn<RowWord, Integer> countColumn;
    private final ObservableList<RowWord> frequencyByWord = FXCollections.observableArrayList(new RowWord("Робот", 1),
            new RowWord("Молоко", 1));
    private final ObservableList<String> wordList = FXCollections.observableArrayList("Молоко", "Человек");

    @FXML
    public void initialize() {
        listView.setItems(wordList);
        tableView.setItems(frequencyByWord);
        wordColumn.setCellValueFactory(new PropertyValueFactory<>("word"));
        countColumn.setCellValueFactory(new PropertyValueFactory<>("count"));
    }

    @FXML
    public void addWord() {
        String word = inputField.getText();
        if (word.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Input Information");
            alert.setHeaderText("Вводите слова!");
            alert.setContentText("Сообщение не должно быть пустым");
            alert.showAndWait();
        } else {
            addWordtoList(word);
            addWordtoTable(word);

        }
        inputField.clear();
    }

    private void addWordtoList(String word) {
        listView.getItems().add(word);
    }

    private void addWordtoTable(String word) {
        for (RowWord rowWord : frequencyByWord) {
            if (word.equals(rowWord.getWord())) {
                rowWord.inCount();
                return;
            }

        }
        frequencyByWord.add(new RowWord(word, 1));


    }

    @FXML
    public void Exit() {
        System.exit(0);
    }
}
