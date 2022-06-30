package advanced.exam.workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Workout {
    private List<Exercise> exercises;
    private String type;
    private int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.exercises = new ArrayList<>();
        this.type = type;
        this.exerciseCount = exerciseCount;
    }

    public void addExercise(Exercise exercise) {
        if (this.exercises.size() < this.exerciseCount) {
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        return exercises.removeIf(e -> e.getName().equals(name) && e.getMuscle().equals(muscle));
    }

    public Exercise getExercise(String name, String muscle) {
        return exercises.stream()
                .filter(e -> e.getName().equals(name) && e.getMuscle().equals(muscle))
                .findFirst()
                .orElse(null);
    }

    public Exercise getMostBurnedCaloriesExercise() {
        return exercises.stream()
                .sorted(Comparator.comparingInt(Exercise::getBurnedCalories).reversed())
                .findFirst()
                .orElse(null);
    }

    public int getExerciseCount() {
        return this.exercises.size();
    }

    public String getStatistics() {
        return "Workout type: " + this.type + System.lineSeparator() +
                this.exercises.stream()
                        .map(Exercise::toString)
                        .collect(Collectors.joining(System.lineSeparator()));
    }
}