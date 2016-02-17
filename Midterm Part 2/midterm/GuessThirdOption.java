package midterm;

/**
 * Created by kcr12 on 11/2/2016.
 */
public class GuessThirdOption extends TestSolver {

    @Override
    public void finishUnfinishedQuestion(Question question) {

        for (int i = 0; i < Test.getTestQuestions().size(); i++) {
            System.out.println(Test.getTestQuestions().get(i));
        }
    }
}
