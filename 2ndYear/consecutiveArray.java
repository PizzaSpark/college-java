public class consecutiveArray {
    public static void main(String[] args) {

        int[] arr = { 5, 6, 5, 9, 8, 7, 6, 5 };
        int temp = arr.length;
        int[] temparr = new int[temp];
        int count = temp;
        int counter = 0;

        for (int i = 0; i < temp; i++) {
            temparr[i] = arr[count - 1];
            count--;
        }
        for (int i = 0; i < temp; i++) {
            if (arr[i] == temparr[i]) {
                counter++;
            } else {
                break;
            }
        }
        System.out.println(counter);
    }
}
