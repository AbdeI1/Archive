import java.util.Scanner;

class ReverseSortEngineering{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for(int casenum = 1; casenum < tests + 1; casenum++){
            int n = sc.nextInt();
            int c = sc.nextInt();
            String result = "";
            if(c < n - 1 || c > (((n + 1)*n)/2) - 1){
                result = "IMPOSSIBLE ";
            } else {
                int[] res = new int[n];
                for(int i = 1; i < n + 1; i++){
                    res[i - 1] = i;
                }
                int rem = c - n + 1;
                int left = 0;
                int size = n - 1;
                int rcount = 0;
                while(rem > 0){
                    int index = Math.min(rem, size);
                    reverse(res, left, left + index);
                    if(rcount%2 == 1){
                        left++;
                    }
                    rcount++;
                    size--;
                    rem -= index;
                }
                for(int i = 0; i < n; i++){
                    result += res[i] + " ";
                }
            }
            System.out.println("Case #" + casenum + ": " + result.substring(0, result.length() - 1));
        }
    }
    public static void reverse(int[] l, int start, int end){
        int[] r = new int[end - start + 1];
        int index = 0;
        for(int i = end; i > start - 1; i--){
            r[index] = l[i];
            index++;
        }
        index = 0;
        for(int s = start; s < end + 1; s++){
            l[s] = r[index];
            index++;
        }
    }
}

// 1 2 3 4 5 6 7
// rem = 27 - 7 + 1 = 21
// size = 7 - 1 = 6
// index = 6
// reverse(0, 6)
// 7 6 5 4 3 2 1
// rem = 15
// size = 5
// index = 5
// reverse(0, 5)
// 2 3 4 5 6 7 1
// rem = 10
// size = 4
// index = 4
// reverse(1, 5)
// 2 7 6 5 4 3 1
// rem = 6
// size = 3
// index = 3
// reverse(1, 4)
// 2 4 5 6 7 3 1
// rem = 3
// size = 2
// index = 2
// reverse(2, 4)
// 2 4 7 6 5 3 1
// rem = 1
// size = 1
// index = 1
// reverse(2, 3)
// 2 4 6 7 5 3 1

