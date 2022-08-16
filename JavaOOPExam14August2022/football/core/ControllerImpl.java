package football.core;


import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static football.common.ConstantMessages.*;
import static football.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private SupplementRepository supplements;
    private Collection<Field> fields;

    public ControllerImpl() {
        this.supplements = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }


    @Override
    public String addField(String fieldType, String fieldName) {

        Field field;

        switch (fieldType) {
            case "ArtificialTurf":
                field = new ArtificialTurf(fieldName);
                break;
            case "NaturalGrass":
                field = new NaturalGrass(fieldName);
                break;
            default:
                throw new NullPointerException(INVALID_FIELD_TYPE);
        }

        fields.add(field);

        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement supplement = null;

        switch (type) {
            case "Liquid":
                supplement = new Liquid();
                break;
            case "Powdered":
                supplement = new Powdered();
                break;
            default:
                throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }

        supplements.add(supplement);

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {

        Supplement supplement = supplements.findByType(supplementType);

        if (supplement == null) {
            throw new NullPointerException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }

        Field field = getField(fieldName);
        field.addSupplement(supplement);
        supplements.remove(supplement);

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    private Field getField(String fieldName) {
        return fields.stream().filter(f -> f.getName().equals(fieldName)).findFirst().orElse(null);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player player = null;
        switch (playerType) {
            case "Women":
                player = new Women(playerName, nationality, strength);
                break;
            case "Men":
                player = new Men(playerName, nationality, strength);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }

        Field field = getField(fieldName);

        if ((field.getClass().getSimpleName().equals("ArtificialTurf") && playerType.equals("Men")) ||
                (field.getClass().getSimpleName().equals("NaturalGrass") && playerType.equals("Women"))) {
            return FIELD_NOT_SUITABLE;
        }

        field.addPlayer(player);

        return String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
    }

    @Override
    public String dragPlayer(String fieldName) {
        Field field = getField(fieldName);
        field.drag();
        int playersCount = field.getPlayers().size();

        return String.format(PLAYER_DRAG, playersCount);
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field field = getField(fieldName);
        int allPlayersStrength = field.getPlayers().stream().mapToInt(Player::getStrength).sum();

        return String.format(STRENGTH_FIELD, fieldName, allPlayersStrength);
    }

    @Override
    public String getStatistics() {
        return fields.stream().map(Field::getInfo).collect(Collectors.joining(System.lineSeparator()));

    }
}