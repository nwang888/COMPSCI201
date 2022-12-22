import java.util.ArrayList;

public class DNAMaxNucleotide {
    public String max(String[] strands, String nuc) {
        int maxCount = 0;
        String maxString = "";
        int maxLength = 0;
        for (String str : strands) {
            int count = 0;
            for (int i = 0; i < str.length(); i++)
                if (str.substring(i, i + 1).equals(nuc))
                    count++;
            if (count > maxCount) {
                maxString = str;
                maxCount = count;
                maxLength = str.length();
            }
            else if (maxCount != 0 && count == maxCount) {
                if (str.length() > maxLength){
                    maxLength = str.length();
                    maxString = str;
                }
            }
        }
        return maxString;
    }
/*    public String max(String[] strands, String nuc) {
        ArrayList<> arr = new ArrayList<>();
        for (String str : strands)
            arr.add(str);
        for (String str : arr)

    }*/
}