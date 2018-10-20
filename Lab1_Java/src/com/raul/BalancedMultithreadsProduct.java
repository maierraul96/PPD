package com.raul;

public class BalancedMultithreadsProduct extends  BalancedThreadOperationExecution{
    public BalancedMultithreadsProduct(Matrix firstMatrix, Matrix secondMatrix, int threadsCount) {
        super(firstMatrix, secondMatrix, threadsCount);
    }

    @Override
    public void determine_result_dimensions() {
        int rows = firstMatrix.rows;
        int columns = secondMatrix.columns;
        resultMatrix = new Matrix(rows, columns);
    }

    @Override
    public ThreadedOperation initThreadedOperation(MatrixPosition beginPosition, MatrixPosition endPosition) {
        return new ThreadedMultiply(
                firstMatrix,
                secondMatrix,
                resultMatrix,
                beginPosition,
                endPosition);
    }
}
