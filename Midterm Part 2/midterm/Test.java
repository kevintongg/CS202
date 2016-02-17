package midterm;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private static List<Question> testQuestions = new ArrayList<>();
    private String questions;

    public Test(List<Question> testQuestions, String questions) {
        this.testQuestions = testQuestions;
        this.questions = questions;
    }

    public static void testQuestions() {

        // [QUESTION TEXT HERE]@OPTION1,OPTION2,OPTION3,OPTION4@USER_ANSWER

        Question questionOne = new Question("What is the integral of sin(x)?@tan(x),sec(x),cos(x),sin(x)@3");
        Question questionTwo = new Question("What is the derivative of sec(x)?@sec(x)tan(x),sec^2(x),tan^2(x),ln(abs(sec(x)+tan(x))@?");
        Question questionThree = new Question("What is McDonald's?@food,game,school,country@?");
        Question questionFour = new Question("What year is it?@2000,2010,2016,2025@?");
        Question questionFive = new Question("What class is this?@CS312,CS320,CS245,CS202@?");

        testQuestions.add(questionOne);
        testQuestions.add(questionTwo);
        testQuestions.add(questionTwo);
        testQuestions.add(questionFour);
        testQuestions.add(questionFive);
    }

    public static List<Question> getTestQuestions() {
        return testQuestions;
    }

    public static void setTestQuestions(List<Question> testQuestions) {
        Test.testQuestions = testQuestions;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }
}
