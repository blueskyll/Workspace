package graph;

import java.util.*;

public class RoadsInBerland25C {

    private int roadNum;
    private int numOfChangedRoad; // k
    private int[][] matrix;
    private int road1;
    private int road2;

    public void read() {
        Scanner scanner = new Scanner(System.in);
        roadNum = scanner.nextInt();
        matrix = new int[roadNum + 1][roadNum + 1];

        int i = 0;
        for (i = 1; i <= roadNum; i++)
            for (int j = 1; j <= roadNum; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        numOfChangedRoad = scanner.nextInt();

        for (i = 0; i < numOfChangedRoad; i++) {
            road1 = scanner.nextInt();
            road2 = scanner.nextInt();
            int dis = scanner.nextInt();
            if (dis < matrix[road1][road2]) {
                matrix[road1][road2] = dis;
                matrix[road2][road1] = dis;
                updateMatrix();
            }
            print();
        }

    }

    public void print() {
        int i = 1, j = 1;
        long sum = 0L;
        for (i = 1; i < roadNum; i++)
            for (j = i + 1; j <= roadNum; j++)
                sum += matrix[i][j];
        System.out.print(sum + " ");
    }

    public void updateMatrix() {
        int i = 1;
        for (i = 1; i <= roadNum; i++) {
            if (matrix[road1][i] > matrix[road1][road2] + matrix[road2][i]) {
                matrix[road1][i] = matrix[road1][road2] + matrix[road2][i];
                matrix[i][road1] = matrix[road1][i];
            }
            if (matrix[road2][i] > matrix[road2][road1] + matrix[road1][i]) {
                matrix[road2][i] = matrix[road2][road1] + matrix[road1][i];
                matrix[i][road2] = matrix[road2][i];
            }
        }// end for i

        for (int j = 1; j < roadNum; j++)
            for (int k = j + 1; k <= roadNum; k++) {
                matrix[j][k] = Math.min(
                        matrix[j][k],
                        Math.min(matrix[j][road1] + matrix[road1][road2]
                                + matrix[road2][k], matrix[j][road2]
                                + matrix[road2][road1] + matrix[road1][k]));
              matrix[k][j] = matrix[j][k];
            }
    }



    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RoadsInBerland25C road = new RoadsInBerland25C();
        road.read();
    }

}