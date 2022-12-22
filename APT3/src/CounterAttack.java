public class CounterAttack {
    public int[] analyze(String str, String[] words) {
        String[] list = str.split(" ");
        int[] arrreturn = new int[words.length];
        for (int i = 0 ; i < words.length; i++) {
            int count = 0;
            for (String l : list)
                if (words[i].equals(l))
                    count++;
            arrreturn[i] = count;
        }
        return arrreturn;
    }
}