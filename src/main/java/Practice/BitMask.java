package Practice;

public class BitMask {
    static int N = 10;
    static boolean[] visited;
    public static void main(String[] args) {
        int a = 1<<1;   // 10 -> 2
        int b = 1<<2;   // 100 -> 4
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        b = 7<<2;
        System.out.println("b = " + b); // 4*7 = 28
        System.out.println(25 & 28);    // 11001 & 11100 -> 11000(24)
        System.out.println(5 & 2);      // 101 & 010 -> 000(0)
        System.out.println(5 & 7);      // 101 & 111 -> 101(5)

        int c = 2<<2;
        System.out.println("c = " + c);
        System.out.println(Integer.toString(c, 2));

        visited = new boolean[N];
        combination(0,0,3,0);


    }

    public static void combination(int index, int depth, int count, int mask){
        if(depth == count){
            System.out.println(Integer.toString(mask, 2));
            return;
        }
        if(index >= N){
            return;
        }
        visited[index] = true;
        combination(index+1, depth+1, count, mask | 1<<(10-1-index));
        visited[index] = false;
        combination(index+1, depth, count, mask);
    }
}
