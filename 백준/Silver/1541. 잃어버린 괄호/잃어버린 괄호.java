import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(),"-"); // 55-50+40 가 '-' 구분자로 2부분으로 잘림
        int[] sum = new int[st.countTokens()];
        int i = 0;
        while (st.hasMoreTokens()) {
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");

            while (st2.hasMoreTokens()) {
                sum[i] += Integer.parseInt(st2.nextToken()); // 첫번째 sum은 +
            } i++;
        }
        for (int j = 1; j < sum.length; j++) {
            answer -= sum[j];
        }
        answer += sum[0];
        System.out.println(answer);
    }
}
