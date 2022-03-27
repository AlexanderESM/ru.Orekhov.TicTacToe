public class GameOver {
    boolean isGameOver(char[] array){
        for (int i=0; i <= array.length;i++){
            //System.out.println("isGameOver = ???");
            if(array[i]==0){//i++;
               // System.out.println("isGameOver = true");
                return true;}
        }
        System.out.println("isGameOver = false");
        return false;
    }

    //проверка игрока X
    boolean winX (char[] array){
        if( array[0]=='X' && array[1]=='X' && array[2]=='X'){return true;}
        if( array[3]=='X' && array[4]=='X' && array[5]=='X'){return true;}
        if( array[6]=='X' && array[7]=='X' && array[8]=='X'){return true;}

        if( array[0]=='X' && array[3]=='X' && array[6]=='X'){return true;}
        if( array[1]=='X' && array[4]=='X' && array[7]=='X'){return true;}
        if( array[2]=='X' && array[5]=='X' && array[8]=='X'){return true;}

        if( array[0]=='X' && array[4]=='X' && array[8]=='X'){return true;}
        if( array[2]=='X' && array[4]=='X' && array[6]=='X'){return true;}

        return false;
    }


    //проверка игрока O
    boolean winO (char[] array){
        if( array[0]=='O' && array[1]=='O' && array[2]=='O'){return true;}
        if( array[3]=='O' && array[4]=='O' && array[5]=='O'){return true;}
        if( array[6]=='O' && array[7]=='O' && array[8]=='O'){return true;}

        if( array[0]=='O' && array[3]=='O' && array[6]=='O'){return true;}
        if( array[1]=='O' && array[4]=='O' && array[7]=='O'){return true;}
        if( array[2]=='O' && array[5]=='O' && array[8]=='O'){return true;}

        if( array[0]=='O' && array[4]=='O' && array[8]=='O'){return true;}
        if( array[2]=='O' && array[4]=='O' && array[6]=='O'){return true;}

        return false;
    }

    //проверка на ничью
    boolean draw(char[] array){
        int draw=0;
        int n=0;
        for(int i=0; i< array.length; i++){
            try {
                // System.out.println("try");
                //System.out.println( Integer.parseInt( String.valueOf(array[i]) ) );
                n=Integer.parseInt( String.valueOf(array[i]) );
            /*
                if ( (array[i] <= 1) || (array[i] >= 9)) {
                    System.out.println("if array[i]= " + array[i] );
                    System.out.println(" if draw="+draw);
                    return false;}
                */
            }
            catch (NumberFormatException e){draw++;
                // System.out.println("catch draw= "+draw);

            }

            //if ( (array[i] <= 1) || (array[i] >= 9)) throw new NumberFormatException();

        }
        if(draw==9){
            //  System.out.println("if(draw==9) draw="+draw);
            return true;}
         //System.out.println("before return =false draw="+draw);
        return false;
    }
}
