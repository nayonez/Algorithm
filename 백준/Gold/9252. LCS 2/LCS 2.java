import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String A = br.readLine();
        String B = br.readLine();
        int[][] dp = new int[A.length()+1][B.length()+1];
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i-1) == B.charAt(j-1)) { // 같은 인덱스의 문자가 같다면
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[A.length()][B.length()]);

        Stack<Character> stack = new Stack<>();
        int a = A.length();
        int b = B.length();
        while (a > 0 && b > 0) {
            if (a==0 || b==0) break;
            if (dp[a][b] == dp[a-1][b]) {
                a--;
            } else if (dp[a][b] == dp[a][b-1]) {
                b--;
            } else {
                stack.push(A.charAt(a-1));
                a--; b--;
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
