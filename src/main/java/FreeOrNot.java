import java.util.Scanner;

public class FreeOrNot {
    String texts(boolean bool){
        String str="message is empty";
        if(! bool ){} //{str="cell is occupate!";}
        return str;
    }
    boolean isfree(char[] arra, int cell){
        if (arra[cell]=='X'){return false;}
        if (arra[cell]=='O'){return false;}

        return true;
    }

    int inputNumber(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("input number:");
        return scanner.nextInt();
    }
}
