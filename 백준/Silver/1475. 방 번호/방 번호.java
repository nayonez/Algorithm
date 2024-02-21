import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = new int[10]; // 0~9까지의 숫자가 든 세트
        String num = br.readLine();
        num = num.replaceAll("9", "6");

        for (int i = 0; i < num.length(); i++) {
            input[num.charAt(i)-'0']++; //한글자씩 잘라서 그 숫자의 input배열 위치에 1씩 증가시킴
        }

        int max = Integer.MIN_VALUE;
        if (input[6] % 2 != 0) {
            input[6]++;
        } input[6] = input[6] / 2;

        for (int i = 0; i < input.length; i++) {
            max = Math.max(max, input[i]);
        }
        System.out.println(max);
    }
}
