import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static boolean winOrLose = false;
    private static boolean counterCondition = false;
    private static boolean drawState = true;
    private final static int ROW = 3;
    private final static int COLUMNE = 3;
    private static int counterMove = 1;
    private static char[][] plansza = new char[ROW][COLUMNE];

    public static void main(String[] args) {
        Game game = new Game();
        DrawPlayer player = new DrawPlayer();
        PrintBoard printer = new PrintBoard();
        char symbol = game.getSymbol();

        // losowanie kto zaczyna
        drawingPlayer(player, printer);
        // rozgrywka
        game(game, printer, symbol);
    }

    private static void game(Game game, PrintBoard printer, char symbol) {
        do {
            try {
                game.movePlayer(plansza);
                printer.printBoard(plansza);
                boolean winOrLose = game.ifWin(plansza, symbol);
                boolean counterCondition = counterMove == ROW * COLUMNE;
                game.endGame(winOrLose, counterCondition);
                game.changeSymbol();
                counterMove++;
            } catch (InputMismatchException e) {
                System.err.println("Niepoprawny format danych");
                sc.nextLine();
            }
        } while (!winOrLose && !counterCondition);
    }


    private static void drawingPlayer(DrawPlayer player, PrintBoard printer) {
        do {
            try {
                player.drawPlayer();
                printer.printBoard(plansza);
                drawState = false;
            } catch (InputMismatchException e) {
                System.err.println("Nie poprawny format danych");
                sc.nextLine();
            }
        } while (drawState);
    }
}
