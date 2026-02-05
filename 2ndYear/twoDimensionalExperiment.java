import java.util.Arrays;

public class twoDimensionalExperiment {
    public static void main(String[] args) {

        int[][] matrix = {{6,13,5,8}, {4,3,9}, {2,1,15,12}, {14,7}, {10,11}};

        int m = matrix.length;
        int[] temp = new int[m];
        int mergedLength = 0;

        for (int i = 0; i < m; i++) {
            temp[i] = matrix[i].length;
            mergedLength += temp[i];
        }

        //transfer of values to big array aka full
        int[] full = new int[mergedLength];
        int counter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < temp[i]; j++) {
                full[counter] = matrix[i][j];
                counter++;
            }
        }
        counter = 0;

        //sort big array

        Arrays.sort(full);

        //put them back

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < temp[i]; j++) {
                matrix[i][j] = full[counter];
                counter++;
            }
            System.out.print(Arrays.toString(matrix[i]) + " ");
        }
    }
}
