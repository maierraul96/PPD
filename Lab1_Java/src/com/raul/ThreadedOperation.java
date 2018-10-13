package com.raul;

abstract public class ThreadedOperation implements Runnable{
    protected int firstMatrix [][];
    protected int secondMatrix [][];
    protected int outputMatrix [][];
    protected MatrixPosition posBegin;
    protected MatrixPosition posEnd;
    protected int height, width;



    public ThreadedOperation(int[][] firstMatrix, int[][] secondMatrix, int[][] outputMatrix,
                             MatrixPosition posBegin, MatrixPosition posEnd, int height, int width) {
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.outputMatrix = outputMatrix;
        this.posBegin = posBegin;
        this.posEnd = posEnd;
        this.height = height;
        this.width = width;
    }

    protected void computeFunction(int i, int j){
        outputMatrix[i][j] = 0;
    }

    @Override
    public void run() {
        for (int i = posBegin.i; i <= posEnd.i; i++)
            if (i == posBegin.i){
                if (i != posEnd.i)
                    for (int j = posBegin.j; j < width; j++)
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
                for (int j = 0; j < width; j++)
                    computeFunction(i,j);
    }
}
