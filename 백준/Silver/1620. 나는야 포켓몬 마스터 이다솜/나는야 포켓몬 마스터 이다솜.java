import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/1620 - 나는야 포켓몬 마스터 이다솜
// 맵 하나로
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 도감에 저장할 포켓몬 수
        int M = Integer.parseInt(st.nextToken()); // 내가 검색할 포켓몬 수
        Map<String, String> map = new HashMap<>();

        // 포켓몬 저장
        for (int i = 1; i <= N; i++) {
            String temp = br.readLine();
            map.put(temp, String.valueOf(i)); // 키:포켓몬이름, 밸류:번호
            map.put(String.valueOf(i), temp); // 키:포켓몬이름, 밸류:번호
        }
        // 포켓몬 검색
        for (int i = 0; i < M; i++) {
            sb.append(map.get(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }
}
