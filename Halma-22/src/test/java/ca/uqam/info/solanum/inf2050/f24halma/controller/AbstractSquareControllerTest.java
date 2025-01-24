package ca.uqam.info.solanum.inf2050.f24halma.controller;

import ca.uqam.info.solanum.inf2050.f24halma.model.Field;
import ca.uqam.info.solanum.inf2050.f24halma.model.FieldException;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;
import org.junit.Test;

public abstract class AbstractSquareControllerTest {

  abstract public Controller getSquareController(int baseSize, String[] players);

  /**
   * Test if moves for blank test game are correctly produced.
   */
  @Test
  public void testGetMovesNewGame() {
    Controller controller = getSquareController(2, new String[] {"Max", "Hafedh"});

    // At start Max must have 6 valid moves and hafedh none.
    List<Move> moves = controller.getPlayerMoves();
    Assert.assertEquals(9, moves.size());
  }

  /**
   * Access on in existent board field must throw exception.
   */
  @Test(expected = FieldException.class)
  public void testRejectInvalidClearQuery() {
    Controller controller = getSquareController(2, new String[] {"Max", "Hafedh"});
    controller.getModel().isClear(new Field(-1, -1));
  }


  /**
   * Verify that home zones go unchanged by move.
   */
  @Test
  public void testHomeZonesUnchanged() {
    Controller controller = getSquareController(2, new String[] {"Max", "Hafedh"});
    Set<Field> originalHomeZones = controller.getModel().getBoard().getAllHomeFields();
    controller.performMove(new Move(new Field(0, 0), new Field(0, 2), true));
    Assert.assertEquals("Home-Zones must not evolve during gameplay.", originalHomeZones,
        controller.getModel().getBoard().getAllHomeFields());
  }
}
