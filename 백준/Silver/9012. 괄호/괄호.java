import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean end = false;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            char[] c = br.readLine().toCharArray();
            end = false;
            stack.clear();
            for (int j = 0; j < c.length; j++) {
                if (c[j] == '(') {
                    stack.add('(');
                } else {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        // 닫힌게 더 많은 경우
                        end = true;
                        break;
                    }
                }
            }
            if (!stack.isEmpty() || end==true) {
                sb.append("NO").append("\n");
            } else {
                sb.append("YES").append("\n");
            }
        }
        System.out.println(sb);

    }
}
