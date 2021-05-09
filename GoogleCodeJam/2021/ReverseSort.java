import java.util.Scanner;

class ReverseSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for(int casenum = 1; casenum < tests + 1; casenum++){
            int n = sc.nextInt();
            int[] l = new int[n];
            for(int i = 0; i < n; i++){
                l[i] = sc.nextInt();
            }
            int cost = 0;
            for(int i = 0; i < n - 1; i++){
                int j = minIndex(l, i);
                cost += (j - i + 1);
                int[] r = reverse(l, i, j);
                int index = 0;
                for(int s = i; s < j + 1; s++){
                    l[s] = r[index];
                    index++;
                }
            }
            System.out.println("Case #" + casenum + ": " + cost);
        }
    }
    public static int minIndex(int[] l, int start){
        int min = l[start];
        int index = start;
        for(int i = start; i < l.length; i++){
            if(Math.min(min, l[i]) == l[i]){
                min = l[i];
                index = i;
            }
        }
        return index;
    }
    public static int[] reverse(int[] l, int start, int end){
        int[] r = new int[end - start + 1];
        int index = 0;
        for(int i = end; i > start - 1; i--){
            r[index] = l[i];
            index++;
        }
        return r;
    }
}
