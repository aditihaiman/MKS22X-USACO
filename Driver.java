import java.io.*;
import java.util.*;

public class Driver {

  public static void main(String[] args) {

    try { //BRONZE
      USACO test = new USACO("makelake.in");
      int[] dig = {1, 4, 4};
      test.stompDig(dig);
      for(int x = 0; x < test.lake.length; x++) {
        System.out.println(Arrays.toString(test.lake[x]));
      }
      System.out.println(USACO.bronze("makelake.in"));

    }
    catch(Exception e) {}


    try{ //SILVER
      test = new USACO1("ctravel.in");

    }
    catch(Exception e){}

  }

}
