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
        int centerX = baseSize *2; //2
        int centerY = baseSize *3; //3

        for (int i = -baseSize*2; i <= baseSize*2; i+=2) {

            if (baseSize == 1) {
                allFields.add(new Field(centerX, centerY + i));
                allFields.add(new Field(centerX + i, centerY));
                allFields.add(new Field(centerX - (i/2), centerY - (i/2)));
                allFields.add(new Field(centerX + (i/2), centerY - (i/2)));
                allFields.add(new Field(centerX - (i/2), centerY + (i/2)));
                allFields.add(new Field(centerY, centerX - i));
                allFields.add(new Field(centerY, 6));
                allFields.add(new Field(1, 0));
                allFields.add(new Field(1, 6));
            }
            else {
                allFields.add(new Field(centerX, centerY + i));
                allFields.add(new Field(centerX + i, centerY));
                allFields.add(new Field(centerX - (i/2), centerY - (i/2)));
                allFields.add(new Field(centerX + (i/2), centerY - (i/2)));
                allFields.add(new Field(centerX - (i/2), centerY + (i/2)));
                allFields.add(new Field(centerY, centerX - i));
                allFields.add(new Field(centerY, centerX + i));
            }

            System.out.println(i);



        }

        //7,7 5;
        //allFields.add(new Field(3, 2));
        //allFields.add(new Field(1, 4));



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