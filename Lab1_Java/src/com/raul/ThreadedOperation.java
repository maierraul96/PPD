package com.raul;

abstract public class ThreadedOperation implements Runnable{
    protected Matrix firstMatrix;
    protected Matrix secondMatrix;
    protected Matrix outputMatrix;
    protected MatrixPosition posBegin;
    protected MatrixPosition posEnd;



    public ThreadedOperation(Matrix firstMatrix, Matrix secondMatrix, Matrix outputMatrix,
                             MatrixPosition posBegin, MatrixPosition posEnd) {
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.outputMatrix = outputMatrix;
        this.posBegin = posBegin;
        this.posEnd = posEnd;
    }

    protected void computeFunction(int i, int j){
        outputMatrix.value[i][j] = 0;
    }

    @Override
    public void run() {
        for (int i = posBegin.i; i <= posEnd.i; i++)
            if (i == posBegin.i){
                if (i != posEnd.i)
                    for (int j = posBegin.j; j < outputMatrix.columns; j++)
                        computeFunction(i,j);
                else
                    for (int j = posBegin.j; j <= posEnd.j; j++)
                        computeFunction(i,j);
            }
            else if (i == posEnd.i){
                for (int j = 0; j <= posEnd.j; j++)
                    computeFunction(i,j);
            }
            else
                for (int j = 0; j < outputMatrix.columns; j++)
                    computeFunction(i,j);
    }
}
