import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
