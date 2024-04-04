import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        int[][] dp = new int[A.length()+1][B.length()+1]; // 패딩

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i-1) == B.charAt(j-1)) { // 같은 인덱스의 문자가 같다면
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else { // 문자 다르다면
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        System.out.println(dp[A.length()][B.length()]);
    }
}
