package advanced.examPreparation.guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.roster = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public List<Player> getRoster() {
        return roster;
    }

    public void setRoster(List<Player> roster) {
        this.roster = roster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        return this.roster.removeIf(p -> p.getName().equals(name));
    }

    public void promotePlayer(String name) {
        Player player = this.roster.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);

        if (player != null && !player.getRank().equals("Member")) {
            player.setRank("Member");
        }
    }

    public void demotePlayer(String name) {
        Player player = this.roster.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);

        if (player != null && !player.getRank().equals("Trial")) {
            player.setRank("Trial");
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> playersToRemove = this.roster.stream().filter(p -> p.getClazz().equals(clazz)).collect(Collectors.toList());

        this.roster.removeAll(playersToRemove);
        return playersToRemove.toArray(Player[]::new);
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        return "Players in the examPreparation.guild: " + getName() + ":" + System.lineSeparator() +
                this.roster.stream()
                        .map(Player::toString)
                        .collect(Collectors.joining(System.lineSeparator()));
    }
}