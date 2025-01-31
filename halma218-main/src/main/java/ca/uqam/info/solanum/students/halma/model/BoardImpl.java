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

        /**
         * L'étoile est composée de 2 triangles équilatéraux qui se croisent.
         * Ils sont générés à partir de 2 positions différentes (basesize et basesize*3).
         */
        baseSize = 2;
        //Erreur si la taille de la surface de jeu est plus petite que 1.
        if (baseSize < 1) {
            throw new Exception("La taille du plateau halma doit être plus grand que 0");
        }

        //Triangle qui pointe vers la droite
        int xStartingPos1 = baseSize;
        int yStartingPos1 = 0;
        int nbFields = (6 * baseSize) + 1;

        while (xStartingPos1 <= baseSize * 4) {
            for (int i = 0; i <= nbFields; i+=2) {
                allFields.add(new Field(xStartingPos1, i + yStartingPos1));

                if (xStartingPos1 + baseSize > baseSize * 4) {
                    homeFields.add(new Field(xStartingPos1, i + yStartingPos1));
                }
                


            }
            xStartingPos1++;
            yStartingPos1++;
            nbFields-= 2;
        }

        //Triangle qui pointe vers la gauche
        int xStartingPos2 = baseSize * 3;
        int yStartingPos2 = 0;
        int nbFields2 = (6 * baseSize) + 1;

        while (xStartingPos2 >= 0) {
            for (int i = 0; i <= nbFields2; i+=2) {
                allFields.add(new Field(xStartingPos2, i + yStartingPos2));

                if (xStartingPos2 - baseSize < 0) {
                    homeFields.add(new Field(xStartingPos2, i + yStartingPos2));
                }
            }


            xStartingPos2--;
            yStartingPos2++;
            nbFields2-= 2;
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
        return homeFields;
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