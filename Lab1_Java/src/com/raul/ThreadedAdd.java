package com.raul;

public class ThreadedAdd extends ThreadedOperation {

    public ThreadedAdd(int[][] firstMatrix, int[][] secondMatrix, int[][] outputMatrix,
                       MatrixPosition posBegin, MatrixPosition posEnd, int height, int width) {
        super(firstMatrix, secondMatrix, outputMatrix, posBegin, posEnd, height, width);
    }

    @Override
    protected void computeFunction(int i, int j){
        outputMatrix[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
    }
}
