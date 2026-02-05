import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CompareDataNode {
    static class LinkedList {
        Node head;

        class Node {
            int data;
            Node next;

            Node(int d) {
                data = d;
                next = null;
            }
        }

        public void append(int new_data) {
            Node new_node = new Node(new_data);

            if (head == null) {
                head = new Node(new_data);
                return;
            }

            new_node.next = null;

            Node last = head;
            while (last.next != null)
                last = last.next;

            last.next = new_node;
        }

        public void printList() {
            Node tnode = head;

            if(tnode != null)
            {
                int last = 0;
                int first = tnode.data;

                while (tnode != null) {
                    System.out.print(tnode.data + " ");
                    last = tnode.data;
                    tnode = tnode.next;
                }

                if (first != last)
                {
                    String display = String.format("[%s] = [%s] => FALSE", first, last);
                    System.out.println("\n" + display);
                }
                else
                {
                    String display = String.format("[%s] = [%s] => TRUE", first, last);
                    System.out.println("\n" + display);
                }

            }

            else
            {
                System.out.println("\nThe List is EMPTY");
            }
        }

        public static void main(String[] args) {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                boolean retry = true;

                LinkedList llist = new LinkedList();

                while (retry) {

                    int choice = 0;
                    boolean within = true;
                    while(within) {
                        System.out.println("Linked List Exam");
                        System.out.println("[1] - Add Node   [2] - Result");
                        System.out.print("Enter your choice: ");
                        String choices = in.readLine();

                        choice = Integer.parseInt(choices);

                        if (choice > 0 && choice < 3)
                        {
                            within = false;
                        }

                        else
                        {
                            System.out.println("Input is not within choices. Please try again.\n");
                        }
                    }

                    if (choice == 1) {
                        System.out.print("Enter score ");
                        String score = in.readLine();
                        int scoree = Integer.parseInt(score);

                        llist.append(scoree);
                    }

                    else
                    {

                        llist.printList();
                    }



                    System.out.print("\nTry again Y/N?: ");
                    String confirm = in.readLine();
                    if (!confirm.equalsIgnoreCase("Y")) {
                        retry = false;
                    }
                }

            } catch (Exception e) {
                System.out.println("Error Exception");

                e.printStackTrace();
            }
        }
    }
}
