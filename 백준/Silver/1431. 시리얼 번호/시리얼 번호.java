import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1431 - 시리얼 번호
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 기타의 개수
        String[] strArr = new String[N];
        for (int i = 0; i < N; i++) {
            strArr[i] = br.readLine(); // 시리얼번호 전체를 배열에
        }
        Arrays.sort(strArr, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                int s1 = SumNum(o1);
                int s2 = SumNum(o2);
                if (s1 == s2) {
                    return o1.compareTo(o2);
                } return s1 - s2;
            } return o1.length() - o2.length();
        });

        for (String s : strArr) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
    private static int SumNum(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > '0' && str.charAt(i) <= '9') {
                sum += str.charAt(i) - '0';
            }
        }
        return sum;
    }
}
