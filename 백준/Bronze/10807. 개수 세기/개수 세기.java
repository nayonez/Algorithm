import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());;
        int v = Integer.parseInt(br.readLine());
        int result = 0;

        int[] intArr = new int[N];

        for (int i = 0; i < N; i++) {
            intArr[i] = Integer.parseInt(st.nextToken());
            if(v == intArr[i]) {
                result += 1;
            }
        }
        System.out.println(result);
    }
}