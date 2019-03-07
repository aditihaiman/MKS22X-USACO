import java.io.*;
import java.util.*;

public class USACO {

  public int[][] lake;
  public int row, col, elevation;
  public int[][] stomps;

  // ---------------------- BRONZE PROBLEM ----------------------- //
  public USACO(String filename) throws FileNotFoundException {
    File text = new File(filename);
    Scanner inf = new Scanner(text);
    row = inf.nextInt();
    col = inf.nextInt();
    elevation = inf.nextInt();
    int temp = inf.nextInt();
    lake = new int[row][col];
    for(int x = 0; x < row; x++) { //builds array representing the pasture
      for(int y = 0; y < col; y++) {
        lake[x][y] = inf.nextInt();
      }
      inf.nextLine();
    }
    stomps = new int[temp][3]; //array with stomp digging instructions
    for(int x = 0; x < temp; x++){
      for(int y = 0; y < 3; y++){
        stomps[x][y] = inf.nextInt();
      }
      inf.nextLine();
    }
  }

  public static int bronze(String filename) throws FileNotFoundException{
    USACO solve = new USACO(filename);
    for(int x = 0; x < solve.stomps.length; x++){
      solve.stompDig(solve.stomps[x]);
    }
    int sum = 0;
    for(int x = 0; x < solve.row; x++) {
      for(int y = 0; y < solve.col; y++) {
        if( solve.elevation - solve.lake[x][y] > 0) sum+= solve.elevation - solve.lake[x][y];
      }
    }
    return sum * 72 * 72;
  }

  public void stompDig(int[] ins) {
    System.out.println(Arrays.toString(ins));
    int max = 0;
    for(int x = ins[0] - 1; x < ins[0]+2; x++) {
      for(int y = ins[1] - 1; y < ins[1]+2; y++) {
        if (lake[x][y] >= max) {
          max = lake[x][y];
        }
      }
    }
    max = max - ins[2];
    for(int x = ins[0] - 1; x < ins[0]+2; x++) {
      for(int y = ins[1] - 1; y < ins[1]+2; y++) {
        if (lake[x][y] > max) lake[x][y] = max;
      }
    }
  }


  // ------------------------ SILVER ----------------------- //







}
