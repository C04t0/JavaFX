package jfx;


import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Task {

    private StringProperty priority = new SimpleStringProperty();
    private StringProperty description = new SimpleStringProperty();
    private ObjectProperty<Integer> progress = new SimpleObjectProperty<>();





    //Getters en setters

    public String getPriority() {
        return priority.get();
    }
    public StringProperty priorityProperty() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority.set(priority);
    }
    public String getDescription() {
        return description.get();
    }
    public StringProperty descriptionProperty() {
        return description;
    }
    public void setDescription(String description) {
        this.description.set(description);
    }
    public Integer getProgress() {
        return progress.get();
    }
    public ObjectProperty<Integer> progressProperty() {
        return progress;
    }
    public void setProgress(Integer progress) {
        this.progress.set(progress);
    }
}
