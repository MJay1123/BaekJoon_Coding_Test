package notyet.BOJ2816;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// 디지털 티비
public class Main {
    static int N;                   // 채널의 수
    static String[] channels;       // 채널
    static int arrow = 0;
    static List<Integer> commands = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        channels = new String[N];
        for(int i=0; i<N; i++){
            channels[i] = br.readLine();
        }
        process(0);
    }

    public static void process(int num) throws IOException {
        if(channels[0].equals("KBS1") && channels[1].equals("KBS2")){
            for(int i=0; i<commands.size(); i++){
                bw.write(commands.get(i));
            }
            bw.write("");
            bw.flush();
            return;
        }
        if(commands.size() >= 500){
            return;
        }
        switch(num){
            case 1:
                commands.add(1);
                command1();
                commands.remove(commands.size()-1);
                break;
        }
        commands.add(1);
        command1();
        commands.remove(commands.size()-1);

        commands.add(2);
        command2();
        commands.remove(commands.size()-1);

        commands.add(3);
        command3();
        commands.remove(commands.size()-1);

        commands.add(4);
        command4();
        commands.remove(commands.size()-1);
    }

    public static void command1(){      // 화살표를 한 칸 아래로
        if(checkRange(arrow+1)) {
            arrow += 1;
        }
    }
    public static void command2(){      // 화살표를 한 칸 위로
        if(checkRange(arrow-1)){
            arrow -= 1;
        }
    }
    public static void command3(){      // 채널을 한 칸 아래로
        if(checkRange(arrow+1)){
            change(arrow, arrow+1);
            arrow += 1;
        }
    }
    public static void command4(){      // 채널을 한 칸 위로
        if(checkRange(arrow-1)){
            change(arrow, arrow-1);
            arrow -= 1;
        }
    }

    public static void change(int a, int b){
        String temp = channels[a];
        channels[a] = channels[b];
        channels[b] = temp;
    }

    public static boolean checkRange(int index){
        return(index >= 0 && index < N);
    }

}
