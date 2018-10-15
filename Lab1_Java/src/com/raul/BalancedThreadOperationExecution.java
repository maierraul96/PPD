package com.raul;

public class BalancedThreadOperationExecution{
    public Matrix firstMatrix;
    public Matrix secondMatrix;
    public Matrix resultMatrix;
    public int threadsCount;
    public MatrixPosition[][] loadDistribution;

    public BalancedThreadOperationExecution(Matrix firstMatrix, Matrix secondMatrix, Matrix resultMatrix,
                                            int threadsCount) {
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.resultMatrix = resultMatrix;
        this.threadsCount = threadsCount;
        this.loadDistribution = new MatrixPosition[threadsCount][2];
        determine_result_dimensions();
        determineLoadDistribution();
    }

    public void determine_result_dimensions(){
        resultMatrix.rows = Math.max(firstMatrix.rows, secondMatrix.rows);
        resultMatrix.columns = Math.max(firstMatrix.columns, secondMatrix.columns);
    }

    public int[] determinePositionsPerThread(){
        int[] positionsPerThread = new int[threadsCount];
        int totalPositions = resultMatrix.rows * resultMatrix.columns;
        for (int i = 0; i < threadsCount; i++)
            positionsPerThread[i] = totalPositions / threadsCount;
        for (int i = 0; i < totalPositions % threadsCount; i++)
            positionsPerThread[i] += 1;

        System.out.print("Load: ");
         for (int i = 0; i < threadsCount; i++)
             System.out.print(positionsPerThread[i]+" ");
        System.out.println();
        return positionsPerThread;
    }

    public void determineLoadDistribution(){
        int[] positionsPerThread = determinePositionsPerThread();
        MatrixPosition currentPosition = new MatrixPosition(0,0);
        for (int i = 0; i < threadsCount; i++){
            MatrixPosition endPosition = currentPosition.forward(positionsPerThread[i]-1, resultMatrix.rows,
                    resultMatrix.columns);
            loadDistribution[i][0] = currentPosition;
            loadDistribution[i][1] = endPosition;

            currentPosition = currentPosition.forward(positionsPerThread[i], resultMatrix.rows, resultMatrix.columns);
        }
    }

    public ThreadedOperation initThreadedOperation(MatrixPosition beginPosition, MatrixPosition endPosition){
        System.out.println("Begin i:"+beginPosition.i+" j:"+beginPosition.j + " End: i:"+endPosition.i+" j:"+endPosition.j);
        return new ThreadedOperation(
                firstMatrix,
                secondMatrix,
                resultMatrix,
                beginPosition,
                endPosition);
    }

    public void execute(){
        Thread[] threads = new Thread[threadsCount];
        for (int i = 0; i < threadsCount; i++){
            String threadName = "Thread-("+loadDistribution[i][0].i+","+loadDistribution[i][0].j+")->("+
                    loadDistribution[i][1].i+","+loadDistribution[i][1].j+")";
            threads[i] = new Thread(initThreadedOperation(loadDistribution[i][0], loadDistribution[i][1]), threadName);
            threads[i].start();
        }
        for (int i = 0; i < threadsCount; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
