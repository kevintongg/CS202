package asdf;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test2 {

  public static void main(String[] args) {


    Date date = new Date();
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a");

    System.out.println(dateFormat.format(date.getTime()));

    if (dateFormat.format(date.getTime()).contains("2016")) {
      System.out.println("dank");
    }
  }
}

