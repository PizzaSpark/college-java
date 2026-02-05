import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

public class infixPrefixPostfixConverter {

    public static class Node {
        char data;
        Node next;
        Node prev;

        public Node(char data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static class DoublyLinkedList {
        infixToPostfix.Node head;
        infixToPostfix.Node tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        //add node to beginning of the list char
        public void addFirst(char data) {
            infixToPostfix.Node node = new infixToPostfix.Node(data);
            if (head == null) {
                this.head = node;
                this.tail = node;
            } else {
                node.next = this.head;
                this.head.prev = node;
                this.head = node;
            }
        }

        //add to end
        public void addNode(char data) {
            infixToPostfix.Node node = new infixToPostfix.Node(data);
            if (head == null) {
                this.head = node;
                this.tail = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
                this.tail = node;
            }
        }

    }

    //precedence
    public static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }




    //convert infix to postfix
    public static String infixToPostfix(String exp) {
        String result = "";
        DoublyLinkedList stack = new DoublyLinkedList();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                result += c;
            } else if (c == '(') {
                stack.addFirst(c);
            } else if (c == ')') {
                while (!Objects.equals(stack.head.data, '(')) {
                    result += stack.head.data;
                    stack.head = stack.head.next;
                }
                stack.head = stack.head.next;
            } else {
                while (stack.head != null && precedence(c) <= precedence(stack.head.data)) {
                    result += stack.head.data;
                    stack.head = stack.head.next;
                }
                stack.addFirst(c);
            }
        }
        while (stack.head != null) {
            result += stack.head.data;
            stack.head = stack.head.next;
        }
        return result;
    }

    //postfix to infix
    public static String postfixToInfix(String exp) {
        DoublyLinkedList stack = new DoublyLinkedList();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                stack.addFirst(c);
            } else {
                String s1 = stack.head.data + "";
                stack.head = stack.head.next;
                String s2 = stack.head.data + "";
                stack.head = stack.head.next;
                String temp = "(" + s2 + c + s1 + ")";
                stack.addFirst(temp.charAt(0));
            }
        }
        return stack.head.data + "";
    }

    //infix to prefix
    public static String infixToPrefix(String exp) {
        String result = "";
        DoublyLinkedList stack = new DoublyLinkedList();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                result += c;
            } else if (c == '(') {
                stack.addFirst(c);
            } else if (c == ')') {
                while (!Objects.equals(stack.head.data, '(')) {
                    result += stack.head.data;
                    stack.head = stack.head.next;
                }
                stack.head = stack.head.next;
            } else {
                while (stack.head != null && precedence(c) <= precedence(stack.head.data)) {
                    result += stack.head.data;
                    stack.head = stack.head.next;
                }
                stack.addFirst(c);
            }
        }
        while (stack.head != null) {
            result += stack.head.data;
            stack.head = stack.head.next;
        }
        return result;
    }

    //prefix to infix
    public static String prefixToInfix(String exp) {
        DoublyLinkedList stack = new DoublyLinkedList();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                stack.addFirst(c);
            } else {
                String s1 = stack.head.data + "";
                stack.head = stack.head.next;
                String s2 = stack.head.data + "";
                stack.head = stack.head.next;
                String temp = "(" + s1 + c + s2 + ")";
                stack.addFirst(temp.charAt(0));
            }
        }
        return stack.head.data + "";
    }

    //prefix to postfix
    public static String prefixToPostfix(String exp) {
        DoublyLinkedList stack = new DoublyLinkedList();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                stack.addFirst(c);
            } else {
                String s1 = stack.head.data + "";
                stack.head = stack.head.next;
                String s2 = stack.head.data + "";
                stack.head = stack.head.next;
                String temp = s1 + s2 + c;
                stack.addFirst(temp.charAt(0));
            }
        }
        return stack.head.data + "";
    }

    //postfix to prefix
    public static String postfixToPrefix(String exp) {
        DoublyLinkedList stack = new DoublyLinkedList();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                stack.addFirst(c);
            } else {
                String s1 = stack.head.data + "";
                stack.head = stack.head.next;
                String s2 = stack.head.data + "";
                stack.head = stack.head.next;
                String temp = c + s2 + s1;
                stack.addFirst(temp.charAt(0));
            }
        }
        return stack.head.data + "";
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            String input = "Y";
            while (input.equalsIgnoreCase("Y")) {
                System.out.println("[1] Infix to Postfix [2] Postfix to Infix \n[3] Infix to Prefix [4] Prefix to Infix \n[5] Prefix to Postfix [6] Postfix to Prefix ");
                int num = Integer.parseInt(br.readLine());

                while (num < 1 || num > 6) {
                    System.out.println("Invalid input. Please try again.");
                    System.out.println("[1] Infix to Postfix [2] Postfix to Infix \n[3] Infix to Prefix [4] Prefix to Infix \n[5] Prefix to Postfix [6] Postfix to Prefix ");
                    num = Integer.parseInt(br.readLine());
                }

                switch (num) {
                    case 1:
                        System.out.println("Enter infix expression: ");
                        String infix = br.readLine();
                        System.out.println("Postfix expression: " + infixToPostfix(infix));
                        break;
                    case 2:
                        System.out.println("Enter postfix expression: ");
                        String postfix = br.readLine();
                        System.out.println("Infix expression: " + postfixToInfix(postfix));
                        break;
                    case 3:
                        System.out.println("Enter infix expression: ");
                        String infix2 = br.readLine();
                        System.out.println("Prefix expression: " + infixToPrefix(infix2));
                        break;
                    case 4:
                        System.out.println("Enter prefix expression: ");
                        String prefix = br.readLine();
                        System.out.println("Infix expression: " + prefixToInfix(prefix));
                        break;
                    case 5:
                        System.out.println("Enter prefix expression: ");
                        String prefix2 = br.readLine();
                        System.out.println("Postfix expression: " + prefixToPostfix(prefix2));
                        break;
                    case 6:
                        System.out.println("Enter postfix expression: ");
                        String postfix2 = br.readLine();
                        System.out.println("Prefix expression: " + postfixToPrefix(postfix2));
                        break;
                }

                System.out.println("Do you want to try again? (Y/N)");
                input = br.readLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
