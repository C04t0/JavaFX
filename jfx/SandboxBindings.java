package jfx;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.*;

public class SandboxBindings {
    public static void main(String[]args) {

        // Uni-directional bind (vloeit maar in 1 richting)
        // (lastNameProp -> surNameProp)

        StringProperty lastNameProp = new SimpleStringProperty();
        StringProperty surNameProp = new SimpleStringProperty();

        /*
        surNameProp.bind(lastNameProp); // Uni-directional bind
        lastNameProp.set("Patrick");
        System.out.println(surNameProp.get());
        */

        //Bi-directional bind (veranderingen vloeien in beide richtingen)
        // (lastNameProp <-> surNameProp)

        surNameProp.bindBidirectional(lastNameProp); //Bi-directional bind
        lastNameProp.set("Patrick");
        System.out.println(surNameProp.get());
        surNameProp.set("Francois");
        System.out.println(lastNameProp.get());

        StringProperty fullName = new SimpleStringProperty();
        StringProperty firstName = new SimpleStringProperty("Niels");
        StringProperty lastName = new SimpleStringProperty("De groot");

        fullName.bind(Bindings.concat(firstName, " ", lastName));   //Uni-directional

        firstName.set("Nielsken de zot");
        System.out.println(fullName.get());

        IntegerProperty length = new SimpleIntegerProperty(18);
        IntegerProperty width = new SimpleIntegerProperty(13);
        IntegerProperty area = new SimpleIntegerProperty();

        //High level binding

        area.bind(length.multiply(width));          //Uni-directional

        NumberBinding perimeter = length.add(width).multiply(2);

        System.out.println(area.get());

        //Low level binding
        //NumberBinding is de parent van DoubleBinding, IntegerBinding, etc ..

        DoubleProperty radius = new SimpleDoubleProperty(1.5);

        DoubleBinding volumeBinding = new DoubleBinding() {
            {
                super.bind(radius);     //bevat geen eigen bind()-methode dus haal je ze uit NumberBinding.
            }
            @Override
            protected double computeValue() {
                return (4/3 * Math.PI * Math.pow(radius.get(), 3));
            }
        };
        System.out.println(volumeBinding.get());
    }
}
