import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String num = br.readLine();

        List<Integer> listArr = new ArrayList<>();
        for (int i = 0; i < num.length(); i++) {
            listArr.add(num.charAt(i)-'0');
        }

        Collections.sort(listArr, Collections.reverseOrder());

        for (Integer l : listArr) {
            sb.append(l);
        }
        System.out.println(sb);
    }
}