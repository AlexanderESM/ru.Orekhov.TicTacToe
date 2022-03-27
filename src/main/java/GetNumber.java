import java.util.InputMismatchException;
import java.util.Scanner;

public class GetNumber {
    int getNumber(char[] array) {
        int n=0;
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                System.out.print("Укажите (введите) номер свободной ячейки:");
                n = scanner.nextInt(); // scanner.nextInt(); //Integer.parseInt(reader.readLine());

                n--;
                if (n >= 0 && n < array.length ){
                    return n;
                }
                //System.out.print("Укажите (введите) номер свободной ячейки:");
            }
            catch (InputMismatchException e) { scanner.next(); }
            catch (NumberFormatException e) {
                System.out.print("Укажите (введите) номер свободной ячейки:");
            }
        }
    }
}
