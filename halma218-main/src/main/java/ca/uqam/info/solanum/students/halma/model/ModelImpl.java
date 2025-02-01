package ca.uqam.info.solanum.students.halma.model;

import ca.uqam.info.solanum.inf2050.f24halma.model.Board;
import ca.uqam.info.solanum.inf2050.f24halma.model.Field;
import ca.uqam.info.solanum.inf2050.f24halma.model.FieldException;
import ca.uqam.info.solanum.inf2050.f24halma.model.Model;

import java.util.Objects;
import java.util.Set;

/**
 * The type Model.
 */
public class ModelImpl implements Model {

    private final String[] playerNames;
    private final Board board;
    private int currentPlayer = 0;
    private final int baseSize;

    /**
     * Instantiates a new Model.
     *
     * @param baseSize    the base size
     * @param playerNames the player names
     */
    public ModelImpl(int baseSize, String[] playerNames) {
        this.playerNames = playerNames;
        this.board = new BoardImpl(baseSize, getPlayerNames());
        this.baseSize = baseSize;
        this.currentPlayer = 0;
    }


    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ModelImpl model = (ModelImpl) o;
        return getCurrentPlayer() == model.getCurrentPlayer() && Objects.deepEquals(getPlayerNames(), model.getPlayerNames()) && Objects.equals(getBoard(), model.getBoard());
    }

    @Override
    public String[] getPlayerNames() {
        return playerNames;
    }

    @Override
    public Set<Field> getPlayerFields(int playerIndex) {

        if (playerIndex == 0) {
            return Set.of( new Field(0, baseSize* 3));
        }
        else if (playerIndex == 1) {
            return Set.of( new Field(baseSize * 3, 0));
        }
        else if (playerIndex == 2){
            return Set.of( new Field(baseSize * 3, baseSize * 6));
        }
        else if (playerIndex == 3) {
            return Set.of( new Field(baseSize * 4, baseSize * 3));
        }
        else  if (playerIndex == 4) {
            return Set.of( new Field(baseSize, baseSize * 6));
        }
        else  if (playerIndex == 5) {
            return Set.of( new Field(0, baseSize));
        }

        return Set.of();
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
