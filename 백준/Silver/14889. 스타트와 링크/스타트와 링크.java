import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, answer;
    static int[] tgt;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        tgt = new int[N/2];
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        System.out.println(answer);

    }
    private static void dfs(int depth, int start) {
        if (depth == N/2) {

            boolean[] selected = new boolean[N];
            for (int i = 0; i < tgt.length; i++) {
                selected[tgt[i]] = true;
            }
            int team1 = 0;
            int team2 = 0;
            for (int i = 0; i < N-1; i++) { // 앞에서 보고간 것은 볼 필요 없으니까
                for (int j = i+1; j < N; j++) {
                    if (selected[i] && selected[j]) {
                        team1 += map[i][j] + map[j][i];
                    } else if (!selected[i] && !selected[j]) {
                        team2 += map[i][j] + map[j][i];
                    }
                }
            }
            answer = Math.min(answer, Math.abs(team1 - team2));
            return;
        }
        for (int i = start; i < N; i++) {
            tgt[depth] = i;
            dfs(depth+1, i+1);
        }
    }
}
