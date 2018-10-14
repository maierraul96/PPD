package com.raul;

public class Main {

    public static void main(String[] args) {
        Matrix firstMatrix = new Matrix("first.txt");
        Matrix secondMatrix = new Matrix("second.txt");
        Matrix resultMatrix = new Matrix(3, 4);

        ThreadedAdd threadedAdd = new ThreadedAdd(
                firstMatrix, secondMatrix, resultMatrix, new MatrixPosition(0,0), new MatrixPosition(2,3));
        Thread thread = new Thread(threadedAdd);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resultMatrix.print();
    }
}
