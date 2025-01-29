package ca.uqam.info.solanum.students.halma.model;

import ca.uqam.info.solanum.inf2050.f24halma.model.Board;
import ca.uqam.info.solanum.inf2050.f24halma.model.Field;

import java.util.HashSet;
import java.util.Set;

class BoardImpl implements Board {

    //Ces HashSet de type Field vont contenir les poisitions pour chaque type de case
    //Field ne contient que X et Y dans le constructeur, soit Field(int x, int y)
    //Mettre privee????
    final Set<Field> allFields = new HashSet<>();
    final Set<Field> homeFields = new HashSet<>();
    final Set<Field> targetFields = new HashSet<>();


    public BoardImpl(int baseSize) {
        generateStarShapeBoard(baseSize);
    }

    public void generateStarShapeBoard(int baseSize) {
        //TODO: Ici on va creer le board en forme de etoile selon la taille
    }

    @Override
    public Set<Field> getAllFields() {
        return Set.of();
    }

    @Override
    public Set<Field> getHomeFieldsForPlayer(int i) {
        return Set.of();
    }

    @Override
    public Set<Field> getAllHomeFields() {
        return Set.of();
    }

    @Override
    public Set<Field> getTargetFieldsForPlayer(int i) {
        return Set.of();
    }

    @Override
    public Set<Field> getNeighbours(Field field) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public Field getExtendedNeighbour(Field field, Field field1) {
        throw new RuntimeException("Not yet implemented");
    }
}