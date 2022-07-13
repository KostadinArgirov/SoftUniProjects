package oop.polymorphismExercises.vehiclesExtension;

public class Truck extends Vehicle {
    private static final Double ADDITIONAL_AC_CONSUMPTION = 1.6;
    private static final Double FUEL_LEAK_CORRECTION_PERCENTAGE = 0.95;

    public Truck(Double fuel, Double consumptionLitersPerKm, Double tankCapacity) {
        super(fuel, consumptionLitersPerKm, tankCapacity);
    }

    @Override
    protected Double getConditionerConsumptionCoefficient() {
        return ADDITIONAL_AC_CONSUMPTION;
    }


    @Override
    public void refuel(double loadedFuel) {
        super.refuel(loadedFuel * FUEL_LEAK_CORRECTION_PERCENTAGE);
    }
}