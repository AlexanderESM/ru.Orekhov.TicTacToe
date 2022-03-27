import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Main {
    public static void main(String[] args) {

        char[] chArr = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Draw draw = new Draw();
        draw.myDraw(chArr);

        FreeOrNot isfree = new FreeOrNot();
        int cell = 0;

        //Scanner scanner = new Scanner(System.in);
        GameOver stopGame = new GameOver();

        //добавим в наименование файла дату и время для уникальности имени файла
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy HH_mm_ss");// установить формат даты
        String myFileName = "Game_" + dateFormat.format(new Date()) + "_.xml";

        //Ввода с клавиатуры имени игрока
        ConsoleReader scann = new ConsoleReader();

        //создаём игроков
        Player playerOne = new Player(1, scann.setName(), "X", 0);
        Player playerTwo = new Player(2, scann.setName(), "O", 0);

        //для теста
        //Player playerOne = new Player(1, "Филип Джей Фрай","X",0 );
        //Player playerTwo = new Player(2, "Бе́ндер Сгибальщик Родри́гес","O",0);

        //создали документ
        Document doc = new Document();

        //создаём корневой элемент с пространством имён
        doc.setRootElement(new Element("Gameplay")
                .addContent(new Element("Player")
                        .setAttribute("id", String.valueOf(playerOne.getId()))
                        .setAttribute("name", String.valueOf(playerOne.getName()))
                        .setAttribute("symbol", String.valueOf(playerOne.getSymbol()))
                )
                .addContent(new Element("Player")
                        .setAttribute("id", String.valueOf(playerTwo.getId()))
                        .setAttribute("name", String.valueOf(playerTwo.getName()))
                        .setAttribute("symbol", String.valueOf(playerTwo.getSymbol()))
                )

        );

        doc.getRootElement();


        Element game = new Element("Game");

        //чей ход
        int turn = 1;
        GetNumber getNumber = new GetNumber();
        do {
            if ((turn % 2) == 0) {
                //Ход второго игрока O
                System.out.println("Ход игрока " + playerTwo.getName() + " символ O");
                cell = getNumber.getNumber(chArr);
                if (!isfree.isfree(chArr, cell)) {
                    System.out.println("Ячейка " + cell + " занята!");
                } else {
                    chArr[cell] = 'O';

                    //добавляем в xml
                    game.addContent(new Element("Step")
                            .setAttribute("num", String.valueOf(turn))//turn
                            .setAttribute("playerId", String.valueOf(playerTwo.getId()))
                            .setText(String.valueOf(cell))//turn
                    );


                    turn++;
                }
                draw.myDraw(chArr);
            } else {
                //Ход первого игрока Х
                System.out.println("Ход игрока " + playerOne.getName() + " символ X");
                cell = getNumber.getNumber(chArr);

                if (!isfree.isfree(chArr, cell)) {
                    //System.out.println("cell is occupate");
                } else {
                    chArr[cell] = 'X';
                    //добавляем в xml
                    game.addContent(new Element("Step")
                            .setAttribute("num", String.valueOf(turn))//cell
                            .setAttribute("playerId", String.valueOf(playerOne.getId()))
                            .setText(String.valueOf(cell))//turn
                    );
                    turn++;
                }
                draw.myDraw(chArr);
            }

        } while (stopGame.winX(chArr) == false && stopGame.winO(chArr) == false && stopGame.draw(chArr) == false);

        doc.getRootElement().addContent(game);

        Element gameResult = new Element("GameResult");
/*
        if (stopGame.winX(chArr)==true) { System.out.println("Выиграл игрок "+playerOne.getName());
            gameResult.setAttribute("id", String.valueOf( playerOne.getId() ) );
            gameResult.setAttribute("name",playerOne.getName()  );
            gameResult.setAttribute("symbol",playerOne.getSymbol() );

            gameResult.setText("Win" );
        }

        if (stopGame.winO(chArr)==true) { System.out.println("Выиграл игрок "+playerTwo.getName());
            gameResult.setAttribute("id", String.valueOf( playerTwo.getId() ) );
            gameResult.setAttribute("name",playerTwo.getName()  );
            gameResult.setAttribute("symbol",playerTwo.getSymbol() );

            gameResult.setText("Win" );
        }

        if (stopGame.draw(chArr)==true) { System.out.println("Ничь");
            gameResult.setText("Draw");
        }
        */
        if (stopGame.draw(chArr)==true) { System.out.println("Ничь");
            gameResult.setText("Draw");
        }else{

            if (stopGame.winX(chArr)==true) { System.out.println("Выиграл игрок "+playerOne.getName());
                gameResult.setAttribute("id", String.valueOf( playerOne.getId() ) );
                gameResult.setAttribute("name",playerOne.getName()  );
                gameResult.setAttribute("symbol",playerOne.getSymbol() );

                gameResult.setText("Win" );
            }else{
                if (stopGame.winO(chArr)==true) { System.out.println("Выиграл игрок "+playerTwo.getName());
                    gameResult.setAttribute("id", String.valueOf( playerTwo.getId() ) );
                    gameResult.setAttribute("name",playerTwo.getName()  );
                    gameResult.setAttribute("symbol",playerTwo.getSymbol() );

                    gameResult.setText("Win" );
                }
            }

        }


        doc.getRootElement().addContent(gameResult);

            // Документ JDOM сформирован и готов к записи в файл
            XMLOutputter xmlWriter = new XMLOutputter(Format.getPrettyFormat());

            // сохнаряем в файл
            try {
                xmlWriter.output(doc, new FileOutputStream(myFileName));
            } catch (IOException e) {
                e.printStackTrace();
            }


        }


}
