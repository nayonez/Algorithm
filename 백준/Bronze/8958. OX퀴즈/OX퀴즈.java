import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            boolean flag = false;
            int num = 0;
            int ans = 0;
            String temp = br.readLine();
            int size = temp.length();
            char[] quiz = temp.toCharArray();
            int[] score = new int[size];

            for (int j = 0; j < quiz.length; j++) {
                if (quiz[j] == 'O') {
                    flag = true;
                    num += 1;
                } else if (quiz[j] == 'X') {
                    flag = false;
                    num = 0;
                }
                score[j] = num;
            }

            for (int sc : score) {
                ans += sc;
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
