package ca.uqam.info.solanum.students.halma.model;

import ca.uqam.info.solanum.inf2050.f24halma.model.Board;
import ca.uqam.info.solanum.inf2050.f24halma.model.Field;
import ca.uqam.info.solanum.inf2050.f24halma.model.FieldException;
import ca.uqam.info.solanum.inf2050.f24halma.model.Model;

import java.util.HashSet;
import java.util.Set;

public class ModelImpl implements Model {

    private final String[] playerNames;
    private final Board board;
    private int currentPlayer;

    public ModelImpl(int baseSize, String[] playerNames) throws Exception {
        this.playerNames = playerNames;
        this.board = new BoardImpl(baseSize);
        this.currentPlayer = 0;
    }

    @Override
    public String[] getPlayerNames() {
        return playerNames.clone();
    }

    @Override
    public Set<Field> getPlayerFields(int playerIndex) {
        return new HashSet<>();
    }

    @Override
    public int getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public Board getBoard() {
        return board;
    }

    @Override
    public boolean isClear(Field field) throws FieldException {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public void occupyField(int playerIndex, Field field) throws FieldException {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public void clearField(Field field) throws FieldException {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public void setCurrentPlayer(int playerIndex) {
        throw new RuntimeException("Not yet implemented");
    }
}
