import java.util.Scanner;

class MoonUmbrellas{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for(int casenum = 1; casenum < tests + 1; casenum++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            String s = sc.next();
            int cost = 0;
            int i = 0;
            while(i < s.length()){
                if(s.charAt(i) == 'C'){
                    while(i < s.length()){
                        if(s.charAt(i) == 'J'){
                            cost += x;
                            i--;
                            break;
                        }
                        i++;
                    }
                }
                else if(s.charAt(i) == 'J'){
                    while(i < s.length()){
                        if(s.charAt(i) == 'C'){
                            cost += y;
                            i--;
                            break;
                        }
                        i++;
                    }
                }
                i++;
            }
            System.out.println("Case #" + casenum + ": " + cost);
        } 
    }
}