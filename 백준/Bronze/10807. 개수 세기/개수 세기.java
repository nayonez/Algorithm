import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 개수 정렬로
public class Main {
    public static void main(String[] args) throws Exception {
      
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); 
        int[] input = new int[201];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) { 
            input[Integer.parseInt(st.nextToken())+100]++;
        }
        System.out.println(input[Integer.parseInt(br.readLine())+100]);
    }
}