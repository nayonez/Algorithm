import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int a = 42;
        // 중복 제거해주는 hashset
        HashSet arrayList = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            // .add로 값 넣어주기
            arrayList.add(n % 42);
        }
        System.out.println(arrayList.size());

    }
}
