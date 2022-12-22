import java.util.Collections;

public class PrefixCode {
    public String isOne(String[] words) {
        int count = 0;
        for (int i = 0 ; i < words.length ; i++)
            for (int k = 0 ; i < words.length ; i++)
                if (i != k && words[k].equals(words[i].substring(0,words[k].length())))
                    count++;
        String strreturn = "";
        if (count == 0)
            strreturn += "Yes";
        else
            strreturn += "No, " + count;
        return strreturn;
    }
}