public class Draw {
    void myDraw(char[] canvas){
        System.out.println(canvas[0]+"  |  "+canvas[1]+"  |  "+canvas[2] );
        System.out.println("___|_____|___");
        //System.out.println("   |     |   ");
        System.out.println(canvas[3]+"  |  "+canvas[4]+"  |  "+canvas[5] );
        System.out.println("___|_____|___");
        //System.out.println("   |     |   ");
        System.out.println(canvas[6]+"  |  "+canvas[7]+"  |  "+canvas[8] );

    }

    void draw(int[] canvas ){
        int cellNumber=1;
        System.out.println("     |     |     ");
        for (int i = 0; i < canvas.length; i++) {
            if (i!=0){
                if (i%3==0) {
                    System.out.println();
                    System.out.println("_____|_____|_____");
                    System.out.println("     |     |     ");
                }
                else
                    System.out.print("|");
            }

            if (canvas[i]==0) System.out.print("  " + cellNumber + "  ");
            cellNumber++;
            //System.out.println("draw cellNumber="+cellNumber);
            if (canvas[i]==1) System.out.print("  X  ");
            if (canvas[i]==2) System.out.print("  O  ");
        }
        System.out.println();
        System.out.println("     |     |     ");
    }

    //char
    void draw(char[] canvas ){
        int cellNumber=1;
        System.out.println("     |     |     ");
        for (int i = 0; i < canvas.length; i++) {
            if (i!=0){
                if (i%3==0) {
                    System.out.println();
                    System.out.println("_____|_____|_____");
                    System.out.println("     |     |     ");
                }
                else
                    System.out.print("|");
            }

            if (canvas[i]==0) System.out.print("  " + cellNumber + "  ");
            cellNumber++;
            //System.out.println("draw cellNumber="+cellNumber);
            if (canvas[i]==1) System.out.print("  X  ");
            if (canvas[i]==2) System.out.print("  O  ");
        }
        System.out.println();
        System.out.println("     |     |     ");
    }
}
