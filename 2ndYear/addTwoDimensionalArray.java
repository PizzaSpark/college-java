import java.util.Arrays;
public class addTwoDimensionalArray {
    public static void main(String[] args) {

        int[][] arr = {
                {9,9,9,9,9},
                {9,9,9}};

        //maximum length array

        int temp = 0;

        if (arr[0].length > arr[1].length) {
            temp = arr[0].length;
        }

        else {
            temp = arr[1].length;
        }

        int[] temp1 = new int[temp];
        int[] temp2 = new int[temp];
        int[] tempSum = new int[temp];
        int[] sumFinal = new int[temp + 1];


        //transfer values to temp
        System.arraycopy(arr[0], 0, temp1, 0, arr[0].length);
        System.arraycopy(arr[1], 0, temp2, 0, arr[1].length);


        //computation

        for (int i = 0; i < temp-1; i++) {
            int total = temp1[i] + temp2[i];

            if (total > 19) {
                total -= 20;
                temp1[i+1] += 2;
            }

            else if (total > 9) {
                total -= 10;
                temp1[i+1] += 1;
            }
            tempSum[i] = total;
        }

        //printing with sorting

        System.out.print("2D Array \t = ");
        System.out.print(Arrays.deepToString(arr));

        System.out.println();
        System.out.print("Sum \t = ");

        int finalValueArray = ((temp1[temp-1])+(temp2[temp-1]));

        if (finalValueArray > 19) {
            tempSum[temp-1] = finalValueArray - 20;

            System.arraycopy(tempSum, 0, sumFinal, 0, temp);

            sumFinal[temp] = 2;

            System.out.print(Arrays.toString(sumFinal));
        }

        else if (finalValueArray > 9) {
            tempSum[temp-1] = finalValueArray - 10;

            System.arraycopy(tempSum, 0, sumFinal, 0, temp);

            sumFinal[temp] = 1;

            System.out.print(Arrays.toString(sumFinal));
        }

        else {
            tempSum[temp-1] = finalValueArray;
            System.out.print(Arrays.toString(tempSum));
        }

    }
}
