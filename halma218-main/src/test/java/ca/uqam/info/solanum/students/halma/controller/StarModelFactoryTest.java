package ca.uqam.info.solanum.students.halma.controller;

import static org.junit.jupiter.api.Assertions.*;

import ca.uqam.info.solanum.inf2050.f24halma.model.Model;
import org.junit.jupiter.api.Test;
import ca.uqam.info.solanum.inf2050.f24halma.controller.ModelFactory;
import ca.uqam.info.solanum.students.halma.controller.ModelFactoryImpl;

class StarModelFactoryTest {

  @Test
  void testCreateModel() {
    String[] playerNames = {"Max", "Maram", "Roman"};
    ModelFactory factory = new ModelFactoryImpl(2, playerNames);

    // Test that the factory creates a valid model
    Model model = factory.createModel(2, playerNames);
    assertNotNull(model);
    assertArrayEquals(playerNames, model.getPlayerNames());
  }
}
