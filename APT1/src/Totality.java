public class Totality {
    public int sum(int[] a, String stype) {
        int sum = 0;
        int interval = 0;
        int index = 0;
        if (stype.equals("all"))
            interval = 1;
        else if (stype.equals("even"))
            interval = 2;
        else if (stype.equals("odd")) {
            interval = 2;
            index = 1;
        }
        while (index < a.length) {
            sum += a[index];
            index += interval;
        }
        return sum;
    }
}