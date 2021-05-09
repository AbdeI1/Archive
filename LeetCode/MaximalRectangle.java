import java.io.*;
import java.util.*;

class MaximalRectangle{
  public static void main(String[] args){
    char[][] matrix =
   {{'1','1','1','1','1','1','1','1'},
    {'1','1','1','1','1','1','1','0'},
    {'1','1','1','1','1','1','1','1'},
    {'1','1','1','1','1','0','0','0'},
    {'0','1','1','1','1','0','0','0'}};
    int result = maximalRectangle(matrix);
    System.out.println(result);
  }
  public static int maximalRectangle(char[][] matrix) {
    int result = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == '1') {
          int hsize = 0;
          while (j + hsize < matrix[0].length && matrix[i][j + hsize] == '1') {
            int vsize = 1;
            while (i + vsize < matrix.length && noZeroesR(matrix, i + vsize, j, j + hsize + 1)) {
              vsize++;
            }
            int size = (hsize+1)*vsize;
            result = Math.max(result, size);
            hsize++;
          }
        }
      }
    }
    return result;
  }
  public static boolean noZeroesR(char[][] matrix, int row, int start, int end){
    for(int i = start; i < end; i++){
      if(matrix[row][i] == '0'){
        return false;
      }
    }
    return true;
  }
}
