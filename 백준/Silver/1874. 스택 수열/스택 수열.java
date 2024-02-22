import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 오름차순으로 들어갈 정수의 개수 1~n 까지
        Stack<Integer> origin = new Stack<>();
        int[] temp = new int[n];
        int index = 0;

        for (int i = 0; i < n; i++) {
            temp[i] = Integer.parseInt(br.readLine());
        } // temp 스택 완성해놓고 4 3 6 8 7 5 2 1


        for (int i = 1; i <= n; i++) {
            origin.push(i);
            sb.append("+").append("\n");
            while (!origin.isEmpty() && origin.peek()==temp[index]) {
                origin.pop();
                sb.append("-").append("\n");
                index++;
            }

        }

        if (!origin.isEmpty()) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }

    }
}
