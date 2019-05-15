public class Operation {

    /**
     * 返回 a + b
     * 
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b) {
        int c = a;
        while (b != 0) {
            c = a ^ b;
            b = (a & b) << 1;
            a = c;
        }
        return c;
    }



    /**
     * 返回 a - b
     * 
     * @param a
     * @param b
     * @return
     */
    public static int minus(int a, int b) {
        return add(a, add(~b, 1));
    }



    /**
     * 返回 a * b
     * 
     * @param a
     *           a >= 0
     * @param b
     *           b >= 0
     * @return
     */
    private static int multipZ(int a, int b) {
        int ret = 0;
        int in = 0;
        while ((1 << in) <= b) {
            if ((b & (1 << in)) > 0) {
                ret = add(ret, a << in);
            }
            in = add(in, 1);
        }
        return ret;
    }



    /**
     * 返回 a * b
     * 
     * @param a
     * @param b
     * @return
     */
    public static int multip(int a, int b) {
        boolean boola = true, boolb = true;
        if (a < 0) {
            boola = false;
            a = add(~a,1);
        }
        if (b < 0) {
            boolb = false;
            b = add(~b,1);
        }
        int ret = multipZ(a,b);
        if(boola != boolb){
            ret = add(~ret,1);
        }
        return ret;
    }



    public static void main(String[] args) {
        System.out.println(multip(3, 55));
        System.out.println(multip(-3, -55));
        System.out.println(multip(3, -55));
    }
}
