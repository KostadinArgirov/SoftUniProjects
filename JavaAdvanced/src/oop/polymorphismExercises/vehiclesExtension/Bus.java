package oop.polymorphismExercises.vehiclesExtension;

public class Bus extends Vehicle {
    private static final Double ADDITIONAL_AC_CONSUMPTION = 1.4;

    private boolean isEmpty;

    public Bus(Double fuel, Double consumptionLitersPerKm, Double tankCapacity) {
        super(fuel, consumptionLitersPerKm, tankCapacity);
    }

    @Override
    protected Double getConditionerConsumptionCoefficient() {
        return this.isEmpty ? 0 : ADDITIONAL_AC_CONSUMPTION;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}