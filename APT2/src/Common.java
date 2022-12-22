import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Common {
    public int count (String a, String b) {
        int count = 0;
        ArrayList<String> aArr = new ArrayList<String>();
        ArrayList<String> bArr = new ArrayList<String>();
        for (int i = 0 ; i < a.length() ; i++)
            aArr.add(a.substring(i,i+1));
        for (int i = 0 ; i < b.length() ; i++)
            bArr.add(b.substring(i,i+1));

        for (int i = 0 ; i < bArr.size() ; i++)
            for (int j = 0 ; j < aArr.size() ; j++)
                if (aArr.get(i).equals((bArr.get(j)))) {
                    count++;
                    bArr.remove(i);
                    i--;
            }
        return count;
    }
}