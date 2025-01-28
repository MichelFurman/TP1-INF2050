package ca.uqam.info.solanum.students.halma.model;

import ca.uqam.info.solanum.inf2050.f24halma.model.Board;
import ca.uqam.info.solanum.inf2050.f24halma.model.Field;
import ca.uqam.info.solanum.inf2050.f24halma.model.FieldException;
import ca.uqam.info.solanum.inf2050.f24halma.model.Model;

import java.util.Set;

abstract class ModelImpl implements Model {

    @Override
    public String[] getPlayerNames() {
        return new String[0];
    }

    @Override
    public Set<Field> getPlayerFields(int i) {
        return Set.of();
    }

    @Override
    public int getCurrentPlayer() {
        return 0;
    }

    @Override
    public Board getBoard() {
        return null;
    }

    @Override
    public boolean isClear(Field field) throws FieldException {
        return false;
    }

    @Override
    public void occupyField(int i, Field field) throws FieldException {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public void clearField(Field field) throws FieldException {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public void setCurrentPlayer(int i) {
        throw new RuntimeException("Not yet implemented");
    }
}