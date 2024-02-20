import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws Exception {
        Stack<Character> stack;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            boolean flag = true;
            String input = br.readLine();
            stack = new Stack<>();
            if (input.equals(".")) break;
            for (int i = 0; i < input.length(); i++) {
                char temp = input.charAt(i);
                if (temp == '(') {
                    stack.push(temp);
                } else if (temp == '[') {
                    stack.push(temp);
                } else if (temp == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        flag = false;
                    }
                } else if (temp == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        flag = false;
                    }
                }
            }
            if (!stack.isEmpty() || flag==false) {
                sb.append("no").append("\n");
            } else {
                sb.append("yes").append("\n");
            }
        }
        System.out.println(sb);
    }
}