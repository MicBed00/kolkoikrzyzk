public class PrintBoard {

    // wyświetlanie planszy z numeracją wiersz-kolumna
    public void printBoard(char[][] plansza) {
        for (int i = 0; i < plansza.length; i++) {
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
