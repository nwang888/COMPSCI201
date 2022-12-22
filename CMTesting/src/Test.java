public class Test {
    public static String createZ(int n) {
        String ret = "";
        for (int k = 0 ; k < n ; k++)
            ret += "Z";
        return ret;
    }

    public static String createA(int n) {
        StringBuilder ret = new StringBuilder();
        for (int k = 0 ; k < n ; k++)
            ret.append("A");
        return ret.toString();
    }

    public static int calc(int n) {
        int total = 0;
        for(int k=0; k < n; k++) {
            total += k;
        }
        for(int k=1; k < n; k*=2) {
            total += k;
        }
        return total;
    }

    public static void main(String[] args) {
        /*int n = 5;
        System.out.println(createZ(n));
        System.out.println(createA(n));
        System.out.println(createZ(n).replace("Z","A").equals(createA(n)));*/

        for (int i = 0 ; i < 20 ; i++) {
            long start = System.nanoTime();
            createZ(i);
            long end = System.nanoTime();
            long time = end - start;
            System.out.println(i + " " + time);
        }

        /*for (int i = 0 ; i < 20 ; i++) {
            System.out.print(i + ": " + calc(i) + "   ");
            System.out.println(i*Math.log(i));
        }*/
    }
}