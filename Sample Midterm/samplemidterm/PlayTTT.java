package samplemidterm;

import java.util.ArrayList;
import java.util.List;

public interface PlayTTT {

  List<SetMoves> moves = new ArrayList<>();

  String[][] getTurn(String[][] board, String piece);

  boolean checkWin(String[][] board, String piece);

}
