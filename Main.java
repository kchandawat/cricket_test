import java.util.Random;
import java.util.Scanner;

public class Main {
   static int over=2;

    private static boolean toss(){
        System.out.println("Choose 1.Heads or 2.Tails: ");
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int choice = scan.nextInt();
        if (choice >=1 && choice<=2) {
        
        int x = rand.nextInt(2)+1;
        if (choice == x) return true;
        else return false;
        }
        
    else {
        System.out.println("Wrong choice choose between only [1-2]\n"); 
        return toss();} 
    }
    private static void startGame(){
        System.out.println("Choose \n1.Start Game \n2.Exit \n");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if (choice == 1) {}
        else if (choice == 2) {System.exit(0);}
        else {System.out.println("Wrong choice \n"); startGame();} 
    }
    
    private static void setOver(){
        System.out.println("\nChoose number of overs \n1. 1 Over Game \n2. 2 Over Game \n3. 3 Over Game \n4. 4 Over Game \n");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if (choice >= 1 && choice<=4) {over=choice;}
        else {System.out.println("Wrong choice \n"); setOver();}
    }

    private static int ball_bot() {
        Random rand = new Random();
        int x = rand.nextInt(6)+1;
        return x;
    }

    private static int ball_player() {
        System.out.println("Choose a number from 1 to 6: ");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if(choice>=1 && choice<=6)
        {
        return choice;
        }
        else
        {
            System.out.println("Please! Choose only numbers between [1-6]");
            return ball_player();
        }
    }

    public static void main(String[] args) {
        System.out.println(":::::::::::Welcome to Hand Cricket:::::::::::\n");
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        startGame();
        setOver();
        int player = 0, bot = 0, balls = 0, t1, t2, first, second = 0,fours=0,sixes=0;
        String bowling, batting;
        boolean out = false;
        if (toss()){
            System.out.println("::::::::::Congrats! You won the toss::::::::::");
             
            
            System.out.println("Do you want to choose 1.Bowling or 2.Batting: ");
           int ch=scan.nextInt();
            if (ch == 1){
                bowling = "player";
                batting = "bot";
                 
            }
            else if(ch==2){
                bowling = "bot";
                batting = "player";
                 
            }else{
            System.out.println("Please! You only choose numbers between [1-2] hence we're assigning you bowling");
                bowling = "player";
                batting = "bot";
            }
           
        }
        else{
            System.out.println(":::::::::::Oops! You lost the toss::::::::::::");
            if (rand.nextInt(2)+1 == 1){
                bowling = "bot";
                batting = "player";
            }
            else {
                bowling = "player";
                batting = "bot";
            }
        }
        if (bowling == "player") System.out.println("\n:::::::::::::::You are Bowling::::::::::::::::");
        else System.out.println("\n:::::::::::::::You are Batting::::::::::::::::");
        while(!out && balls<over*6){
            t1 = ball_bot();
            t2 = ball_player();
            if (t1 != t2){
                if (bowling == "player") {bot += t1; 
                if(t1==4)fours++;else if(t1==6)sixes++;
                System.out.println("\n::::::::::::::: Runs scored: "+t1+" ::::::::: Bot Score: "+bot+" ::::::: Balls Left: "+(over*6-(balls+1))+" :::::::");
                }
                else {player += t2;
                if(t2==4)fours++;else if(t2==6)sixes++;
                    System.out.println("\n::::::::::::::: Runs scored: "+t2+" ::::::::: Your Score: "+player+" ::::::: Balls Left: "+(over*6-(balls+1))+" :::::::");
                }
            }
            else {out = true; System.out.println("\n:::::::::::::::THAT'S AN OUT!::::::::::::::::");}
            balls++;
        }
        if (bowling == "player") {
            bowling = "bot";
            batting = "player";
            first = bot;
            System.out.println("\n:::::::::::::::Bot scored: "+bot+"::::::::::::::::");
            System.out.println("\n::::::::::::::: Boundaries "+fours+" ::::::::::::::: sixes "+sixes+" :::::::::::::::: ");
            System.out.println("\n:::::::::::::::You are Batting::::::::::::::::");
        }
        else {
            bowling = "player";
            batting = "bot";
            first = player;
            System.out.println("\n:::::::::::::::You scored: "+player+"::::::::::::::::");
            System.out.println("\n::::::::::::::: Boundaries "+fours+" ::::::::::::::: sixes "+sixes+" :::::::::::::::: ");
            System.out.println("\n:::::::::::::::You are Bowling::::::::::::::::");
        }
        out = false;
        fours=0;
        sixes=0;
        balls=0;
        while(!out && balls<over*6 && first>=second) {
            t1 = ball_bot();
            t2 = ball_player();
            if (t1 != t2){
                if (bowling == "player") {
                    bot += t1;
                    second += t1;
                    if(t1==4)fours++;else if(t1==6)sixes++;
                    System.out.println("\n::::::::::::::: Runs scored: "+t1+" ::::::::: Bot Score: "+bot+" ::::::: Balls Left: "+(over*6-(balls+1))+" :::::::");
                }
                else {
                    player += t2;
                    second += t2;
                    if(t2==4)fours++;else if(t2==6)sixes++;
                    System.out.println("\n::::::::::::::: Runs scored: "+t2+" ::::::::: Your Score: "+player+" ::::::: Balls Left: "+(over*6-(balls+1))+" :::::::");
                }
            }
            else {out = true; System.out.println("\n:::::::::::::::THAT'S AN OUT!::::::::::::::::");}
            balls++;
        }
        if (bowling == "player") {
            System.out.println("\n::::::::::::::: Boundaries "+fours+" ::::::::::::::: sixes "+sixes+" :::::::::::::::: ");
            System.out.println("\n:::::::::::::::Bot scored: "+bot+"::::::::::::::::");
            System.out.println("\n:::::::::::::::You scored: "+player+"::::::::::::::::\n");
            if(first>=second) System.out.println("::::::::::::::::::You Won::::::::::::::::::::");
            else System.out.println("::::::::::::::::::Bot Won::::::::::::::::::::");
        }
        else {
            System.out.println("\n:::::::::::::::2ND INNING'S Boundaries "+fours+" ::::::::::::::: Sixes "+sixes+" :::::::::::::::: ");
            System.out.println("\n:::::::::::::::You scored: "+player+"::::::::::::::::");
            System.out.println("\n:::::::::::::::Bot scored: "+bot+"::::::::::::::::\n");
            if(first>=second) System.out.println("::::::::::::::::::Bot Won::::::::::::::::::::");
            else System.out.println("::::::::::::::::::You Won::::::::::::::::::::");
        }

    }

}
