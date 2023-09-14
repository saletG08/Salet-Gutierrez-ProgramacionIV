package Practica009;

class MyRunnable implements Runnable {
    private int row;
    private int[][] matriz;

    public MyRunnable(int row, int[][] matriz) {
        this.row = row;
        this.matriz = matriz;
    }

    @Override
    public void run() {
        int n = matriz[row].length;
        int startValue = row * n * 5 + 1;
        for (int j = 0; j < n; j++) {
            matriz[row][j] = startValue + j;
        }
    }
}
