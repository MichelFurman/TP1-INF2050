package ca.uqam.info.solanum.students.halma.controller;

import ca.uqam.info.solanum.inf2050.f24halma.controller.ModelFactory;
import ca.uqam.info.solanum.inf2050.f24halma.model.Model;
import ca.uqam.info.solanum.inf2050.f24halma.model.ModelReadOnly;
import ca.uqam.info.solanum.students.halma.model.ModelImpl;

public class ModelFactoryImpl implements ca.uqam.info.solanum.inf2050.f24halma.controller.ModelFactory {

    int baseSize;
    String[] nomJoueurs;

    public ModelFactoryImpl(int baseSize, String[] nomJoueurs) {
        super();
        this.baseSize = baseSize;
        this.nomJoueurs = nomJoueurs;
    }

    @Override
    public Model createModel(int baseSize, String[] nomJoueurs) {
        //TODO: Ceci sont les parametres du jeu. Un peu comme si on choisissait facile, moyen ou dificile, mais ici
        // c'est le nombre de joueurs et la grandeur du triangle
        return new ModelImpl();
    }
}
