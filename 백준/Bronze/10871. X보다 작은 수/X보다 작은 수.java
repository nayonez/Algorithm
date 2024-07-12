import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());       
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            temp = Integer.parseInt(st2.nextToken());
            if (x > temp)
                sb.append(temp).append(" ");
        }
        System.out.println(sb);
    }
}
