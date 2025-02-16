class MatrixMultiplicationThread extends Thread {
    private int[][] A, B, C;
    private int row, col;

    public MatrixMultiplicationThread(int[][] A, int[][] B, int[][] C, int row, int col) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.row = row;
        this.col = col;
    }

    public void run() {
        int sum = 0;
        for (int k = 0; k < A[row].length; k++) {
            sum += A[row][k] * B[k][col];
        }
        C[row][col] = sum;
    }
}

public class MultiThreadedMatrixMultiplication {
    public static void main(String[] args) throws InterruptedException {
        int[][] A = { { 1, 2 }, { 3, 4 } };
        int[][] B = { { 5, 6 }, { 7, 8 } };
        int[][] C = new int[2][2];
        Thread[][] threads = new Thread[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                threads[i][j] = new MatrixMultiplicationThread(A, B, C, i, j);
                threads[i][j].start();
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                threads[i][j].join();
            }
        }
        System.out.println("Resultant Matrix:");
        for (int[] row : C) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
