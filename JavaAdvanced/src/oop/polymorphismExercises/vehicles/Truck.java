package oop.polymorphismExercises.vehicles;

public class Truck extends Vehicle {
    private static final Double ADDITIONAL_AC_CONSUMPTION = 1.6;
    private static final Double FUEl_LEAK_CORRECTION_PERCENTAGE = 0.95;

    public Truck(Double fuel, Double consumptionLitersPerKm) {
        super(fuel, consumptionLitersPerKm);
    }

    @Override
    protected Double getConditionerConsumptionCoefficient() {
        return ADDITIONAL_AC_CONSUMPTION;
    }


    @Override
    public void refuel(double loadedFuel) {
        this.setFuel(this.getFuel() + loadedFuel * FUEl_LEAK_CORRECTION_PERCENTAGE);
    }
}