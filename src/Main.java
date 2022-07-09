import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static boolean state = true;
    private static boolean drawState = true;
    private final static int ROW = 3;
    private final static int COLUMNE = 3;
    private static int counterMove = 1;
    private static char symbol = 'X';
    private static char[][] plansza = new char[ROW][COLUMNE];

    public static void main(String[] args) {
        // losowanie kto zaczyna
        do {
            try {
                drawPlayer();
                printBoard(plansza);
                drawState = false;
            } catch (InputMismatchException e) {
                System.err.println("Nie poprawny format danych");
                sc.nextLine();
            }
        } while (drawState);


        do {
            try {
                movePlayer();
                printBoard(plansza);
                if (ifWin(plansza, symbol)) {
                    System.out.println("Zwyciężył Gracz " + symbol);
                    state = false;
                    sc.close();
                    System.exit(0);
                }
                symbol = symbol == 'X' ? 'O' : 'X';
                if(counterMove == 9) {
                    System.out.println("Remis");
                    state = false;
                }
                counterMove++;
            } catch (InputMismatchException e) {
                System.err.println("Niepoprawny format danych");
                sc.nextLine();
            }
        } while (state && counterMove <= ROW * COLUMNE);


    }

    private static boolean ifWin(char[][] plansza, char symbol) {
        boolean checkRows = checkRow(plansza, symbol);
        boolean checkColumns = checkColumns(plansza, symbol);
        boolean checkDiagonal1 = checkDiagonal1(plansza, symbol);
        boolean checkDiagonal2 = checkDiagonal2(plansza, symbol);
        return checkRows || checkColumns || checkDiagonal1 || checkDiagonal2;
    }

    private static boolean checkRow(char[][] plansza, char symbol) {
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

    private static boolean checkColumns(char[][] plansza, char symbol) {
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

    private static boolean checkDiagonal1(char[][] plansza, char symbol) {
        for (int i = 0; i < plansza.length; i++) {
            if (plansza[i][i] != symbol) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkDiagonal2(char[][] plansza, char symbol) {
        for (int i = 0; i < plansza.length; i++) {
            for (int j = 0; j < plansza.length; j++) {
                if (plansza[i][plansza.length - i - 1] != symbol) {
                    return false;

                }
            }
        }
        return true;
    }


    public static void drawPlayer() throws InputMismatchException {
        boolean flag = true;
        do {
            System.out.println("Zaczyna ten, który będzie bliżej losowej liczby z zakresu <0-100>");
            System.out.print("Osoba 1 podaje cyfę: ");
            int num1 = sc.nextInt();
            if (checkRange(num1)) continue;
            System.out.print("Osoba 2 podaje cyfrę: ");
            int num2 = sc.nextInt();
            if (checkRange(num2)) continue;
            Random random = new Random();
            int ranNum = random.nextInt(100) + 1;
            System.out.println("Losowa cyfra to: " + ranNum);

            int resultOs1 = Math.abs(ranNum - num1);
            int resultOs2 = Math.abs(ranNum - num2);

            if (resultOs1 == resultOs2) {
                System.out.println("Remis!");
            } else if (resultOs1 < resultOs2) {
                System.out.print("Zaczyna Osoba 1");
                System.out.println();
                flag = false;
            } else {
                System.out.print("Zaczyna Osoba 2");
                System.out.println();
                flag = false;
            }

        } while (flag);
    }


    private static boolean checkRange(int num) {
        if (num < 0 || num > 100) {
            System.out.println("Podałeś cyfrę poza zakresem!");
            return true;
        }
        return false;
    }

    //interfejs wpisywania danych przez Użytkownika
    public static void movePlayer() throws InputMismatchException {
        boolean correctMove = true;
        do {
            System.out.println("Gracz '" + symbol + "'");
            System.out.println("Podaj współrzędne komórki do której wstawić symbol: ");
            System.out.print("wiersz: ");
            int x = sc.nextInt();
            sc.nextLine();
            System.out.print("kolumna: ");
            int y = sc.nextInt();
            sc.nextLine();
            correctMove = !logicMove(x, y);
        } while (correctMove);
    }

    // przypisawanie odpowiednim pola symboli
    private static boolean logicMove(int x, int y) throws ArrayIndexOutOfBoundsException {
        boolean flag = true;
        if ((x < 0 || x > ROW) || (y < 0 || y > COLUMNE)) {
            System.out.println("Podane współrzędne są poza zakresem <0" + COLUMNE + ">");
            System.out.println();
            counterMove--;
            flag = false;
            return flag;
        } else if (checkFiled(x, y, plansza)) {
            plansza[x][y] = symbol;
            return flag;
        } else {
            System.out.println("Pole jest niedostępne");
            flag = false;
        }
        return flag;
    }

    //metoda sprawdza czy komórka jest pusta
    private static boolean checkFiled(int x, int y, char[][] plansza) {
        return plansza[x][y] == 0;
    }

    // wyświetlanie planszy z numeracją wiersz-kolumna
    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.print("\t" + i);
        }
        System.out.println();
        for (int i = 0; i < plansza.length; i++) {
            System.out.print(i + "\t");
            for (int j = 0; j < plansza.length; j++) {
                System.out.print(plansza[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
