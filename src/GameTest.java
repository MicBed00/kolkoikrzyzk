import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;
    private char[][] board;
    private char symbol;

    @BeforeEach
    void BeforeEach() {
        game = new Game();
        board = new char[3][3];
        symbol = 'X';
    }

    @AfterEach
    void AfterEach() {
        //clean board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                  board[i][j] = 0;
            }
        }
    }

   @Test
    void shouldShowWinnnerInFirstColumne() {
        //given
      board[0][0] = symbol;
      board[1][0] = symbol;
      board[2][0] = symbol;

        //when
        boolean result  = game.ifWin(board, symbol);

        //then
       Assertions.assertEquals(true, result);
    }

    @Test
    void shouldShowWinnnerInSecondColumne() {
        //given
        board[0][1] = symbol;
        board[1][1] = symbol;
        board[2][1] = symbol;

        //when
        boolean result  = game.ifWin(board, symbol);

        //then
        Assertions.assertEquals(true, result);
    }

    @Test
    void shouldShowWinnnerInThir2Columne() {
        //given
        board[0][2] = symbol;
        board[1][2] = symbol;
        board[2][2] = symbol;

        //when
        boolean result  = game.ifWin(board, symbol);

        //then
        Assertions.assertEquals(true, result);
    }

    @Test
    void shouldShowWinnnerInDiagonal() {
        //given
        board[0][0] = symbol;
        board[1][1] = symbol;
        board[2][2] = symbol;

        //when
        boolean result  = game.ifWin(board, symbol);

        //then
        Assertions.assertEquals(true, result);
    }

    @Test
    void shouldChangeSymbol() {
        //given

        //when
        game.changeSymbol();

        //then
        Assertions.assertEquals('O', game.getSymbol());

    }

    @Test
    void shouldCheckRowTrue() {
        //given
        board[1][0] = symbol;
        board[1][1] = symbol;
        board[1][2] = symbol;

        //when
        boolean result  = game.checkRow(board, symbol);

        //then
        Assertions.assertEquals(true, result);


    }

    @Test
    void shouldCheckColumneTrue() {
        //given
        board[0][0] = symbol;
        board[1][0] = symbol;
        board[2][0] = symbol;

        //when
        boolean result  = game.checkColumns(board, symbol);

        //then
        Assertions.assertEquals(true, result);


    }

    @Test
    void shouldCheckDiagonalTrue() {
        //given
        board[0][2] = symbol;
        board[1][1] = symbol;
        board[2][0] = symbol;

        //when
        boolean result  = game.checkDiagonal2(board, symbol);

        //then
        Assertions.assertEquals(true, result);
    }

    @Test
    void checkIfFieldIsEmpty() {
        //given
        int x = 1;
        int y = 1;

        //when
        boolean result = game.checkFiled(x, y, board);

        //then
        Assertions.assertEquals(true, result);
    }

    @Test
    void checkCorrectLogicMove() {
        //given
        int x = 0;
        int y = 0;

        //when
        boolean result = game.logicMove(board, x, y);

        //then
        Assertions.assertEquals(true, result);
    }

    @Test
    void checkIncorrectLogicMoveOutOfBounds() {
        //given
        int x = 5;
        int y = 8;

        //when
        boolean result = game.logicMove(board, x, y);

        //then
        Assertions.assertEquals(false, result);
    }

    @Test
    void checkIncorrectLogicMoveFieldOccupied() {
        //given
        int x = 0;
        int y = 0;
        board[0][0] = symbol;

        //when
        boolean result = game.logicMove(board, x, y);

        //then
        Assertions.assertEquals(false, result);
    }

    @Test
    void shouldPointOutWinnerAndQuitGame() {



    }

}