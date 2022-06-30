package advanced.definingClassesExercises.RawData;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tyre tyre;
    private List<Tyre> tyres;

    public Car(String model, Engine engine, Cargo cargo, List<Tyre> tyres) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tyres = new ArrayList<>();
        this.tyres.addAll(tyres);
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tyre getTyre() {
        return tyre;
    }

    public List<Tyre> getTyres() {
        return tyres;
    }
}