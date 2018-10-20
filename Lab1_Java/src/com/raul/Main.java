package com.raul;

public class Main {

    public static void main(String[] args) {
        Matrix firstMatrix = new Matrix(1000, 1000);
        firstMatrix.randomize();

        Matrix secondMatrix = new Matrix(1000, 1000);
        secondMatrix.randomize();

        Matrix resultMatrix;

        long startTime = System.nanoTime();
        resultMatrix = firstMatrix.multiply(secondMatrix, 8);
        long finishTime = System.nanoTime();

        System.out.println("Elasped time: " + Math.round((finishTime - startTime)/1000000));

//        resultMatrix.print();
    }
}
