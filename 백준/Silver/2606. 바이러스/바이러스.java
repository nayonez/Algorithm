import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        list = new ArrayList<>();
        count = 0;
        int N = Integer.parseInt(br.readLine()) + 1; // 컴퓨터의 수
        int M = Integer.parseInt(br.readLine()); // 간선의 수
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }
        dfs(1);
        System.out.println(count - 1);
    }
    private static void dfs(int start) {
        visited[start] = true;
        count++;
        for (int a : list.get(start)) {
            if (visited[a])
                continue;
            dfs(a);
        }

    };
}
