package com.raul;

public class BalancedMultithredsAdd extends BalancedThreadOperationExecution {
    public BalancedMultithredsAdd(Matrix firstMatrix, Matrix secondMatrix, Matrix resultMatrix, int threadsCount) {
        super(firstMatrix, secondMatrix, resultMatrix, threadsCount);
    }

    @Override
    public ThreadedOperation initThreadedOperation(MatrixPosition beginPosition, MatrixPosition endPosition) {
        System.out.println("Begin i:"+beginPosition.i+" j:"+beginPosition.j + " End: i:"+endPosition.i+" j:"+endPosition.j);
        return new ThreadedAdd(
                firstMatrix,
                secondMatrix,
                resultMatrix,
                beginPosition,
                endPosition);
    }
}
