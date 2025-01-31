package ca.uqam.info.solanum.students.halma.controller;

import ca.uqam.info.solanum.inf2050.f24halma.controller.ModelFactory;
import ca.uqam.info.solanum.inf2050.f24halma.model.Model;
import ca.uqam.info.solanum.inf2050.f24halma.model.ModelReadOnly;
import ca.uqam.info.solanum.students.halma.model.ModelImpl;

public class ModelFactoryImpl implements ModelFactory {

    private final int baseSize;
    private final String[] playerNames;

    public ModelFactoryImpl(int baseSize, String[] playerNames) {
        this.baseSize = baseSize;
        this.playerNames = playerNames;
    }

    @Override
    public Model createModel(int baseSize, String[] playerNames) {
        // Initialise le modèle de jeu
        try {
            return new ModelImpl(baseSize, playerNames);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
