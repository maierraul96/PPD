package com.raul;

import java.io.*;

public class Matrix {
    public String path;
    public int rows;
    public int columns;
    public int[][] value;

    public Matrix() {
    }

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        value = new int[rows][columns];
    }

    public Matrix(String path) {
        this.path = path;
        initDimensions();
        value = new int[rows][columns];
        read();
    }

    public Matrix(int rows, int columns, int[][] value) {
        this.rows = rows;
        this.columns = columns;
        this.value = value;
    }

    private void initDimensions(){

        File file = new File(path);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            rows = 0;
            columns = 0;
            String line;
            while ((line = br.readLine()) != null){
                rows++;
                int columns_count = (line.trim().split(" ")).length;
                if (columns != 0 && columns != columns_count)
                    System.out.println("Number of columns not constant!");
                columns = columns_count;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read(){
        File file = new File(path);

        try {
           BufferedReader br = new BufferedReader(new FileReader(file));
           String line;
           for (int i = 0; i<rows; i++){
               line = br.readLine();
               String[] nr = line.trim().split(" ");
               for (int j=0; j<columns; j++){
                   value[i][j] = Integer.parseInt(nr[j]);
               }
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print(){
        for (int i = 0; i<rows; i++){
            for (int j = 0; j<columns; j++)
                System.out.print(value[i][j] + " ");
            System.out.println();
        }
    }
}
