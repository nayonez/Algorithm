import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1620 - 나는야 포켓몬 마스터 이다솜
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 도감에 저장할 포켓몬 수
        int M = Integer.parseInt(st.nextToken()); // 내가 검색할 포켓몬 수
        Map<Integer, String> keyNum = new HashMap<>();
        Map<String, Integer> keyPocket = new HashMap<>();

        // 포켓몬 저장 (문제에서 이름, 숫자 둘다 중복 없다고 함, 맵 두개에 저장)
        for (int i = 1; i <= N; i++) {
            String temp = br.readLine();
            keyNum.put(i, temp); // 키:번호, 밸류:포켓몬이름
            keyPocket.put(temp, i); // 키:포켓몬이름, 밸류:번호
        }
        // 포켓몬 검색
        for (int i = 0; i < M; i++) {
            String temp = br.readLine();
            // 모두 숫자, 모두 문자니까 첫글자가 숫자라면..(0~9사이) -> 키가 숫자인 keyNum맵에서 밸류값 출력
            if ('0' <= temp.charAt(0) && temp.charAt(0) <= '9') {
                sb.append(keyNum.get(Integer.parseInt(temp))).append("\n"); // 안되면 integer.parseint로 바꿔보자
            }
            // 숫자가 아니라면=문자라면 -> 키가 문자인 keyPocket맵에서 밸류값 출력
            else {
                sb.append(keyPocket.get(temp)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
