import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 받을 때 앞 뒤 공백이 있다면 제거
        String s = br.readLine().trim();
        if (s.isEmpty()) {
            System.out.println(0);
        } else {
            String[] strArr = s.split(" ");
            System.out.println(strArr.length);
        }
    }
}
