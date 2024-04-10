import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int M, sum;
    static ArrayList<Node> house, store, tgt;
    static ArrayList<Integer> ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 줄의 개수
        int minAnswer = Integer.MAX_VALUE; // 각 집에서 치킨집까지의 최소거리를 다 합한 값 중의 최소
        M = Integer.parseInt(st.nextToken()); // 치킨집의 최대 개수
        house = new ArrayList<>(); // 1 집
        store = new ArrayList<>(); // 2 치킨
        tgt = new ArrayList<>();
        ans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) {
                    house.add(new Node(i,j));
                } else if (temp == 2) {
                    store.add(new Node(i,j));
                }
            }
        }
        comb(0, 0);
        Collections.sort(ans);
        System.out.println(ans.get(0));
    }

    private static void comb (int depth, int start) {
        // 기저 조건
        if (depth == M) {
           sum = 0;
            for (int i = 0; i < house.size(); i++) { // 집에서 치킨집까지 거리가 몇인지 계산(그 중 최소)
                int min = Integer.MAX_VALUE; // 집-뽑은치킨집 중의 최소거리
                for (int j = 0; j < tgt.size(); j++) {
                     min = Math.min(min, Math.abs(house.get(i).r - tgt.get(j).r) + Math.abs(house.get(i).c - tgt.get(j).c));
                }
                // 집 하나의 치킨집들 다 확인 후 최소거리  =  min
                sum += min;
            }
            ans.add(sum);
            return;
        }

        // 반복
        for (int i = start; i < store.size(); i++) { // 가게 리스트의 개수를 다 조합해봐야 함
            tgt.add(store.get(i));
            comb(depth + 1, i + 1);
            tgt.remove(store.get(i));
        }
    }

    public static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
