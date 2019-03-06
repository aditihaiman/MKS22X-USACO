import java.io.*;
import java.util.*;

public class Driver {

  public static void main(String[] args) {

    try {
      USACO test = new USACO("makelake.in");

    int[] dig = {1, 4, 4};
    test.stompDig(dig);

    for(int x = 0; x < test.lake.length; x++) {
      System.out.println(Arrays.toString(test.lake[x]));
    }

    }
    catch(Exception e) {}


  }

}
