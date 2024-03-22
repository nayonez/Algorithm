import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        String A = st.nextToken(); // A가 B의 길이가 될때까지
        String B = st.nextToken();
        int diff = 0;

        for (int i = 0; i <= B.length() - A.length(); i++) { // A문자열의 시작점
            diff = 0;
            for (int j = 0; j < A.length(); j++) { // 차이점 계산하기 위한
                if (A.charAt(j) != B.charAt(j+i)) diff++; // 자리의 값이 다르면 diff증가
            } min = Math.min(min, diff);
        }
        System.out.println(min);
    }
}
