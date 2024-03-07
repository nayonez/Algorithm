import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/7568 - 덩치
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 사람의 수
        int[] weight = new int[N];
        int[] height = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            height[i] = Integer.parseInt(st.nextToken());
        }
            for (int i = 0; i < N; i++) { // 사람별로 크게 도는 for 문
                int d = 0;
                if (i > 0) {
                    for (int j = i-1; j >= 0; j--) { // 앞에 인덱스 도는거
                        if (weight[i] < weight[j] && height[i] < height[j]) // 앞 인덱스에서 키,몸무게 둘다 클때 d++
                            d++;
                    }
                    for (int j = i+1; j < N; j++) { // 뒤에 인덱스 도는거
                        if (weight[i] < weight[j] && height[i] < height[j])
                            d++;
                    }
                } else { // 0 첫번째 인덱스일때
                    for (int j = 0; j < N; j++) {
                        if (weight[i] < weight[j] && height[i] < height[j])
                            d++;
                    }
                }
                sb.append(d+1).append(" ");
            }
        System.out.println(sb);
    }
}
