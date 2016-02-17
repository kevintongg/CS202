package midterm;

public class UserPick extends TestSolver {

    @Override
    public void finishUnfinishedQuestion(Question question) {

        for (int i = 0; i < Test.getTestQuestions().size(); i++) {
            System.out.println(Test.getTestQuestions().get(i));
        }
    }

    public static void printQuestions() {

    }
}
