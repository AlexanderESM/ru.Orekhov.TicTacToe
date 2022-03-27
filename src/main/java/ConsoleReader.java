import java.util.Scanner;

public class ConsoleReader {
    String setName(){
        String str="";

        Scanner scanner = new Scanner(System.in);
        // строка недолжна быть пустой

        while (str.trim().length() == 0){
            System.out.print("Введите имя:");
            str = scanner.nextLine();
        }

        return str.trim();
    }
}
