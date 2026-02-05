import java.util.Objects;

public class infixToPostfix {

    // linkedlist node infix to postfix
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

        // add node to beginning of the list char
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

        // add to end
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

    // precedence
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

    // convert infix to postfix
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

    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
    }
}
