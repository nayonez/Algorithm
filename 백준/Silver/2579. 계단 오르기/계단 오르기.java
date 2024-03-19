import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 계단의 개수
        int[] stair = new int[N+1]; // 각 계단의 점수 저장
        int[] dp = new int[N+1]; // 각 계단이 밟고 올 수 있는 최댓값 저장
        // 밟는 건 한칸앞, 두칸앞 에서만 올 수 있고 마지막칸은 반드시 밟아야하며 3칸연속 밟을 수 없음

        // 각 계단의 점수 입력받음
        for (int i = 1; i <= N; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = stair[1]; // 앞에 칸은 0이니까 자기 자신이 최대값
        if (N == 1) { // 1들어왔을때 밑에 실행하면 인덱스 아웃오브..
            System.out.println(dp[1]);
            return;
        }
        dp[2] = stair[1] + stair[2]; // 자기 자신과 그 앞칸 밟은게 최대! 앞앞칸은 0

        for (int i = 3; i <= N; i++) {
            // 두칸 앞에서 오는 건 3칸조건에 안걸리니까
            // 한칸 앞에서 오는 건 3칸조건에 안걸리기 위해 . . (내 한칸 전의 두칸 앞 = 3칸앞의 최댓값 + 앞의 계단값 + 내 계단값)
            dp[i] = Math.max(dp[i-2] + stair[i], dp[i-3] + stair[i-1] + stair[i]);
        }
        System.out.println(dp[N]);

    }
}
