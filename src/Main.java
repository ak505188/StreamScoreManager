import java.io.*;

public class Main {

    public static void main(String[] args){
        char[] Player1Name = new char[50];
        try{
            File Name1 = new File("P1_score.txt");
            if (!Name1.exists())
                Name1.createNewFile();
            FileReader namer1 = new FileReader(Name1);
            FileWriter namew1 = new FileWriter(Name1);
            namew1.write("UG | Alex 80k");
            namew1.flush();
            namew1.close();
            namer1.read(Player1Name);
            for (int i = 0; i < 50; i++)
                System.out.print(Player1Name[i]);
            System.out.println();
            namer1.close();
        }catch (IOException e){
            e.printStackTrace();
        }










        System.out.println("Hello World!");
    }
}
