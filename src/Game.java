import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private int counterMove = 1;
    private char symbol = 'X';


    public boolean ifWin(char[][] plansza, char symbol) {
        boolean checkRows = checkRow(plansza, symbol);
        boolean checkColumns = checkColumns(plansza, symbol);
        boolean checkDiagonal1 = checkDiagonal1(plansza, symbol);
        boolean checkDiagonal2 = checkDiagonal2(plansza, symbol);
        return checkRows || checkColumns || checkDiagonal1 || checkDiagonal2;
    }

    public boolean checkRow(char[][] plansza, char symbol) {
        boolean resultRow = true;
        for (int i = 0; i < plansza.length; i++) {
            resultRow = true;
            for (int j = 0; j < plansza.length; j++) {
                if (plansza[i][j] != symbol) {
                    resultRow = false;
                    break;
                }
            }
            if (resultRow) return true;
        }
        return false;
    }

    public boolean checkColumns(char[][] plansza, char symbol) {
        boolean resultColumne = true;
        for (int i = 0; i < plansza.length; i++) {
            resultColumne = true;
            for (int j = 0; j < plansza.length; j++) {
                if (plansza[j][i] != symbol) {
                    resultColumne = false;
                    break;
                }
            }
            if (resultColumne) return true;
        }
        return false;
    }

    public boolean checkDiagonal1(char[][] plansza, char symbol) {
        for (int i = 0; i < plansza.length; i++) {
            if (plansza[i][i] != symbol) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDiagonal2(char[][] plansza, char symbol) {
        for (int i = 0; i < plansza.length; i++) {
            for (int j = 0; j < plansza.length; j++) {
                if (plansza[i][plansza.length - i - 1] != symbol) {
                    return false;

                }
            }
        }
        return true;
    }

    public char getSymbol() {
        return symbol;
    }

    public void changeSymbol() {
        symbol = symbol == 'X' ? 'O' : 'X';
    }

    //interfejs wpisywania danych przez U??ytkownika
    public void movePlayer(char[][] plansza) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        boolean correctMove = true;
        do {
            System.out.println("Gracz '" + symbol + "'");
            System.out.println("Podaj wsp????rz??dne kom??rki do kt??rej wstawi?? symbol: ");
            System.out.print("wiersz: ");
            int x = sc.nextInt();
            sc.nextLine();
            System.out.print("kolumna: ");
            int y = sc.nextInt();
            sc.nextLine();
            correctMove = !logicMove(plansza, x, y);
        } while (correctMove);
    }

    // przypisawanie odpowiednim pola symboli
    public boolean logicMove(char[][] board, int x, int y) throws ArrayIndexOutOfBoundsException {
        boolean flag = true;
        if ((x < 0 || x > board.length) || (y < 0 || y > board.length)) {
            System.out.println("Podane wsp????rz??dne s?? poza zakresem <0" + board.length + ">");
            System.out.println();
            counterMove--;
            flag = false;
            return flag;
        } else if (checkFiled(x, y, board)) {
            board[x][y] = symbol;
            return flag;
        } else {
            System.out.println("Pole jest niedost??pne");
            flag = false;
        }
        return flag;
    }

    //metoda sprawdza czy kom??rka jest pusta
    public boolean checkFiled(int x, int y, char[][] plansza) {
        return plansza[x][y] == 0;
    }

    public void endGame(boolean winOrLose, boolean counterCondition) {
        if (counterCondition) {
            System.out.println("Remis");
        } else if (winOrLose) {
            System.out.println("Zwyci????y?? Gracz " + symbol);
            System.exit(0);
        }
    }



}
