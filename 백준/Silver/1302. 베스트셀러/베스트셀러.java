import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 오늘 팔린 책의 수 N
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) { // 책의 제목 입력받음
            String title = br.readLine();
            if (!map.containsKey(title)) {
                map.put(title, 1);
            } else {
                map.put(title, map.get(title) + 1);
            }
        }

        int max = Integer.MIN_VALUE;
        String k = "";
        for (String key : map.keySet()) {
            if (max < map.get(key)) {
                max = Math.max(max, map.get(key));
                k = key;
            }
        }
        ArrayList<String> list = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) == map.get(k)) {
                list.add(key);
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));

    }
}
