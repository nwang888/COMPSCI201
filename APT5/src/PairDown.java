public class PairDown {
    public int[] fold(int[] list) {
        int[] ret = new int[(list.length + 1)/2];
        int retCount = 0;
        for (int i = 0 ; i < list.length ; i += 2) {
            if (i+1 >= list.length)
                ret[retCount] += list[i];
            else {
                ret[retCount] += list[i] + list[i + 1];
                retCount++;
            }
        }
        return ret;
    }
}