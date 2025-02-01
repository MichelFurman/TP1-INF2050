package ca.uqam.info.solanum.students.halma.controller;

import ca.uqam.info.solanum.inf2050.f24halma.controller.ModelFactory;
import ca.uqam.info.solanum.inf2050.f24halma.model.Model;
import ca.uqam.info.solanum.inf2050.f24halma.model.ModelReadOnly;
import ca.uqam.info.solanum.students.halma.model.ModelImpl;

/**
 * The type Model factory.
 */
public class ModelFactoryImpl implements ModelFactory {
    @Override
    public Model createModel(int baseSize, String[] playerNames) {
        try {
            return new ModelImpl(baseSize, playerNames);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
