import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new TreeSet<>((o1, o2) -> {

            if (o1.length()==o2.length()) {
               return o1.compareTo(o2);
            } return o1.length() - o2.length();
        });

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for(String s : set) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
