import java.util.Scanner;

public class robot
{

    static int x =0;
    static int y= 0;

    static int xR = 0;
    static int yR = 0;

    static Boolean resume = true;

    static String arr[][]= new String[5][40];

    public static void map()
    {
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 40; j++)
            {
                arr[i][j] = "=";
            }
        }
    }
    public static void printMap()
    {
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 40; j++)
            {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    public static void coords()
    {
        x = (int) (Math.random() * 41);
        y = (int) (Math.random() * 5);
    }
    public static void spawnHazard()
    {
        int counter = 10;
        for (int i = 0; i < counter ; i++)
        {
            coords();

            if (arr[y][x] != "X")
            {
                arr[y][x] = "X";
            }

            else
            {
                counter++;
            }
        }
    }

    public static void spawnRobot()
    {
        int counter = 1;
        for (int i = 0; i < counter ; i++)
        {
            coords();

            if (arr[y][x] != "X")
            {
                arr[y][x] = "R";
                xR = x;
                yR = y;
            }

            else
            {
                counter++;
            }
        }
    }

    public static void spawnCasualty()
    {
        int counter = 1;
        for (int i = 0; i < counter ; i++)
        {
            coords();

            if (arr[y][x] != "X" || arr[y][x] != "R")
            {
                arr[y][x] = "C";
            }

            else
            {
                counter++;
            }
        }
    }

    //method make robot move up
    public static void moveUp()
    {
        if (arr[yR-1][xR] == "C")
        {
            System.out.println("Casualty detected");
            System.out.println("Rescue successful");
            resume = false;
        }
        else if (arr[yR-1][xR] != "X")
        {
            arr[yR][xR] = "=";
            yR--;
            arr[yR][xR] = "R";
        }
        else if (arr[yR-1][xR] == "X")
        {
            System.out.println("Hazard detected");
        }
    }

    //method make robot move down
    public static void moveDown()
    {
        if (arr[yR+1][xR] == "C")
        {
            System.out.println("Casualty detected");
            System.out.println("Rescue successful");
            resume = false;
        }
        else if (arr[yR+1][xR] != "X")
        {
            arr[yR][xR] = "=";
            yR++;
            arr[yR][xR] = "R";
        }
        //else if casualty is detected

        else if (arr[yR+1][xR] == "X")
        {
            System.out.println("Hazard detected");
        }
    }

    //method make robot move left
    public static void moveLeft()
    {
        if (arr[yR][xR-1] == "C")
        {
            System.out.println("Casualty detected");
            System.out.println("Rescue successful");
            resume = false;
        }
        else if (arr[yR][xR-1] != "X")
        {
            arr[yR][xR] = "=";
            xR--;
            arr[yR][xR] = "R";
        }
        //else if casualty is detected

        else if (arr[yR][xR-1] == "X")
        {
            System.out.println("Hazard detected");
        }
    }

    //method make robot move right
    public static void moveRight()
    {
        if (arr[yR][xR+1] == "C")
        {
            System.out.println("Casualty detected");
            System.out.println("Rescue successful");
            resume = false;
        }
        else if (arr[yR][xR+1] != "X")
        {
            arr[yR][xR] = "=";
            xR++;
            arr[yR][xR] = "R";
        }

        else if (arr[yR][xR+1] == "X")
        {
            System.out.println("Hazard detected");
        }
    }

    public static void main(String[] args)
    {
        try {

            String confirmation = "Y";
            while (confirmation.equalsIgnoreCase("Y")) {
                Scanner input = new Scanner(System.in);
                map();
                spawnHazard();
                spawnRobot();
                spawnCasualty();


                while (resume) {
                    printMap();
                    System.out.println("Enter a direction to move: ");
                    String direction = input.nextLine();

                    switch (direction) {
                        case "U":
                            moveUp();
                            break;
                        case "D":
                            moveDown();
                            break;
                        case "L":
                            moveLeft();
                            break;
                        case "R":
                            moveRight();
                            break;
                        default:
                            System.out.println("Invalid input");
                            break;
                    }
                }
                System.out.println("Do you want to try again? (Y/N)");
                confirmation = input.nextLine();
            }
        }
        catch (Exception e)
        {
            System.out.println("Error");
        }
    }
}