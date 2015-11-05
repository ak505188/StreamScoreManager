package StreamScoreManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.FlowLayout;

public class Main extends JFrame{
    private static int Score1 = 0;
    private static int Score2 = 0;
    private static String Name1 = "";
    private static String Name2 = "";

    static public void UpdateFiles (){
        try {
            FileWriter writer;
            writer = new FileWriter("Name1.txt");
            writer.flush();
            writer.write(Name1);
            writer.close();
            writer = new FileWriter("Score1.txt");
            writer.flush();
            writer.write(String.valueOf(Score1));
            writer.close();
            writer = new FileWriter("Name2.txt");
            writer.flush();
            writer.write(Name2);
            writer.close();
            writer = new FileWriter("Score2.txt");
            writer.flush();
            writer.write(String.valueOf(Score2));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } //UpdateFiles
    static public void UpdateNames (String name1, String name2){
        Name1 = name1;
        Name2 = name2;
    }//UpdateNames
    static public void SwapNames (){
        String temp = Name1;
        Name1 = Name2;
        Name2 = temp;
    }//SwapNames
    static public String getName1 (){
        return Name1;
    }//getName1
    static public String getName2 (){
        return Name2;
    }//getName2
    static public int changeScore1(int num){
        if (num < 0)
            Score1++;
        else Score1 = num;
        return Score1;
    }//changeScore1
    static public int changeScore2(int num){
        if (num < 0)
            Score2++;
        else Score2 = num;
        return Score2;
    }//changeScore2

    public Main() {
        super("StreamScoreManager");
        setLayout(new FlowLayout());
        setSize(560, 150);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        Main frame = new Main();
        JButton Plus1 = new JButton("+");
        final JTextField TextScore1 = new JTextField(3);
        final JTextField TextName1 = new JTextField(40);
        JButton Plus2 = new JButton("+");
        final JTextField TextScore2 = new JTextField(3);
        final JTextField TextName2 = new JTextField(40);
        JButton Apply = new JButton("Apply");
        JButton SwapNames = new JButton("Swap Names");
        JButton ResetScores = new JButton("Reset Scores");
        JButton ClearAll = new JButton("Clear All");
        frame.add(Plus1);
        frame.add(TextScore1);
        frame.add(TextName1);
        frame.add(Plus2);
        frame.add(TextScore2);
        frame.add(TextName2);
        frame.add(Apply);
        frame.add(SwapNames);
        frame.add(ResetScores);
        frame.add(ClearAll);
        TextScore1.setText("0");
        TextScore2.setText("0");
        Plus1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextScore1.setText(String.valueOf(changeScore1(-1)));
                UpdateFiles();
            }
        });
        Plus2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextScore2.setText(String.valueOf(changeScore2(-1)));
                UpdateFiles();
            }
        });
        Apply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateNames(TextName1.getText(), TextName2.getText());
                UpdateFiles();
            }
        });
        SwapNames.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateNames(TextName1.getText(), TextName2.getText());
                SwapNames();
                TextName1.setText(getName1());
                TextName2.setText(getName2());
                UpdateFiles();
            }
        });
        ResetScores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextScore1.setText(String.valueOf(changeScore1(0)));
                TextScore2.setText(String.valueOf(changeScore2(0)));
                UpdateFiles();
            }
        });
        ClearAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextScore1.setText(String.valueOf(changeScore1(0)));
                TextScore2.setText(String.valueOf(changeScore2(0)));
                TextName1.setText("");
                TextName2.setText("");
                UpdateNames("", "");
                UpdateFiles();
            }
        });
        frame.setVisible(true);
    }//main
}//Main
