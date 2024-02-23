import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1759 - 암호 만들기
public class Main {
    static int L, C;
    static String[] src, tgt;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken()); // 조합하고 싶은 개수
        C = Integer.parseInt(st.nextToken()); // 주어진 문자의 개수
        // 서로 다른 L개의 알파벳 소문자들로 구성되며 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음
        src = new String[C];
        tgt = new String[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            src[i] = st.nextToken();
        }
        Arrays.sort(src); // 암호를 이루는 알파벳이 암호에서 증가하는 순서로 배열되었을 것

        combi(0, 0);
        System.out.println(sb);
    }

    private static void combi(int depth, int start) {
// 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음
        if (depth == L) { // depth가 tgt 배열의 크기(조합원하는 개수)랑 같아질때마다 tgt배열 출력
            int aei = 0;
            for (int i = 0; i < L; i++) {
                if (tgt[i].equals("a") || tgt[i].equals("e") || tgt[i].equals("i") || tgt[i].equals("o") || tgt[i].equals("u")){
                    aei++;
                }
            }
            if (aei > 0) {
                if (L-aei >=2) {
                    for (String s : tgt) {
                        sb.append(s);
                    } sb.append("\n");
                }
            }
            return;
        }

        for (int i = start; i < C; i++) {
            tgt[depth] = src[i];
            combi(depth+1, i+1);
        }
    }
}
