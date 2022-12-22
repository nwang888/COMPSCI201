public class Anonymous {
    public int howMany(String[] headlines, String[] messages) {
        String all = "";
        for (String s : headlines)
            all += s.toLowerCase();
        int count = 0;
        for (String m : messages)
            if (canMake(m.toLowerCase(),all))
                count++;
        return count;

        /*int[] chCounts = new int[123];
        int count = 0;
        for (String s : headlines)
            for (char ch : s.toLowerCase().toCharArray())
                chCounts[ch]++;
        int[] mCounts = new int[123];
        for (int i = 0 ; i < messages.length ; i++) {
            boolean flag = true;
            for (char ch : messages[i].toLowerCase().toCharArray()) {
                mCounts[ch]++;
                if (!Character.isWhitespace(ch) && chCounts[ch] < mCounts[ch])
                    flag = false;
            }
            if (flag) count++;
        }
        return count;*/
    }

    private boolean canMake(String message, String headline) {
        for (char ch = 'a'; ch <= 'z' ; ch++) {
            int mcount = count(message, ch);
            int hcount = count(headline, ch);
            if (mcount > hcount)
                return false;
        }
        return true;
    }

    private int count(String s, char ch) {
        int t = 0;
        for (char c : s.toCharArray())
            if (c == ch)
                t++;
        return t;
    }
}
