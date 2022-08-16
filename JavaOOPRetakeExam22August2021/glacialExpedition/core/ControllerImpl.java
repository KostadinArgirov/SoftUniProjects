package glacialExpedition.core;

import glacialExpedition.models.explorers.*;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static glacialExpedition.common.ConstantMessages.*;
import static glacialExpedition.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private ExplorerRepository explorerRepository;
    private StateRepository stateRepository;
    private int exploredStates;

    public ControllerImpl() {
        explorerRepository = new ExplorerRepository();
        stateRepository = new StateRepository();
        exploredStates = 0;
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;
        switch (type) {
            case "AnimalExplorer":
                explorer = new AnimalExplorer(explorerName);
                break;
            case "GlacierExplorer":
                explorer = new GlacierExplorer(explorerName);
                break;
            case "NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;
            default:
                throw new IllegalArgumentException(EXPLORER_INVALID_TYPE);
        }
        explorerRepository.add(explorer);
        return String.format(EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
//        for (String exhibitToBeAdded : exhibits) {
//            state.getExhibits().add(exhibitToBeAdded);
//        }
        Collections.addAll(state.getExhibits(), exhibits);
        stateRepository.add(state);
        return String.format(STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorerToRemove = explorerRepository.byName(explorerName);
        if (explorerToRemove == null) {
            throw new IllegalArgumentException(String.format(EXPLORER_DOES_NOT_EXIST, explorerName));
        }
        explorerRepository.remove(explorerToRemove);
        return String.format(EXPLORER_RETIRED, explorerName);

    }

    @Override
    public String exploreState(String stateName) {
        //Само изследователи със сила > 50
        List<Explorer> validExplorers = explorerRepository
                .getCollection()
                .stream()
                .filter(e -> e.getEnergy() > 50)
                .collect(Collectors.toList());

        //Ако няма никой -> exception
        if (validExplorers.isEmpty()) {
            throw new IllegalArgumentException(STATE_EXPLORERS_DOES_NOT_EXISTS);
        }
        //Стартираме експедицията
        State stateToExplore = stateRepository.byName(stateName);
        Mission mission = new MissionImpl();
        mission.explore(stateToExplore, validExplorers);
        //Брой изследователи със сила = 0
        long countOfTiredExplorers = validExplorers.stream().filter(e -> e.getEnergy() == 0).count();
        exploredStates++;
        return String.format(STATE_EXPLORER, stateName, countOfTiredExplorers);
    }

    @Override
    public String finalResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(FINAL_STATE_EXPLORED, exploredStates));
        sb.append(System.lineSeparator());
        sb.append(FINAL_EXPLORER_INFO);
        sb.append(System.lineSeparator());
        sb.append(explorerRepository.toString());
        return sb.toString().trim();
    }


}