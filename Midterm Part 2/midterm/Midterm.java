package midterm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static midterm.Test.getTestQuestions;
import static midterm.Test.testQuestions;

public class Midterm {

    static String userPath;

    public static void main(String[] args) {

        testQuestions();
        writeTestToFile();

        for (int i = 0; i < getTestQuestions().size(); i++) {
            System.out.println(getTestQuestions().get(i));
        }
    }

    public static void writeTestToFile() {

//        Question questionOne = new Question("What is the integral of sin(x)?@tan(x),sec(x),cos(x),sin(x)@3");
//        Question questionTwo = new Question("What is the derivative of sec(x)?@sec(x)tan(x),sec^2(x),tan^2(x),ln(abs(sec(x)+tan(x))@?");
//        Question questionThree = new Question("What is McDonald's?@food,game,school,country@?");
//        Question questionFour = new Question("What year is it?@2000,2010,2016,2025@?");
//        Question questionFive = new Question("What class is this?@CS312,CS320,CS245,CS202@?");

        Scanner sc = new Scanner(System.in);
        String[] questionArray = new String[5];
        System.out.println("Please provide a path for the multiple choice questions and your answers so far.");
        userPath = sc.next();
        Path path = Paths.get(userPath + "finishedExam.txt");
        Charset charset = Charset.forName("UTF-8");
        questionArray[0] = "What is the integral of sin(x)?@tan(x),sec(x),cos(x),sin(x)@3";
        questionArray[1] = "What is the derivative of sec(x)?@sec(x)tan(x),sec^2(x),tan^2(x),ln(abs(sec(x)+tan(x))@?";
        questionArray[2] = "What is McDonald's?@food,game,school,country@?";
        questionArray[3] = "What year is it?@2000,2010,2016,2025@?";
        questionArray[4] = "What class is this?@CS312,CS320,CS245,CS202@?";
        String[] splitQuestions = questionArray[0].split("@");

        // I thought if I just specified a path it would work, but gives me error
        try (BufferedWriter writer = Files.newBufferedWriter(path, charset)) {
            for (int i = 0; i < Test.getTestQuestions().size(); i++) {
                for (String j : questionArray) {
                    splitQuestions[i] = String.valueOf(questionArray[i].split("@"));
                }
//                writer.write();
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public static String[] readQuestionsFromFile(String fileName) {

        Charset charset = Charset.forName("UTF-8");
        List<String> allQuestions = new ArrayList<String>();
        Path path = Paths.get(userPath);

        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            allQuestions = Files.readAllLines(path, charset);
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        String[] questions = new String[5];
        for (int i = 0; i < allQuestions.size(); i++) {
            questions[i] = String.valueOf(allQuestions.get(i).split("@"));
        }

        return questions;
    }
}
