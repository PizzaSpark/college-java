import java.util.Scanner;

public class attemptInFormattingCode {

    // asks for input where we send the whole code and if a bracket is detected, it
    // will make the rest into another line and after the bracket is another line
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String code = sc.nextLine();
        String[] codeArray = code.split("");
        for (int i = 0; i < codeArray.length; i++) {
            if (codeArray[i].equals("{")) {
                System.out.println();
                System.out.println(codeArray[i]);
            } else if (codeArray[i].equals("}")) {
                System.out.println();
                System.out.println(codeArray[i]);
            } else {
                System.out.print(codeArray[i]);
            }
        }
    }

}
