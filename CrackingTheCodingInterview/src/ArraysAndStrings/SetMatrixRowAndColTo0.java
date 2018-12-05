package ArraysAndStrings;


import java.util.HashSet;

public class SetMatrixRowAndColTo0 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{1, 2, 3, 4, 5},
                new int[]{6, 7, 0, 9, 10},
                new int[]{11,12,13,14,15},
                new int[]{16,17,18,0,20}
        };

        setRowAndColToZeroIfZeroElementExists(matrix);
        printMatrix(matrix);
    }

    public static void setRowAndColToZeroIfZeroElementExists(int[][] matrix){
        HashSet<Integer> colsToSetToZero = new HashSet<>();
        HashSet<Integer> rowsToSetToZero = new HashSet<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if(matrix[row][col] == 0){
                    rowsToSetToZero.add(row);
                    colsToSetToZero.add(col);
                }
            }
        }

        for (int row : rowsToSetToZero) {
            setRowToZero(row,matrix);
        }

        for (int col : colsToSetToZero) {
            setColToZero(col, matrix);
        }
    }

    public static void setColToZero(int col, int[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][col] = 0;
        }
    }

    public static void setRowToZero(int row, int[][] matrix){
        for (int col = 0; col < matrix[row].length; col++) {
            matrix[row][col] = 0;
        }
    }

    public static void printMatrix(int[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < matrix[row].length; col++) {
                sb.append(matrix[row][col]);
                if(matrix[row][col] < 10){
                    sb.append("   ");
                }
                else{
                    sb.append("  ");
                }

            }
            System.out.println(sb.toString());
        }
    }
}
