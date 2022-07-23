import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class DrawPlayer {

    public void drawPlayer() throws InputMismatchException {

        boolean flag = false;
        do {
            flag = false;
            System.out.println("Zaczyna ten, który będzie bliżej losowej liczby z zakresu <0-100>");
            System.out.print("Osoba 1 podaje cyfę: ");
            int num1 = getNumber();
            if (checkRange(num1)) continue;
            System.out.print("Osoba 2 podaje cyfrę: ");
            int num2 = getNumber();
            if (checkIfEqual(num1, num2)) {
                flag = true;
                continue;
            }
            if (checkRange(num2)) continue;
            int ranNum = randomNumber();
            choosePlayer(num1, num2, ranNum);
        } while (flag);
    }

    public void choosePlayer(int num1, int num2, int ranNum) {
        int resultOs1 = Math.abs(ranNum - num1);
        int resultOs2 = Math.abs(ranNum - num2);

        if (resultOs1 < resultOs2) {
            System.out.print("Zaczyna Osoba 1");
            System.out.println();
        } else {
            System.out.print("Zaczyna Osoba 2");
            System.out.println();
        }
    }

    public boolean checkIfEqual(int num1, int num2) {
        if (num1 == num2) {
            System.out.println("Remis!");
            return true;
        }
        return false;
    }

    private int randomNumber() {
        Random random = new Random();
        int ranNum = random.nextInt(100) + 1;
        System.out.println("Losowa cyfra to: " + ranNum);
        return ranNum;
    }

    private int getNumber() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public boolean checkRange(int num) {
        if (num < 0 || num > 100) {
            System.out.println("Podałeś cyfrę poza zakresem!");
            return true;
        }
        return false;
    }
}
