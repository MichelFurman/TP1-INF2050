package ca.uqam.info.solanum.students.halma.model;

import ca.uqam.info.solanum.inf2050.f24halma.model.Board;
import ca.uqam.info.solanum.inf2050.f24halma.model.Field;
import com.sun.source.tree.WhileLoopTree;

import java.util.HashSet;
import java.util.Set;

class BoardImpl implements Board {

    //Ces HashSet de type Field vont contenir les positions pour chaque type de case
    //Field ne contient que X et Y dans le constructeur, soit Field(int x, int y)
    //Mettre privee????
    final Set<Field> allFields = new HashSet<>();
    final Set<Field> homeFields = new HashSet<>();
    final Set<Field> targetFields = new HashSet<>();


    public BoardImpl(int baseSize) throws Exception {

        System.out.println("OK");
        generateStarShapeBoard(baseSize);
    }

    public void generateStarShapeBoard(int baseSize) throws Exception {

        /**
         * Pour générer le field, l'étoile est composée de 2 triangles équilatéraux qui se croisent.
         * Ils sont générés à partir de 2 positions différentes (basesize et basesize*3).
         */
       

        //Erreur si la taille de la surface de jeu est plus petite que 1.
        if (baseSize < 1) {
            throw new Exception("La taille du plateau halma doit être plus grand que 0");
        }

        //Triangle qui pointe vers la droite
        int xStartingPos = baseSize;
        int yStartingPos = 0;
        int nbFields = (6 * baseSize) + 1;

        while (xStartingPos <= baseSize * 4) {
            for (int i = 0; i <= nbFields; i+=2) {
                allFields.add(new Field(xStartingPos, i + yStartingPos));

                if (xStartingPos + baseSize > baseSize * 4) {
                    homeFields.add(new Field(xStartingPos, i + yStartingPos));
                }
            }
            xStartingPos++;
            yStartingPos++;
            nbFields-= 2;
        }

        //Triangle qui pointe vers la gauche
        xStartingPos = baseSize * 3;
        yStartingPos = 0;
        nbFields = (6 * baseSize) + 1;

        while (xStartingPos >= 0) {
            for (int i = 0; i <= nbFields; i+=2) {
                allFields.add(new Field(xStartingPos, i + yStartingPos));

                if (xStartingPos - baseSize < 0) {
                    homeFields.add(new Field(xStartingPos, i + yStartingPos));
                }
            }
            xStartingPos--;
            yStartingPos++;
            nbFields-= 2;
        }


        //Upper Left small triangle
        xStartingPos = baseSize * 3;
        yStartingPos = 0;
        double nbFields1 = (double) (baseSize * (baseSize)) /2;

        while (xStartingPos >= 0) {
            for (int i = 0; i <= nbFields1; i+=2) {
                homeFields.add(new Field(xStartingPos, i + yStartingPos));
            }
            xStartingPos--;
            yStartingPos++;
            nbFields1-= 2;
        }

        //Lower right small triangle
        xStartingPos = baseSize * 3;
        yStartingPos = (baseSize * 6) - (baseSize - 1) * 2;
        double nbFields2 = (double) (baseSize * (baseSize)) /2;

        while (xStartingPos >= 0) {
            for (int i = 0; i <= nbFields2; i+=2) {
                homeFields.add(new Field(xStartingPos, i + yStartingPos));
            }
            xStartingPos--;
            yStartingPos++;
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