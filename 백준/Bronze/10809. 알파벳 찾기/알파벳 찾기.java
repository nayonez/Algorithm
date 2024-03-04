import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            int idx = temp - 'a';
            if (alphabet[idx] == -1) {
                alphabet[idx] = i;
            }
        }

        for (int alpha : alphabet) {
            sb.append(alpha).append(" ");
        }
        System.out.println(sb);
    }
}
