import java.io.BufferedReader;
import java.io.InputStreamReader;

public class stack {
    public static class Stack {
        int top;
        int[] stack;
        int size;

        public Stack(int size) {
            this.top = -1;
            this.stack = new int[size];
            this.size = size;
        }

        //push
        public void push(int data) {
            if (top == size - 1) {
                System.out.println("Stack overflow");
            } else {
                top++;
                stack[top] = data;
            }
        }

        //pop
        public int pop() {
            if (top == -1) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                int temp = stack[top];
                top--;
                return temp;
            }
        }

        //peek
        public int peek() {
            if (top == -1) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return stack[top];
            }
        }

        //isEmpty
        public boolean isEmpty() {
            return top == -1;
        }

        //display
        public void display() {
            if (top == -1) {
                //System.out.println("Stack underflow");
                System.out.println("\nStack is EMPTY");
            } else {
                System.out.println("\nStack:");
                for (int i = top; i >= 0; i--) {
                    System.out.println(stack[i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            String input = "Y";
            while (input.equalsIgnoreCase("Y")) {
                System.out.println("[1] Push [2] Pop [3] Peek [4] Display ");
                int num = Integer.parseInt(br.readLine());

                while (num < 1 || num > 4) {
                    System.out.println("Invalid input. Please try again.");
                    System.out.println("[1] Push [2] Pop [3] Peek [4] Display ");
                    num = Integer.parseInt(br.readLine());
                }

                switch (num) {
                    case 1:
                        if(stack.top == stack.size - 1){
                            System.out.println("Stack overflow");
                        }
                        else{
                            System.out.println("Enter number to push");
                            int num1 = Integer.parseInt(br.readLine());
                            stack.push(num1);
                        }
                        break;
                    case 2:
                        System.out.println("Popped: " + stack.pop());
                        break;
                    case 3:
                        System.out.println("Peeked: " + stack.peek());
                        break;
                    case 4:
                        stack.display();
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
