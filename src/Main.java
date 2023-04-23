import java.io.*;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList SLLtemp = new SingleLinkedList();
        SingleLinkedList SLL1 = new SingleLinkedList();
        SingleLinkedList SLL2 = new SingleLinkedList();
        SingleLinkedList SLL3 = new SingleLinkedList();
        SingleLinkedList SLL4 = new SingleLinkedList();
        SingleLinkedList SLL5 = new SingleLinkedList();
        SingleLinkedList LastNameSLL = new SingleLinkedList();
        SingleLinkedList LastScoreSLL = new SingleLinkedList();
        SingleLinkedList mainSLL = new SingleLinkedList();

        //region animals.txt
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\animals.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] animals = line.split(" ");
                for (String animal : animals) {
                    mainSLL.UnsortedAdd(animal);
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
//endregion

        System.out.println(ANSI_CYAN + "      ---Welcome to the Memory Game---");

        //region print main SLL
        Scanner scanner = new Scanner(System.in);
        int input = 0;

        do {
            System.out.print(ANSI_CYAN + "Enter a number (between SLL size and 1) for n: ");
            input = scanner.nextInt();
        }
        while (input > mainSLL.size());

        System.out.print(ANSI_PURPLE + "\nAnimal SLL: ");
        mainSLL.display();
        //endregion

        //region create SLL1 and SLL2
        mainSLL.duplicate(SLLtemp);

        Random rand = new Random();
        int count1 = 0;
        int count2 = 0;

        while (count1 < input)
        {
            int index1 = rand.nextInt(mainSLL.size()) + 1;

            if (SLL1.search((String) mainSLL.get(index1)) == false) {
                SLL1.UnsortedAdd(mainSLL.get(index1));
                count1++;
            }
        }

        while (count2 < input)
        {
            int index2 = rand.nextInt(SLLtemp.size()) +1;

            if (SLL2.search((String) SLLtemp.get(index2)) == false && SLL1.search((String) SLLtemp.get(index2)) == true) {
                SLL2.UnsortedAdd(SLLtemp.get(index2));
                count2++;
            }
        }
//endregion

        //region gameplay
        int counter = 0;
        int score = 0;

        System.out.println("");
        while (SLL1.head != null) {
            counter++;
            int random1 = rand.nextInt(1, (int) SLL1.size() + 1);
            int random2 = rand.nextInt(1, (int) SLL2.size() + 1);

            System.out.println(ANSI_RED + "-----------------------------------------------------------------------------------------------------------------");
            System.out.print(ANSI_GREEN + "SLL1: ");
            SLL1.display();
            System.out.println();
            System.out.print("SLL2: ");
            SLL2.display();
            System.out.println(ANSI_YELLOW + "\nRandomly generated numbers: " + random1 + "  " + random2 + "                   " + "step = " + counter);
            System.out.println("                                                   score = " + score);
            System.out.println(ANSI_RED + "-----------------------------------------------------------------------------------------------------------------");

            if (SLL1.get(random1) == SLL2.get(random2)) {
                score += 20;
                SLL1.delete(SLL1.get(random1));
                SLL2.delete(SLL2.get(random2));
            } else
                score--;
        }

        System.out.println(ANSI_BLUE + "SLL1:");
        System.out.println("SLL2:");
        System.out.println("                                                   score = " + score);
        System.out.println("\n****The game is over.****");

        //endregion

        //region highscore table
        String name;
        System.out.println("");
        System.out.print(ANSI_RESET + "Enter your name: ");
        name = scanner.next();

        try {
            BufferedReader reader;
            reader = new BufferedReader(new FileReader("C:\\highscoretable.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(" ");
                SLL3.UnsortedAdd(parts[0]);
                SLL4.SortedAdd(Integer.parseInt(parts[1]));
                SLL5.UnsortedAdd(Integer.parseInt(parts[1]));

                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        SLL3.UnsortedAdd(name);
        SLL4.SortedAdd(score);
        SLL5.UnsortedAdd(score);

        System.out.println();
        System.out.println("High Score Table: \n");

        String lastname = null;


        for (int i = SLL4.size(); i > 0; i--)
        {
            for (int j = 0; j < SLL5.size() + 1; j++)
            {
                if ((int) SLL5.get(j) == (int) SLL4.get(i) && LastNameSLL.search((String) SLL3.get(j))== false)
                {
                    lastname = (String) SLL3.get(j);

                    LastNameSLL.UnsortedAdd(lastname);
                    LastScoreSLL.UnsortedAdd((int) SLL4.get(i));

                    break;
                }
            }
        }



        for (int i = 1; i <= LastNameSLL.size(); i++)
        {
            if(i < 13)
                if(name == LastNameSLL.get(i) && score == (int)LastScoreSLL.get(i))
                    System.out.print(ANSI_YELLOW + i + ". " + LastNameSLL.get(i) + " " + (int) LastScoreSLL.get(i) + "\n");
                else
                    System.out.print(ANSI_RESET + i + ". " + LastNameSLL.get(i) + " " + (int) LastScoreSLL.get(i) + "\n");
            else
                if(name == LastNameSLL.get(i) && score == (int)LastScoreSLL.get(i)) {
                System.out.println("");
                System.out.print(ANSI_YELLOW + "Sorry, your score is lower than high score table. You can try again. ");
                }
        }
        //endregion


        //region TXT Write
        try {
            FileWriter writer = new FileWriter("C:\\highscoretable.txt");
            for (int i = 1; i <= LastNameSLL.size(); i++)
            {
                if(i < 13)
                    writer.write(LastNameSLL.get(i) + " " + (int) LastScoreSLL.get(i) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //endregion

    }

    //region COLOR
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";

//endregion
}

