import java.util.*;
import java.io.*;

class NQueens{
    public static int solutionCount = 0;
    public static List<List<String>> solution = new ArrayList<List<String>>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solveNQueens(n);
    }
    public static List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        solveNQueensHelper(board, 0);
        System.out.println(solutionCount);
        return solution;
    }
    public static int[][] placeQueen(int[][] board, int x, int y){
        int[][] result = copyMatrix(board);
        int n = board.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == x || j == y){
                    result[i][j] = -1;
                } else {
                    for(int k = 1; k < n; k++){
                        if((i == x + k || i == x - k) && (j == y + k || j == y - k)){
                            result[i][j] = -1;
                        }
                    }
                }
            }
        }
        result[x][y] = 1;
        return result;
    }
    public static void solveNQueensHelper(int[][] board, int row){
        int n = board.length;
        if(row >= n){
            if(findNqueens(board)){
                solutionCount++;
                solution.add(matrixToStrings(board));
            }
            return;
        }
        for(int j = 0; j < n; j++){
            if(board[row][j] == 0){
                int[][] newBoard = placeQueen(board, row, j);
                solveNQueensHelper(newBoard, row + 1);
            }
        }
    }
    public static void printMatrix(int[][] m){
        for(int i = 0; i < m.length; i++){
            System.out.println(Arrays.toString(m[i]));
        }
    }
    public static boolean findNqueens(int[][] board){
        int n = board.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 1){
                    count++;
                }
            }
        }
        return count == n;
    }
    public static int[][] copyMatrix(int[][] m){
        int[][] result = new int[m.length][m[0].length];
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[i].length; j++){
                result[i][j] = m[i][j];
            }
        }
        return result;
    }
    public static List<String> matrixToStrings(int[][] board){
        List<String> result = new ArrayList<String>();
        for(int i = 0; i < board.length; i++){
            String temp = "";
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 1){
                    temp += "Q";
                } else {
                    temp += ".";
                }
            }
            result.add(temp);
        }
        return result;
    }
}
