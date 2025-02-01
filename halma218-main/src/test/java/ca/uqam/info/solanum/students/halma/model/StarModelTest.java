package ca.uqam.info.solanum.students.halma.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ca.uqam.info.solanum.students.halma.model.ModelImpl;
import ca.uqam.info.solanum.inf2050.f24halma.model.Model;
import ca.uqam.info.solanum.inf2050.f24halma.model.Field;
import ca.uqam.info.solanum.students.halma.model.BoardImpl;

import java.util.Set;

class StarModelTest {

  @Test
  void testGetPlayerNames() throws Exception {
    String[] playerNames = {"Max", "Maram", "Roman"};
    Model model = new ModelImpl(2, playerNames);

    // Test that the player names are correctly returned
    assertArrayEquals(playerNames, model.getPlayerNames());
  }

  @Test
  void testGetBoard() throws Exception {
    String[] playerNames = {"Max", "Maram", "Roman"};
    Model model = new ModelImpl(2, playerNames);

    // Test that the board is not null
    assertNotNull(model.getBoard());
  }

  @Test
  void testGetCurrentPlayer() throws Exception {
    String[] playerNames = {"Max", "Maram", "Roman"};
    Model model = new ModelImpl(2, playerNames);

    // Test that the current player index is correctly initialized
    assertEquals(0, model.getCurrentPlayer());
  }

  @Test
  void testGetPlayerFields() throws Exception {
    String[] playerNames = {"Max", "Maram", "Roman"};
    Model model = new ModelImpl(2, playerNames);

    // Test that the player fields are initially empty
    Set<Field> fields = model.getPlayerFields(0);
    assertNotNull(fields);
    assertTrue(fields.isEmpty());
  }

  @Test
  void testGetHomeFields() throws Exception {
    String[] playerNames = {"Max", "Maram", "Roman"};
    Model model = new ModelImpl(2, playerNames);

    // Test that the home fields are correctly returned
    Set<Field> homeFields = model.getBoard().getAllHomeFields();
    assertNotNull(homeFields);
    assertFalse(homeFields.isEmpty());
  }
}
