package com.raul;

public class Main {

    public static void main(String[] args) {
        Matrix firstMatrix = new Matrix("first.txt");
        Matrix secondMatrix = new Matrix("second.txt");
        Matrix resultMatrix = new Matrix(3, 4);

        BalancedMultithredsAdd balancedMultithredsAdd = new BalancedMultithredsAdd(
                firstMatrix, secondMatrix, resultMatrix, 5);
        balancedMultithredsAdd.execute();
        resultMatrix.print();
    }
}
