public class Operation {

    /**
     * 返回 a + b
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b){
        int c;
        while (b != 0) {
            c = a ^ b;
            b = (a & b)<<1;
            a = c;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(add(20,50));
    }
}