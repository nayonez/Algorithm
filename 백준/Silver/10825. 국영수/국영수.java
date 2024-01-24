import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Student> students = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korea = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            students.offer(new Student(name, korea, english, math));
        
        }
        while (!students.isEmpty()) {
            Student student = students.poll();
            sb.append(student.name).append("\n");
        }
        System.out.println(sb);
    }

    public static class Student implements Comparable<Student> {
        String name;
        int korea, english, math;

        public Student(String name, int korea, int english, int math) {
            this.name = name;
            this.korea = korea;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student student) {
            if (korea==student.korea&&english==student.english&&math==student.math) {
                return name.compareTo(student.name);
            } else if (korea==student.korea&&english==student.english) {
                return student.math - this.math;
            } else if (korea==student.korea) {
                return this.english - student.english;
            } else {
                return student.korea - this.korea;
            }
        }
    }
}