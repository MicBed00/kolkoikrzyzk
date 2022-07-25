import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

class MainTest {

  @Test
  public void ifWinReturnsTrue() {
    char[][] boardWithXesInRow = char[];
    // TODO wypłenić
    //ooo
    //xxx
    //ooo
    assertTrue(Main.ifWin(boardWithXesInRow, 'X'));


    char[][] boardWithXesInRow = char[];
    // TODO wypłenić
    //xoo
    //oxo
    //oox
    assertTrue(Main.ifWin(boardWithXesInRow, 'X'));

    char[][] boardWithXesInRow = char[];
    // TODO wypłenić
    //xoo
    //ooo
    //oox
    assertFalse(Main.ifWin(boardWithXesInRow, 'X'));
  }
}
