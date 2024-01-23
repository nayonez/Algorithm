import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int cookMinute = Integer.parseInt(br.readLine());
        int totalMinute = minute + cookMinute;

        if (totalMinute < 60) {
            minute = minute + cookMinute;
            System.out.print(sb.append(hour).append(" ").append(minute));
          } else if (totalMinute >= 60) {
            hour += totalMinute / 60;
            minute = totalMinute % 60;
            if (hour >= 24) {
                hour -= 24;
            }
            System.out.println(sb.append(hour).append(" ").append(minute));
        }
    }
}
