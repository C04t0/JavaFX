package jfx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class Controller {

    @FXML
    private Button add;

    @FXML
    private Button cancel;

    @FXML
    private CheckBox completedCheckBox;

    @FXML
    private TableColumn<?, ?> descriptionColumn;

    @FXML
    private ComboBox<String> priorities;

    @FXML
    private TableColumn<?, ?> priorityColumn;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private TableColumn<?, ?> progressColumn;

    @FXML
    private Spinner<Integer> progressSpinner;

    @FXML
    private TextField taskDescription;

    @FXML
    private TableView<?> tasksTable;

    @FXML
    public void initialize() {
        priorities.getItems().addAll("High", "Medium", "Low");       //waarden aan de prioriteiten knop toewijzen
        progressSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));

            //waarden van de progress spinner - factory methodes zijn methodes die objecten aanmaken en weergeven

        progressSpinner.valueProperty().addListener(new ChangeListener<Integer>() {
            // nieuwe listener voor de progressSpinner
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                if (newValue == 100) {
                    completedCheckBox.setSelected(true);
                } else {
                    completedCheckBox.setSelected(false);
                }
                progressBar.setProgress(1.0 * newValue / 100);
            }
        });
    }
}
