package oop.polymorphismExercises.vehicles;

public class Car extends Vehicle {
    private static final Double ADDITIONAL_AC_CONSUMPTION = 0.9;

    public Car(Double fuel, Double consumptionLitersPerKm) {
        super(fuel, consumptionLitersPerKm);
    }

    @Override
    protected Double getConditionerConsumptionCoefficient() {
        return ADDITIONAL_AC_CONSUMPTION;
    }

    @Override
    public void refuel(double loadedFuel) {
        this.setFuel(this.getFuel() + loadedFuel);
    }
}