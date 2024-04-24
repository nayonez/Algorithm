import java.io.BufferedReader;
import java.io.InputStreamReader;
// https://www.acmicpc.net/problem/11718 - 그대로 출력하기
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
    }
}
