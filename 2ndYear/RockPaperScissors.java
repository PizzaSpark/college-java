import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RockPaperScissors {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = "Y";
            while (input.equalsIgnoreCase("Y")) {

                String choice = "";
                while (!choice.equalsIgnoreCase("R") && !choice.equalsIgnoreCase("P") && !choice.equalsIgnoreCase("S")) {
                    System.out.println("Enter your play: R, P, or S ");
                    choice = br.readLine();
                }

                //random number generator 1-3
                int rand = (int) (Math.random() * 3) + 1;

                //switch case 1-3
                switch (rand) {
                    case 1:
                        System.out.println("Computer played Rock");
                        if (choice.equalsIgnoreCase("R")) {
                            System.out.println("Tie");
                        } else if (choice.equalsIgnoreCase("P")) {
                            System.out.println("You win");
                        } else {
                            System.out.println("You lose");
                        }
                        break;
                    case 2:
                        System.out.println("Computer played Paper");
                        if (choice.equalsIgnoreCase("R")) {
                            System.out.println("You lose");
                        } else if (choice.equalsIgnoreCase("P")) {
                            System.out.println("Tie");
                        } else {
                            System.out.println("You win");
                        }
                        break;
                    case 3:
                        System.out.println("Computer played Scissors");
                        if (choice.equalsIgnoreCase("R")) {
                            System.out.println("You win");
                        } else if (choice.equalsIgnoreCase("P")) {
                            System.out.println("You lose");
                        } else {
                            System.out.println("Tie");
                        }
                        break;
                }
            }
        }

        catch (Exception e) {
            System.out.println(e);
        }

    }
}
