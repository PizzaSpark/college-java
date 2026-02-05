import java.util.Arrays;
public class arraySumReverse {
    public static void main(String[] args) {

//        int[] arr1 = {3, 5, 6, 7, 4};
//        int[] arr2 = {4, 1, 2, 6, 3};

//        int[] arr1 = {9,9,9,9,9};
//        int[] arr2 = {9,9,9};

//        int[] arr1 = {7,4,3,6,0,6,4,7};
//        int[] arr2 = {5,9,3,5,9,8,3,7};

        int[] arr1 = {3,5,6,7,4};
        int[] arr2 = {4,1,2,6,3};
        int[] arr3 = {5,3,3,7,1};

        //maximum length array

        int temp = 0;

//        if (arr1.length > arr2.length) {
//            temp = arr1.length;
//        }
//
//        else {
//            temp = arr2.length;
//        }


        if (arr1.length >= arr2.length && arr1.length >= arr3.length) {
            temp = arr1.length;
        }

        else if (arr2.length >= arr1.length && arr2.length >= arr3.length) {
            temp = arr2.length;
        }

        else {
            temp = arr3.length;
        }

        int[] temp1 = new int[temp];
        int[] temp2 = new int[temp];
        int[] temp3 = new int[temp];
        int[] tempSum = new int[temp];
        int[] sumFinal = new int[temp + 1];


        //transfer values to temp
        System.arraycopy(arr1, 0, temp1, 0, arr1.length);
        System.arraycopy(arr2, 0, temp2, 0, arr2.length);
        System.arraycopy(arr3, 0, temp3, 0, arr3.length);

        //computation

        for (int i = 0; i < temp-1; i++) {
//            int total = temp1[i] + temp2[i];
            int total = temp1[i] + temp2[i] + temp3[i];

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

        System.out.print("Array1 \t = ");
        System.out.print(Arrays.toString(arr1));

        System.out.println();
        System.out.print("Array2 \t = ");
        System.out.print(Arrays.toString(arr2));

        System.out.println();
        System.out.print("Array3 \t = ");
        System.out.print(Arrays.toString(arr3));

        System.out.println();
        System.out.print("Sum \t = ");

//        int finalValueArray = ((temp1[temp-1])+(temp2[temp-1]));
        int finalValueArray = ((temp1[temp-1])+(temp2[temp-1])+(temp3[temp-1]));

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
