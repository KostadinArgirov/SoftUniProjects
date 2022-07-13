package oop.polymorphismExercises.vehiclesExtension;

public class Car extends Vehicle {
    private static final Double ADDITIONAL_AC_CONSUMPTION = 0.9;

    public Car(Double fuel, Double consumptionLitersPerKm, Double tankCapacity) {
        super(fuel, consumptionLitersPerKm, tankCapacity);
    }

    @Override
    protected Double getConditionerConsumptionCoefficient() {

        return ADDITIONAL_AC_CONSUMPTION;
    }
}