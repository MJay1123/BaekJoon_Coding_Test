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
    static int KBS1;
    static int KBS2;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        channels = new String[N];
        KBS1 = 0;
        KBS2 = 0;
        for(int i=0; i<N; i++){
            channels[i] = br.readLine();
            if(channels[i].equals("KBS1")){
                KBS1 = i;
            }
            if(channels[i].equals("KBS2")){
                KBS2 = i;
            }
        }
        while(!channels[0].equals("KBS1")){
            if(arrow > KBS1){
                command2();
            } else if(arrow < KBS1){
                command1();
            } else {
                while(KBS1 > 0){
                    command3();
                }
                while(KBS1 < 0){
                    command4();
                }
            }
        }
        while(KBS2 != 1){
            if(arrow > KBS2){
                command2();
            } else if(arrow < KBS2){
                command1();
            } else {
                while(KBS2 > 1){
                    command3();
                }
                while(KBS2 < 1){
                    command4();
                }
            }
        }
        for(int i=0; i<commands.size(); i++){
            bw.write(commands.get(i));
        }
        bw.write("\n");
        bw.flush();
    }

    public static void command1(){      // 화살표를 한 칸 아래로
        commands.add(1);
        if(checkRange(arrow+1)) {
            arrow += 1;
        }
    }
    public static void command2(){      // 화살표를 한 칸 위로
        commands.add(2);
        if(checkRange(arrow-1)){
            arrow -= 1;
        }
    }
    public static void command3(){      // 채널을 한 칸 아래로
        commands.add(3);
        if(checkRange(arrow+1)){
            change(arrow, arrow+1);
            arrow += 1;
        }
    }
    public static void command4(){      // 채널을 한 칸 위로
        commands.add(4);
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
