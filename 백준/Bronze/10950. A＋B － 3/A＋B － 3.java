import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] sumArr = new int[T];


        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] intArr = new int[2];
            int sum1 = 0;
            for(int j=0; j<2; j++){
                intArr[j] = Integer.parseInt(st.nextToken());
                sum1 += intArr[j];
            }
            sumArr[i] = sum1;
        }
        for(int a : sumArr) {
            System.out.println(a);
        }
    }
}
