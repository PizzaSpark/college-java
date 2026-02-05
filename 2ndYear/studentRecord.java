import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class studentRecord
{
    public static void main(String[] args)
    {
        try
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            LinkedList<String> record = new LinkedList<>();

            boolean retry = true;

            while (retry)
            {

                if (record.isEmpty())
                {
                    System.out.println("\nStudent record is empty");
                }

                else
                {
                    System.out.println("\n\n\nStudent Record Linked List");
                    for (int i = 0; i < record.size(); i++)
                    {
                        String temp = String.format(" [%s] %s ", i+1 , record.get(i));
                        System.out.println(temp);
                    }
                }

                int choice = 0;
                boolean within = true;
                while(within)
                {

                    System.out.println("\nPick from the choices");
                    System.out.println("[1] - Add in the beginning");
                    System.out.println("[2] - Add in the picked position");
                    System.out.println("[3] - Add at the very end");
                    System.out.print("\nEnter Your Choice: ");
                    String choices = in.readLine();
                    choice = Integer.parseInt(choices);

                    if (choice > 0 && choice < 4)
                    {
                        within = false;
                    }

                    else
                    {
                        System.out.println("Input is not within choices. Please try again.");
                    }
                }

                System.out.print("\nEnter Student Name: ");
                String student = in.readLine();
                System.out.print("Enter Course: ");
                String course = in.readLine();
                System.out.print("Enter Year: ");
                String year = in.readLine();

                String studRec = String.format("%s %s %s", student, course, year);

                if (choice == 1)
                {
                    record.addFirst(studRec);
                }

                else if (choice == 2)
                {
                    if (record.size() == 0)
                    {
                        System.out.println("No student records are in the list yet");
                        System.out.println("Therefore input will be automatically added");
                        record.add(studRec);
                    }

                    else {
                        boolean bounds = true;
                        while (bounds) {

                            System.out.print("Enter Position: ");
                            String position = in.readLine();
                            int index = Integer.parseInt(position) - 1;

                            if (index > record.size() || index <= -1) {
                                System.out.println("Inputted position is not available.");
                                System.out.println("Please input again.");
                            } else {
                                record.add(index, studRec);
                                bounds = false;
                            }
                        }
                    }
                }

                else if (choice == 3)
                {
                    record.addLast(studRec);
                }

                System.out.println("\n\nStudent Record Linked List");
                for (int i = 0; i < record.size(); i++)
                {
                    String temp = String.format(" [%s] %s ", i+1 , record.get(i));
                    System.out.println(temp);
                }

                System.out.print("\nTry again Y/N?: ");
                String confirm = in.readLine();
                if (!confirm.equalsIgnoreCase("Y"))
                {
                    retry = false;
                }

            }
        }

        catch (Exception e)
        {
            System.out.println("Error Exception");
        }
    }
}