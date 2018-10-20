package com.raul;

public class ThreadedMultiply extends ThreadedOperation {
    public ThreadedMultiply(Matrix firstMatrix, Matrix secondMatrix, Matrix outputMatrix, MatrixPosition posBegin, MatrixPosition posEnd) {
        super(firstMatrix, secondMatrix, outputMatrix, posBegin, posEnd);
    }

    @Override
    protected void computeFunction(int i, int j) {
        outputMatrix.value[i][j] = 0;
        for (int k = 0; k < firstMatrix.columns; k++){
            outputMatrix.value[i][j] += firstMatrix.value[i][k] * secondMatrix.value[k][j];
        }
    }
}
