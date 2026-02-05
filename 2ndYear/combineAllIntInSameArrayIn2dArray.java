public class combineAllIntInSameArrayIn2dArray {
    public static void main(String[] args) {

        int[][] score = {{2,1,4},{5,1,3},{2,4,2,6}};


        int m = score.length;
        int[] temp = new int[m];

        for (int i = 0; i < m; i++) {
            temp[i] = score[i].length;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < temp[i]; j++) {
                System.out.print(score[i][j]);
            }
            System.out.println();
        }
    }
}
