package samplemidterm;

import java.util.ArrayList;
import java.util.List;

public interface PlayTTT {

    String[][] getTurn(String[][] board, String piece);
    boolean checkWin(String[][] board, String piece);

    List<SetMoves> moves = new ArrayList<>();

}
