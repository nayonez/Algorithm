import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char ch;
        boolean flag = false; // 아직 '<'를 안만남
        Stack<Character> stack = new Stack<>();

        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb1 = new StringBuilder();
            ch = s.charAt(i);

            if (ch=='<') {
                flag = true; // > 를 만날때까지는 true! > 나오면 false
                if (!stack.isEmpty()) {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                } sb.append(ch);
            } else if (ch=='>') {
                flag = false;
                sb.append(ch);
            } else {
                if (flag) { // flag=true -> 괄호 안이다
                    sb.append(ch); // 그냥 출력
                } else if (!flag) { // 괄호 밖이다 -> 1.공백 2.공백이아닌것
                    if (ch==' ' && !stack.isEmpty()) { // 공백이면 큐에 있는게 있으면 다 반대로 출력 후 지금 ch 그냥 출력
                        while (!stack.isEmpty()) {
                            sb.append(stack.pop());
                        }
                        sb.append(" "); // 그냥 출력
                    } else { // 공백이 아니면 -> 알파벳이면
                        stack.push(ch); // 스택에 넣고
                    }
                }
            }
        }
        // 입력 다 받고 알파벳 뒤에 <>없으면 남은 스택 출력 못하니까
        while (!stack.isEmpty()) { 
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
