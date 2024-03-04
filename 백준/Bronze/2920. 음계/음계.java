import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true; // 오름차순 또는 내림차순일때는 true
        int[] scale = new int[8]; // 0~7 까지의 인덱스에 각 1~8숫자 담겨있음
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 8; i++) {
            scale[i] = Integer.parseInt(st.nextToken());
        }

        if (scale[0] != 1 && scale[0] != 8)
        {
            System.out.println("mixed");
            return;
        }

        if (scale[0] == 1) { // 오름차순일때
            for (int i = 0; i < 7; i++) {
                if (scale[i]+1 != scale[i+1]) {
                    flag = false;
                    break;
                }
            }
            if (flag == true && scale[7] == 8) {
                System.out.println("ascending");
            }

        } else if (scale[0] == 8) { // 내림차순일때
            for (int i = 0; i < 7; i++) {
                if (scale[i]-1 != scale[i+1]) {
                    flag = false;
                    break;
                }
            }
            if (flag == true && scale[7]==1) {
                System.out.println("descending");
            }
        }

        if(!flag) System.out.println("mixed");
    }
}
