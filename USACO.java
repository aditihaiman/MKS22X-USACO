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
    } //by this point, all stomp digging is finished
    int sum = 0;
    for(int x = 0; x < solve.row; x++) { //adds up elevations in the lake
      for(int y = 0; y < solve.col; y++) {
        if( solve.elevation - solve.lake[x][y] > 0) sum+= solve.elevation - solve.lake[x][y];
      }
    }
    return sum * 72 * 72;
  }

  public void stompDig(int[] ins) {
    //System.out.println(Arrays.toString(ins));
    int max = 0;
    for(int x = ins[0] - 1; x < ins[0]+2; x++) { //finds the largest value within stompdigging area
      for(int y = ins[1] - 1; y < ins[1]+2; y++) {
        if (lake[x][y] >= max) {
          max = lake[x][y];
        }
      }
    }
    max = max - ins[2]; //replacing all proper values with the new elevation
    for(int x = ins[0] - 1; x < ins[0]+2; x++) {
      for(int y = ins[1] - 1; y < ins[1]+2; y++) {
        if (lake[x][y] > max) lake[x][y] = max;
      }
    }
  }


  // ------------------------ SILVER ----------------------- //

  // public int[][] field;
  // public int row1, col1, sec;
  // public int[] start, end;

  // public void readFile(String filename) throws FileNotFoundException{
  //   File text = new File(filename);
  //   Scanner inf = new Scanner(text);
  //   row1 = inf.nextInt();
  //   col1 = inf.nextInt();
  //   sec = inf.nextInt();
  //   field = new int[row1][col1];
  //   for(int x = 0; x < row1; x++){
  //     for(int y = 0; y < col1; y++){
  //       field[x][y] = inf.nextInt();
  //     }
  //     inf.nextLine();
  //   }
  //   start = new int[2];
  //   end = new int[2];
  //   start[0] = inf.nextInt();
  //   start[1] = inf.nextInt();
  //   end[0] = inf.nextInt();
  //   end[1] = inf.nextInt();
  // }

  public static int silver(String filename) throws FileNotFoundException{
    //reading in file//
    File text = new File(filename);
    Scanner inf = new Scanner(text);
    int row1 = inf.nextInt();
    int col1 = inf.nextInt();
    int sec = inf.nextInt();
    int[][] field = new int[row1][col1];
    for(int x = 0; x < row1; x++){
      String temp = inf.next();
      for(int y = 0; y < col1; y++){
        if(temp.charAt(y)=='.') field[x][y] = 0;
        else field[x][y] = -1;
      }
      inf.nextLine();
    }
    int[] start = {inf.nextInt()-1, inf.nextInt()-1};
    int[] end = {inf.nextInt()-1, inf.nextInt()-1};

  //  System.out.println(Arrays.deepToString(field));


    field[start[0]][start[1]] = 1; //sets up starting position

    int[][] temp = new int[row1][col1]; //temp array so that everything updates at once
    for(int t = 0; t < sec; t++) { //for each second
      copy(temp, field, row1, col1); //update the temp array
      for(int a = 0; a < row1; a++){ //loop through field
        for(int b = 0; b < col1; b++){
          updateField(row1, col1, a, b, temp, field);
        }
      }
    }
    return field[end[0]][end[1]];
  }

  public static void updateField(int row1, int col1, int x, int y, int[][] temp, int[][] field){
    if(temp[x][y]!=-1) {
      int sum = 0; //creates sum of values above/below and right/left of given coordinates
      if(x+1 < row1 && temp[x+1][y]!=-1) sum+= temp[x+1][y];
      if(x-1 > -1 && temp[x-1][y]!=-1) sum+= temp[x-1][y];
      if(y+1 < col1 && temp[x][y+1]!=-1) sum+= temp[x][y+1];
      if(y-1 > -1 && temp[x][y-1]!=-1) sum+= temp[x][y-1];
      field[x][y] = sum;
    }
  }

  public static void copy(int[][] temp, int[][] field, int row1, int col1){
    for(int x = 0; x < row1; x++){
      for(int y = 0; y < col1; y++) {
        temp[x][y] = field[x][y];
      }
    }
  }





}
