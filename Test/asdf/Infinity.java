package asdf;

import java.util.Formatter;

public class Infinity {

    public static void main(String[] args) {

        Formatter formatter = new Formatter();
        boolean xd = true;

        while (xd) {
            System.out.println(formatter.format("%.2f", Math.random() * 2));
        }
    }
}
