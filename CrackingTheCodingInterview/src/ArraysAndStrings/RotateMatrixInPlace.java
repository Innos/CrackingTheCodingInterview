package ArraysAndStrings;


public class RotateMatrixInPlace {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{1, 2, 3, 4, 5},
                new int[]{6, 7, 8, 9, 10},
                new int[]{11,12,13,14,15},
                new int[]{16,17,18,19,20},
                new int[]{21,22,23,24,25}
        };

        int[][] matrix2 = new int[][]{
                new int[]{10}
        };

        printMatrix(matrix);
        System.out.println();
        rotateMatrix(matrix);
        printMatrix(matrix);

    }

    public static void printMatrix(int[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < matrix.length; col++) {
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

    public static void rotateMatrix(int[][] matrix){
        for (int shellNumber = 0; shellNumber < matrix.length / 2; shellNumber++) {
            // the length of the current shell - 1, gives us the amount of rotations needed to shift the shell
            int shiftCount = matrix.length - 2 * shellNumber - 1;
            shiftShell(shellNumber, shiftCount, matrix);
        }
    }

    public static void shiftShell(int shellNumber, int shiftCount ,int[][] matrix){
        int lastIndex = matrix.length - 1 - shellNumber;
        for (int offset = 0; offset < shiftCount; offset++) {
            int tempValue = matrix[shellNumber][shellNumber + offset];

            //left -> top
            matrix[shellNumber][shellNumber+offset] = matrix[lastIndex - offset][shellNumber];
            //bottom -> left
            matrix[lastIndex - offset][shellNumber] = matrix[lastIndex][lastIndex - offset];
            //right -> bottom
            matrix[lastIndex][lastIndex - offset] = matrix[shellNumber + offset][lastIndex];
            //top -> right
            matrix[shellNumber + offset][lastIndex] = tempValue;
        }
    }
}
