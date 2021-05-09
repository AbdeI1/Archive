import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static int[] mem = new int[10000];
    public static void main(String args[]){
        //int coins[] = {186,419,83,408};
        //int amount = 6249;
        int coins[] = {3, 4, 5};
        int amount = 2;
        System.out.println(coinChange(coins, amount));
    }
    public static boolean coinChange(int[] coins, int amount){
        Arrays.fill(mem, -11);
        return coinChange2(0, coins, amount, 0);
    }
    public static boolean coinChange2(int start, int[] coins, int amount, int count){
        if (start >= coins.length){
            return amount == 0;
        } else {
            int n = coins[start];
            int new_start = start + 1;
            int div = amount/n;
            for(int i = 0; i <= div; i++){
                if(coinChange2(new_start, coins, amount - (i*n), count + i)){
                    return true;
                }
            }
        }
        return false;
    }
}