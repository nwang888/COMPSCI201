import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TxMsg {
    public String getMessage(String str) {
        String strreturn = "";
        List<String> strArr = Arrays.asList(str.split(" "));
        for (String string : strArr) {
            int vowelCount = 0;

            if (!isVowel(string.substring(0,1)))
                strreturn += string.substring(0, 1);
            else
                vowelCount++;

            for (int i = 1; i < string.length(); i++) {
                String s = string.substring(i, i + 1);
                String prev = string.substring(i - 1, i);

                if (isVowel(s))
                    vowelCount++;

               /* if (!isVowel(prev) && !isVowel(s))
                    strreturn += "";
                else if (!isVowel(prev) && isVowel(s))
                    strreturn += "";
                else if (isVowel(prev) && isVowel(s))
                    strreturn += "";*/
                else if (isVowel(prev) && !isVowel(s))
                    strreturn += s;
            }
            if (vowelCount == string.length())
                strreturn += string;
            strreturn += " ";
        }
        return strreturn.substring(0,strreturn.length()-1);
    }

    public boolean isVowel(String str) {
        switch (str) {
            case "a":
            case "e":
            case "i":
            case "o":
            case "u":
                return true;
            default:
                return false;
        }
    }
}
