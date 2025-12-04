package Gold.G4.BOJ9019;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    static String answer = "";
    static String[] commands = {"D", "S", "L", "R"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[10000];
            BFS(before, visited, after);
            bw.write(answer + "\n");
        }
        bw.flush();
    }

    public static void BFS(int num, boolean[] visited, int after) {
        Queue<Integer> numberQueue = new LinkedList<>();
        Queue<String> commandQueue = new LinkedList<>();
        numberQueue.offer(num);
        commandQueue.offer("");
        visited[num] = true;
        while (!numberQueue.isEmpty() && !commandQueue.isEmpty()) {
            num = numberQueue.poll();
            String command = commandQueue.poll();
            if (num == after) {
                answer = command;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int newNum = calculate(num, i);
                if (!visited[newNum]) {
                    numberQueue.offer(newNum);
                    commandQueue.offer(command + commands[i]);
                    visited[newNum] = true;
                }
            }
        }
    }

    public static int calculate(int num, int index) {
        switch (index) {
            case 0:
                return D(num);
            case 1:
                return S(num);
            case 2:
                return L(num);
            case 3:
                return R(num);
        }
        return 0;
    }

    public static int D(int num) {
        num *= 2;
        return num % 10000;
    }

    public static int S(int num) {
        num--;
        if (num < 0) {
            num += 10000;
        }
        return num;
    }

    public static int L(int num) {
        int d = num % 10;
        num /= 10;
        int c = num % 10;
        num /= 10;
        int b = num % 10;
        num /= 10;
        int a = num % 10;
        return (((b * 10 + c) * 10 + d) * 10 + a);
    }

    public static int R(int num) {
        int d = num % 10;
        num /= 10;
        int c = num % 10;
        num /= 10;
        int b = num % 10;
        num /= 10;
        int a = num % 10;
        return (((d * 10 + a) * 10 + b) * 10 + c);
    }
}