import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] arr = new boolean[10001];
        
        for (int i = 0; i <= 10000; i++) {
            if (sum(i) <= 10000) {
                arr[sum(i)] = true;
            }
        }
        for (int i = 0; i <= 10000; i++) {
            if (!arr[i]) System.out.println(i);
        }
        System.out.println(sb);
    }
    private static int sum(int n) {
        int ans = n;
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            ans += s.charAt(i) - '0';
        }
        return ans;
    }
}
