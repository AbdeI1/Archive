import java.util.*;
import java.io.*;

class AppendSort{                                 // Only works with integers, not with bigger numbers
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for(int casenum = 1; casenum < tests + 1; casenum++){
            int n = sc.nextInt();
            int[] list = new int[n];
            for(int i = 0; i < n; i++){
                list[i] = sc.nextInt();
            }
            int count = 0;
            for(int i = 1; i < n; i++){
                if(list[i - 1] >= list[i]){
                    if(countDigits(list[i - 1]) == countDigits(list[i])){
                        count++;
                        list[i] *= 10;
                    } else {
                        int temp1 = list[i - 1] + 1;
                        int temp2 = list[i];
                        int t = 1;
                        while(countDigits(temp1) > countDigits(temp2)){
                            temp2 *= 10;
                            t *= 10;
                            count++;
                        }
                        int temp3 = temp1 - temp2;
                        if(temp3 < 0){
                            list[i] = temp2;
                        } else if (temp3 >= t){
                            count++;
                            temp2 *= 10;
                            list[i] = temp2;
                        } else {
                            list[i] = temp2 + temp3;
                        }
                    }
                }
            }
            System.out.println("Case #" + casenum + ": " + count);
        } 
    }
    public static int countDigits(int n){
        int count = 1;
        while(n >= 10){
            count++;
            n /= 10;
        }
        return count;
    }
}
