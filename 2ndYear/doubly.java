import java.io.BufferedReader;
import java.io.InputStreamReader;

public class doubly {

    //doubly linked list node
    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    //doubly linked list
    public static class DoublyLinkedList {
        Node head;
        Node tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        //add node to beginning of the list
        public void addFirst(int data) {
            Node node = new Node(data);
            if (head == null) {
                this.head = node;
                this.tail = node;
            } else {
                node.next = this.head;
                this.head.prev = node;
                this.head = node;
            }
        }

        //add node at specified position
        public void addAt(int data, int pos) {
            Node node = new Node(data);
            if (pos == 0) {
                addFirst(data);
            } else {
                Node temp = this.head;
                for (int i = 0; i < pos - 1; i++) {
                    temp = temp.next;
                }
                node.next = temp.next;
                if (temp.next != null) {
                    temp.next.prev = node;
                }
                temp.next = node;
                node.prev = temp;
            }
        }

        //add node to the end of the list
        public void addNode(int data) {
            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }

        //delete node at the beginning of the list
        public void deleteFirst() {
            if (head == null) {
                System.out.println("List is empty");
            } else {
                if (head.next == null) {
                    head = null;
                    tail = null;
                } else {
                    head = head.next;
                    head.prev = null;
                }
            }
        }

        //delete node at the end of the list
        public void deleteLast() {
            if (head == null) {
                System.out.println("List is empty");
            } else {
                if (head.next == null) {
                    head = null;
                    tail = null;
                } else {
                    tail = tail.prev;
                    tail.next = null;
                }
            }
        }

        //delete node at specified position
        public void deleteAt(int pos) {
            if (pos == 0) {
                deleteFirst();
            } else {
                Node temp = this.head;
                for (int i = 0; i < pos - 1; i++) {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                if (temp.next != null) {
                    temp.next.prev = temp;
                }
            }
        }


        //print the list
        public void printList() {
            Node current = head;
            if(head == null){
                System.out.println("List is empty");
            }
            else{
                System.out.print("List: ");
                while (current != null) {
                    System.out.print(current.data + " ");
                    current = current.next;
                }
                System.out.println();
            }
        }

        //print the list backwards
        public void printListBackwards() {
            Node current = tail;
            if(head == null){
                System.out.println("List is empty");
            }
            else{
                System.out.print("List: ");
                while (current != null) {
                    System.out.print(current.data + " ");
                    current = current.prev;
                }
                System.out.println();
            }
        }

        //method for getting length of list
        public int getLength() {
            Node current = head;
            int count = 0;
            while (current != null) {
                count++;
                current = current.next;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        //bufferedreader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            String input = "Y";
            while (input.equalsIgnoreCase("Y")) {
                System.out.println("[1] Add Beg [2] Add at Position [3] Add at End [4] Show forward [5] Show backward \n[6] Delete First Node [7] Delete Specified Node [8] Delete Last Node  ");
                int num = Integer.parseInt(br.readLine());

                while (num < 1 || num > 8) {
                    System.out.println("Invalid input. Please try again.");
                    System.out.println("[1] Add Beg [2] Add at Position [3] Add at End [4] Show forward [5] Show backward \n[6] Delete First Node [7] Delete Specified Node [8] Delete Last Node  ");
                    num = Integer.parseInt(br.readLine());
                }

                switch (num) {
                    case 1:
                        System.out.println("Enter number to add at beginning");
                        int num1 = Integer.parseInt(br.readLine());
                        list.addFirst(num1);
                        break;
                    case 2:
                        System.out.println("Enter number to add at position");
                        int num2 = Integer.parseInt(br.readLine());
                        System.out.println("Enter position");
                        int pos = Integer.parseInt(br.readLine());
                        pos -=1;
                        //if position is less than 0, add to beginning and if position is greater than length of list, add to end

                        if (pos < 0)
                        {
                            list.addFirst(num2);
                        } else if (pos > list.getLength())
                        {
                            list.addNode(num2);
                        } else {
                            list.addAt(num2, pos);
                        }
                        break;
                    case 3:
                        System.out.println("Enter number to add at end");
                        int num3 = Integer.parseInt(br.readLine());
                        list.addNode(num3);
                        break;
                    case 4:
                        list.printList();
                        break;
                    case 5:
                        list.printListBackwards();
                        break;
                    case 6:
                        list.deleteFirst();
                        break;
                    case 7:
                        System.out.println("Enter position to delete");
                        int num4 = Integer.parseInt(br.readLine());
                        num4 -=1;
                        list.deleteAt(num4);
                        break;
                    case 8:
                        list.deleteLast();
                        break;
                    default:
                        System.out.println("Invalid input");
                }

                System.out.println("Do you want to try again? (Y/N)");
                input = br.readLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
