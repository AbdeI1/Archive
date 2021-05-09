import java.util.Scanner;

public class SolitaireDriver {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String input;
        Solitaire s = new Solitaire();
        while(true){
            input = scan.nextLine();
            if(input.equals("end")){
                break;
            }
            else{
                switch(input){
                    case "visualize":
                        break;
                    case "draw":
                        s.draw();
                        break;
                    case "move":
                        Scanner intScan = new Scanner(System.in);
                        int f;
                        int t;
                        System.out.println("Enter the number of the first pile");
                        f = intScan.nextInt();
                        System.out.println("Enter the number of the second pile");
                        t = intScan.nextInt();
                        try {
                            s.move(f, t);
                        } catch(IllegalStateException x){
                            System.out.println("Move not allowed (" + x + ")");
                        }
                        break;
                    case "move stack":
                        Scanner intScan2 = new Scanner(System.in);
                        int f2;
                        int t2;
                        System.out.println("Enter the number of the first pile");
                        f2 = intScan2.nextInt();
                        System.out.println("Enter the number of the second pile");
                        t2 = intScan2.nextInt();
                        try {
                            s.moveStack(f2, t2);
                        } catch(IllegalStateException x){
                            System.out.println("Move not allowed (" + x + ")");
                        }
                        break;
                    case "move to set":
                        Scanner intScan3 = new Scanner(System.in);
                        int p;
                        System.out.println("Enter the number of the pile you want to move take from");
                        p = intScan3.nextInt();
                        try{
                            s.moveToSet(p);
                        } catch(IllegalStateException x){
                            System.out.println("Move not allowed (" + x + ")");
                        }
                        break;
                    default:
                        System.out.println("I did not get that, try again");
                        break;
                }
                s.visualize();
                if(s.checkWin()){
                    System.out.println("You Win!");
                    break;
                }
            }
        }
    }

}
