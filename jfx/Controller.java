package jfx;

import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


public class Controller {

    private Task currentTask =
            new Task();
    private final ObservableList<Task> tasks =
            FXCollections.observableArrayList();
    @FXML
    private Button add;
    @FXML
    private Button cancel;
    @FXML
    private CheckBox completedCheckBox;
    @FXML
    private TableColumn<Task, String> descriptionColumn;
    @FXML
    private ComboBox<String> priorities;
    @FXML
    private TableColumn<Task, String> priorityColumn;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private TableColumn<Task, String> progressColumn;
    @FXML
    private Spinner<Integer> progressSpinner;
    @FXML
    private TextField taskDescription;
    @FXML
    private TableView<Task> tasksTable;
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
                System.out.println(currentTask.getDescription());
                System.out.println(currentTask.getProgress());
                System.out.println(currentTask.getPriority());

            }
        });

        ReadOnlyIntegerProperty intProgress =                                               //read only int property
                ReadOnlyIntegerProperty.readOnlyIntegerProperty(progressSpinner.valueProperty());
        progressBar.progressProperty().bind(intProgress.divide(100.0));

        priorities.valueProperty().bindBidirectional(currentTask.priorityProperty()); //bind bi-directional to combobox
        taskDescription.textProperty().bindBidirectional(currentTask.descriptionProperty()); //description to textfield
        progressSpinner.getValueFactory().valueProperty().bindBidirectional(currentTask.progressProperty()); //progress to spinner

        tasksTable.setItems(tasks);                         // tasks to tasksTable
        priorityColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("priority"));
        progressColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("progress"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("description"));

        tasks.addAll(new Task(1, "learn javafx", "High", 75),
                new Task(2, "learn more", "Medium", 55));



    }
}
