package ca.uqam.info.solanum.students.halma.model;

import ca.uqam.info.solanum.inf2050.f24halma.model.Board;
import ca.uqam.info.solanum.inf2050.f24halma.model.Field;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The type Board.
 */
public class BoardImpl implements Board {
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BoardImpl board = (BoardImpl) o;
        return baseSize == board.baseSize && Objects.equals(getAllFields(), board.getAllFields()) && Objects.equals(homeFields, board.homeFields) && Objects.equals(targetFields, board.targetFields) && Objects.deepEquals(playerNames, board.playerNames);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    /**
     * The All fields.
     */
    final Set<Field> allFields = new HashSet<>();
    /**
     * The Home fields.
     */
    final Set<Field> homeFields = new HashSet<>();
    /**
     * The Target fields.
     */
    final Set<Field> targetFields = new HashSet<>();

    private final int baseSize;
    private final String[] playerNames;

    /**
     * Instantiates a new Board.
     *
     * @param baseSize    the base size
     * @param playerNames the player names
     */
    public BoardImpl(int baseSize, String[] playerNames) {
        this.baseSize = baseSize;
        this.playerNames = playerNames;
    }


    @Override
    public Set<Field> getAllFields() {
        //Grand triangle qui pointe vers la droite
        int xStartingPos = baseSize;
        int yStartingPos = 0;
        int nbFields = (6 * baseSize) + 1;

        while (xStartingPos <= baseSize * 4) {
            for (int i = 0; i <= nbFields; i+=2) {
                allFields.add(new Field(xStartingPos, i + yStartingPos));
            }
            xStartingPos++;
            yStartingPos++;
            nbFields-= 2;
        }

        //Grand triangle qui pointe vers la gauche
        xStartingPos = baseSize * 3;
        yStartingPos = 0;
        nbFields = (6 * baseSize) + 1;

        while (xStartingPos >= 0) {
            for (int i = 0; i <= nbFields; i+=2) {
                allFields.add(new Field(xStartingPos, i + yStartingPos));
            }
            xStartingPos--;
            yStartingPos++;
            nbFields-= 2;
        }

        return Collections.unmodifiableSet(allFields);
    }

    @Override
    public Set<Field> getHomeFieldsForPlayer(int i) {
        if (i == 0) {
            return Set.of( new Field(0, baseSize* 3));
        }
        else if (i == 1) {
            return Set.of( new Field(baseSize * 3, 0));
        }
        else if (i == 2){
            return Set.of( new Field(baseSize * 3, baseSize * 6));
        }
        else if (i == 3) {
            return Set.of( new Field(baseSize * 4, baseSize * 3));
        }
        else  if (i == 4) {
            return Set.of( new Field(baseSize, baseSize * 6));
        }
        else  if (i == 5) {
            return Set.of( new Field(0, baseSize));
        }

        return Set.of();

    }


    @Override
    public Set<Field> getAllHomeFields() {

        //Case home fields à droite
        int xStartingPos = baseSize;
        int yStartingPos = 0;
        int nbFields = (6 * baseSize) + 1;

        while (xStartingPos <= baseSize * 4) {
            for (int i = 0; i <= nbFields; i+=2) {
                if (xStartingPos + baseSize > baseSize * 4) {
                    homeFields.add(new Field(xStartingPos, i + yStartingPos));
                }
            }
            xStartingPos++;
            yStartingPos++;
            nbFields-= 2;
        }

        //Case home fields à gauche
        xStartingPos = baseSize * 3;
        yStartingPos = 0;
        nbFields = (6 * baseSize) + 1;

        while (xStartingPos >= 0) {
            for (int i = 0; i <= nbFields; i+=2) {
                //Case home fields à gauche
                if (xStartingPos - baseSize < 0) {
                    homeFields.add(new Field(xStartingPos, i + yStartingPos));
                }
            }
            xStartingPos--;
            yStartingPos++;
            nbFields-= 2;
        }

        //Petit triangle en bas à droite
        xStartingPos = baseSize * 3;
        yStartingPos = (baseSize * 6) - (baseSize - 1) * 2;

        //Formule pour le nombre total de case
        //Source : https://math.stackexchange.com/a/593320
        double nbFields2 = (double) (baseSize * (baseSize)) /2;

        while (xStartingPos >= 0) {
            for (int i = 0; i <= nbFields2; i+=2) {
                homeFields.add(new Field(xStartingPos, i + yStartingPos));
            }
            xStartingPos--;
            yStartingPos++;
            nbFields2-= 2;
        }

        //Petit triangle en bas à gauche
        xStartingPos = baseSize;
        yStartingPos = (baseSize * 6) - (baseSize - 1) * 2;

        //Formule pour le nombre total de case
        //Source : https://math.stackexchange.com/a/593320
        double nbFields3 = (double) (baseSize * (baseSize)) /2;

        while (xStartingPos <= baseSize * 4) {
            for (int i = 0; i <= nbFields3; i+=2) {
                homeFields.add(new Field(xStartingPos, i + yStartingPos));
            }
            xStartingPos++;
            yStartingPos++;
            nbFields3-= 2;
        }

        //Petit triangle en haut à gauche
        xStartingPos = baseSize;
        yStartingPos = (baseSize * 2) - 2;

        //Formule pour le nombre total de case
        //Source : https://math.stackexchange.com/a/593320
        double nbFields4 = (double) (baseSize * (baseSize)) /2;

        while (xStartingPos < baseSize *2 ) {
            for (int i = 0; i <= nbFields4; i+=2) {
                homeFields.add(new Field(xStartingPos, yStartingPos - i));
            }
            xStartingPos++;
            yStartingPos--;
            nbFields4-= 2;
        }

        //Petit triangle en haut à droite
        xStartingPos = baseSize * 3;
        yStartingPos = (baseSize * 2) - 2;

        //Formule pour le nombre total de case
        //Source : https://math.stackexchange.com/a/593320
        double nbFields5 = (double) (baseSize * (baseSize)) /2;

        while (xStartingPos > baseSize *2 ) {
            for (int i = 0; i <= nbFields5; i+=2) {
                homeFields.add(new Field(xStartingPos, yStartingPos - i));
            }
            xStartingPos--;
            yStartingPos--;
            nbFields5-= 2;
        }
        return Collections.unmodifiableSet(homeFields);
    }

    @Override
    public Set<Field> getTargetFieldsForPlayer(int index) {
        //TODO
        int xStartingPos;
        int yStartingPos;
        int nbFields;

        if (index == 0) {
            //Case target fields à droite

            xStartingPos = baseSize;
            yStartingPos = 0;
            nbFields = (6 * baseSize) + 1;

            while (xStartingPos <= baseSize * 4) {
                for (int i = 0; i <= nbFields; i+=2) {
                    if (xStartingPos + baseSize > baseSize * 4) {
                        targetFields.add(new Field(xStartingPos, i + yStartingPos));
                    }
                }
                xStartingPos++;
                yStartingPos++;
                nbFields-= 2;
            }

        }
        else if (index == 1) {
            //Petit triangle en bas à gauche
            xStartingPos = baseSize;
            yStartingPos = (baseSize * 6) - (baseSize - 1) * 2; //This is good
            double nbFields3 = (double) (baseSize * (baseSize)) /2;

            while (xStartingPos <= baseSize * 4) {
                for (int i = 0; i <= nbFields3; i+=2) {
                    targetFields.add(new Field(xStartingPos, i + yStartingPos));
                }
                xStartingPos++;
                yStartingPos++;
                nbFields3-= 2;
            }
        }
        else if (index == 2) {
            //Petit triangle en haut à gauche
            xStartingPos = baseSize;
            yStartingPos = (baseSize * 2) - 2; //This is good
            double nbFields4 = (double) (baseSize * (baseSize)) /2;

            while (xStartingPos < baseSize *2 ) {
                for (int i = 0; i <= nbFields4; i+=2) {
                    targetFields.add(new Field(xStartingPos, yStartingPos - i));
                }
                xStartingPos++;
                yStartingPos--;
                nbFields4-= 2;
            }
        }
        else if (index == 3) {
            //Petit triangle en bas à droite
            xStartingPos = baseSize * 3;
            yStartingPos = (baseSize * 6) - (baseSize - 1) * 2;
            double nbFields2 = (double) (baseSize * (baseSize)) /2;

            while (xStartingPos >= 0) {
                for (int i = 0; i <= nbFields2; i+=2) {
                    targetFields.add(new Field(xStartingPos, i + yStartingPos));
                }
                xStartingPos--;
                yStartingPos++;
                nbFields2-= 2;
            }
        }
        else if (index == 4) {
            xStartingPos = baseSize * 3;
            yStartingPos = (baseSize * 2) - 2; //This is good
            double nbFields5 = (double) (baseSize * (baseSize)) /2;

            while (xStartingPos > baseSize *2 ) {
                for (int i = 0; i <= nbFields5; i+=2) {
                    targetFields.add(new Field(xStartingPos, yStartingPos - i));
                }
                xStartingPos--;
                yStartingPos--;
                nbFields5-= 2;
            }
        }
        else if (index == 5) {
            //Case home fields à gauche
            xStartingPos = baseSize * 3;
            yStartingPos = 0;
            nbFields = (6 * baseSize) + 1;

            while (xStartingPos >= 0) {
                for (int i = 0; i <= nbFields; i+=2) {
                    //Case home fields à gauche
                    if (xStartingPos - baseSize < 0) {
                        targetFields.add(new Field(xStartingPos, i + yStartingPos));
                    }
                }
                xStartingPos--;
                yStartingPos++;
                nbFields-= 2;
            }
        }
        return Collections.unmodifiableSet(targetFields);
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