package OldUi;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Main extends Application{

public static void main(String[] args) {
            Application.launch();
        }
        @Override
        public void start(Stage stage) throws Exception {
    GridPane grid = new GridPane();
    grid.setGridLinesVisible(false);
    grid.setMinWidth(600);
    grid.setMinHeight(400);
    grid.setHgap(20);
    grid.setVgap(5);

// LABEL
    TableView tableArea = new TableView();
    tableArea.setMinWidth(550);
    tableArea.setMinHeight(300);
    GridPane.setConstraints(tableArea, 1, 1, 3, 1);

    TableColumn column1 = new TableColumn("Priority");
    TableColumn column2 = new TableColumn("Description");
    TableColumn column3 = new TableColumn("Progress");
    tableArea.getColumns().addAll(column1, column2, column3);

// TEXTFIELD
    TextField taskName = new TextField();
    taskName.setPromptText("Enter task name");
    taskName.setText("This is some default text");
    taskName.setMinWidth(300);
    GridPane.setConstraints(taskName, 2, 2);

// COMBOBOX
    ComboBox<String> priority = new ComboBox<>();
    priority.getItems().addAll("Low", "Medium", "High");
    priority.setPromptText("Enter priority");
    GridPane.setConstraints(priority, 1, 2);

// BUTTONS
    Button add = new Button("Add");
    add.setMinWidth(100);
    GridPane.setConstraints(add, 3, 2);

    Button cancel = new Button("Cancel");
    cancel.setMinWidth(100);
    GridPane.setConstraints(cancel, 3, 3);

// HBOX
    HBox progressArea = new HBox();
    progressArea.getChildren().addAll(
            new Label("Progress"),
            new Spinner<Integer>(0, 100, 0),
            new CheckBox("Completed")
            );
    progressArea.setAlignment(Pos.CENTER_RIGHT);
    progressArea.setSpacing(10);
    GridPane.setConstraints(progressArea, 1, 2, 3, 1);


    grid.getChildren().addAll(tableArea, taskName, priority, cancel, add);
    Scene scene = new Scene(grid, 600, 400);


    stage.setTitle("hallo JAVAFX");
    stage.setAlwaysOnTop(true);
    stage.setResizable(true);
    stage.setScene(scene);
    stage.show();

        }
    }