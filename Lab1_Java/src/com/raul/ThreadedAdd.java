package com.raul;

public class ThreadedAdd extends ThreadedOperation {

    public ThreadedAdd(Matrix firstMatrix, Matrix secondMatrix, Matrix outputMatrix,
                       MatrixPosition posBegin, MatrixPosition posEnd) {
        super(firstMatrix, secondMatrix, outputMatrix, posBegin, posEnd);
    }

    @Override
    protected void computeFunction(int i, int j){
        outputMatrix.value[i][j] = firstMatrix.value[i][j] + secondMatrix.value[i][j];
    }
}
