import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] intArr = new int[5];
        int sum = 0;
        
        for (int i = 0; i < 5; i++) {
            int temp = Integer.parseInt(st.nextToken());
            intArr[i] = temp * temp;
        }
        for (int n : intArr) {
            sum += n;
        }
        System.out.println(sum%10);
    }
}
