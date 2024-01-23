
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        boolean[][] map = new boolean[100][100];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int area = 0;

        for (int n = 0; n < 4; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    map[i][j] = true;
                }
            }
        }

        for (int i = 0; i < 100; i ++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j]) {
                    area = area + 1;
                }
            }
        }
        System.out.println(area);
    }
}
