import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Integer>> list;
    static int[] parent;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine()) + 1; // 정점의 개수
        int M = N - 1; // 간선의 개수
        list = new ArrayList<>();
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 1; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }
        dfs(1);
        for (int i = 2; i < N; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }
    
    private static void dfs(int start) {
        for (int a : list.get(start)) { //start 인덱스에 있는 list
            if (parent[a] > 0)
                continue;
            parent[a] = start;
            dfs(a);
        }
    };
}
