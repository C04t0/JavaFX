package jfx;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


public class Listeners {

    public static void main(String[]argStrings) {

        //simple properties

        SimpleIntegerProperty intProp = new SimpleIntegerProperty();
        intProp.set(10);
        System.out.println(intProp.get());

        SimpleStringProperty stringProp = new SimpleStringProperty("Initial value");
        System.out.println(stringProp.get());

        //read-only properties

        ReadOnlyBooleanWrapper readOnlyBooleanWrapper = new ReadOnlyBooleanWrapper(true);
        ReadOnlyBooleanProperty readOnlyBooleanProperty = readOnlyBooleanWrapper.getReadOnlyProperty();

        //listeners luisteren naar activiteit op de variabele

        intProp.addListener(new ChangeListener<Number>() {

            @Override           //Override van de methode changed -- Listener1
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("listener 1 : Integer property is changed to " + newValue);
                System.out.println("Old value was: " + oldValue);
                System.out.println(observable);
            }
        });

        intProp.set(15);
        intProp.set(100);

        intProp.addListener(new ChangeListener<Number>() {

            @Override           //Override methode changed -- Listener2
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("listener 2 : Integer property is changed to " + newValue);
                System.out.println("Old value was: " + oldValue);
                System.out.println(observable);
            }
        });

        intProp.addListener(new InvalidationListener() {

            @Override           //Override methode invalidated; wordt altijd uitgevoerd voor changelisteners.
            public void invalidated(Observable observable) {
                System.out.println("!-> intProp changed. <-!");
            }
        });

        intProp.set(150);
    }
}
