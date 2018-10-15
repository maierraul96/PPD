package com.raul;

public class MatrixPosition {
    public int i;
    public int j;

    public MatrixPosition(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public MatrixPosition forward(int count, int height, int width){
        int rank = this.i * width + this.j;
        rank += count;
        return new MatrixPosition(rank / width, rank % width);
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
