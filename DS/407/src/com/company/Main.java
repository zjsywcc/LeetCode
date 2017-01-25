package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;


public class Main {

    public static void main(String[] args) {
	    int[][] heightMap = new int[][]{{1,4,3,1,3,2}, {3,2,1,3,2,4}, {2,3,3,2,3,1}};
        System.out.println(trapRainWater(heightMap));
    }

    static class Triple {
        int val;
        int x;
        int y;

        Triple(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }

    public static int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        int row = heightMap.length;
        int col = heightMap[0].length;
        boolean[][] flag = new boolean[row][col];

        PriorityQueue<Triple> queue = new PriorityQueue<Triple>(
                new Comparator<Triple>(){
                    @Override
                    public int compare(Triple t1, Triple t2) {
                        return t1.val - t2.val;
                    }
                });

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                    queue.offer(new Triple(heightMap[i][j], i, j));
                    flag[i][j] = true;
                }
            }
        }
        return bfs(heightMap, queue, flag);
    }

    public static boolean inBoard(int x, int y, int[][] heightMap) {
        int row = heightMap.length;
        int col = heightMap[0].length;
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    public static int bfs(int[][] heightMap, PriorityQueue<Triple> queue, boolean[][] flag) {
        Triple min;
        int sum = 0;
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        boolean isFirst = true;
        Triple lastMin = new Triple(-1, -1, -1);
        while(!queue.isEmpty()) {
            min = queue.poll();
//            printTriple(min);
            if(isFirst) {
                lastMin = min;
                isFirst = false;
            } else {
                if(lastMin.val >= min.val) {
                    sum += lastMin.val - min.val;
//                    printTripleTwo(lastMin, min);
                } else {
                    lastMin = min;
                }
            }
            for(int k = 0; k < 4; k++) {
                int nx = min.x + dx[k];
                int ny = min.y + dy[k];
                if(inBoard(nx, ny, heightMap) && !flag[nx][ny]) {
                    queue.offer(new Triple(heightMap[nx][ny], nx, ny));
                    flag[nx][ny] = true;
                }
            }
        }
        return sum;
    }

    public static void printTriple(Triple t) {
        System.out.println("x: " + t.x + " y: " + t.y + " val: " + t.val);
    }

    public static void printTripleTwo(Triple t1, Triple t2) {
        System.out.println("pre: " + "x: " + t1.x + " y: " + t1.y + " val: " + " next: " + "x: " + t2.x + " y: " + t2.y + " delta: " + (t1.val - t2.val));
    }
}
