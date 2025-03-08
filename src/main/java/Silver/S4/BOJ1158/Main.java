package Silver.S4.BOJ1158;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// 요세푸스 문제
public class Main {
    static int N;       // 사람의 수
    static int K;       // K번째 사람 제거
    static List<Integer> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        int index = -1;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (list.size() > 0) {
            index += K;
            while (index >= list.size()) {
                index -= list.size();
            }
            sb.append(list.get(index)).append(", ");
            list.remove(index);
            index -= 1;
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
        bw.write(sb.toString());
        bw.flush();
    }
}
