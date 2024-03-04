import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] score = new double[N];

        double max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            double temp = Double.parseDouble(st.nextToken());
            score[i] = temp;
            max = Math.max(max, temp);
        }
        for (int i = 0; i < N; i++) {
            score[i] = score[i] / max * 100;
        }
        double sum = 0;
        for (double d : score) {
            sum += d;
        }
        System.out.println(sum / N);
    }
}
