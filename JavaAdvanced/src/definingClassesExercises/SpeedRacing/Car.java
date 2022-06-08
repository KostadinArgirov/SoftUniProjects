package definingClassesExercises.SpeedRacing;

public class Car {

    private String model;
    private double fuelAmount;
    private double fuelCostFor1Km;
    private double distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostFor1km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1Km = fuelCostFor1km;
        this.distanceTraveled = 0;
    }


    public boolean drive(Double km) {
        if (fuelAmount < km * fuelCostFor1Km) {
            return false;
        }
        fuelAmount -= km * fuelCostFor1Km;
        distanceTraveled += km;
        return true;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %.0f", this.model, this.fuelAmount, this.distanceTraveled);
    }
}