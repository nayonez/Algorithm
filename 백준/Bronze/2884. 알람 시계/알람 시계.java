import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (M - 45 >= 0) {
            M = M - 45;
            System.out.print(sb.append(H).append(" ").append(M));;
        } else if (M - 45 < 0) {
            if(H == 0) {
                H = 23;
            } else {
                H = H - 1;
            }
            M = M + 15;
            System.out.print(sb.append(H).append(" ").append(M));
        }
    }
}