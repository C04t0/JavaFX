package jfx;


import javafx.beans.property.*;

public class Task {

    private StringProperty priority = new SimpleStringProperty();
    private StringProperty description = new SimpleStringProperty();
    private ObjectProperty<Integer> progress = new SimpleObjectProperty<>(0);
    private final ObjectProperty<Integer> id = new SimpleObjectProperty<>();

    public Task() {

    }

    public Task(Integer id, String description, String priority, Integer progress) {
        this.id.set(id);
        this.description.set(description);
        this.priority.set(priority);
        this.progress.set(progress);
    }

    //Getters en setters

    public Integer getId() {
        return id.get();
    }
    public ObjectProperty<Integer> idProperty() {
        return id;
    }
    public void setId(Integer id) {
        this.id.set(id);
    }

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
