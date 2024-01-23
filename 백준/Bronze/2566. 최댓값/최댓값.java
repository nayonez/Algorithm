import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int[][] numbers = new int[9][9];
        int max = Integer.MIN_VALUE;
        int col = 0; // 행
        int row = 0; // 열

        for(int i = 0; i < 9; i++ ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j <9; j++) {

                numbers[i][j] = Integer.parseInt(st.nextToken());

                if(max < numbers[i][j]) {
                    max = numbers[i][j];
                    col = i + 1;
                    row = j + 1;
                }
            }
        }
        System.out.println(max);
        System.out.println(sb.append(col).append(" ").append(row));
    }
}
