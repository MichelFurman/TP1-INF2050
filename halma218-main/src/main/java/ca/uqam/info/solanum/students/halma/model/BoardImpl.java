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


    public BoardImpl(int baseSize) throws Exception {

        generateStarShapeBoard(baseSize);
    }

    public void generateStarShapeBoard(int baseSize) throws Exception {

        baseSize = 2;

        if (baseSize < 1) {
            throw new Exception("La taille du plateau halma doit être plus grand que 0");
        }

        // Triangle du haut
        for (int y = 0; y <= baseSize * 3; y++) {
            for (int x = 0; x <= y; x++) {
                if ((x + y) % 2 == 0) {
                    allFields.add(new Field(x + baseSize, y));
                }
            }
        }

        // Triangle du bas
        for (int y = baseSize * 3 + 1; y <= baseSize * 6; y++) {
            for (int x = 0; x <= (baseSize * 6 - y); x++) {
                if ((x + y) % 2 == 0) {
                    allFields.add(new Field(x + baseSize, y));
                }
            }
        }
    }






    @Override
    public Set<Field> getAllFields() {
        return allFields;
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