public class NOTSUBMITTABLEruntime {

    public static int calc(int n) {
        int sum = 0;
        int limit = n;
        while (limit > 1) {
            sum += n;
            limit = limit/2;
        }
        return sum;
    }

    public static int bazz (int n) {
        int sum = 0;
        for (int i = 1 ; i < n ; i += 4)
            sum += n;
        return sum;
    }

    public static void runtime() {
        int[] input = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int countDownInput = 50;
        int temp = calc(input[0]);
        for (int i = 1 ; i < input.length ; i++) {
        //for (int i = countDownInput ; i >= 0 ; i--) {
            long start = System.nanoTime();
            temp = bazz(i);
            long end = System.nanoTime();
            System.out.println(" Input : " + i + "\t\t\t" + " Return : " + temp + "\t\t\t" + "Time : " + (end - start));
        }
    }

    public static int stub(int n) {
        int sum = 0;
        for (int k = 1 ; k <= n ; k *= 2)
            sum += k;
        return sum;
    }

    public static void main(String[] args) {
        System.out.print(stub(1024));
    }
}
