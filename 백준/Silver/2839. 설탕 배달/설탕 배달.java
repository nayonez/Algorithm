import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); 
        int count = 0;
        int min = Integer.MAX_VALUE;
      
        while (N > 2) {
            if (N%5 == 0) { 
                count += N/5; 
                N = N % 5;
            } else { 
                N = N - 3;
                count++;
            }
        }
        if (N > 0) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }
}