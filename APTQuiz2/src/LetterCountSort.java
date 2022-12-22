import java.util.*;

public class LetterCountSort {

    String specialChars;

    private class Word {
        String str;
        public Word(String str) {
            this.str = str;
        }

        public int getSpecChars() {
            int count = 0;
            for (char ch : str.toCharArray()) {
                if (specialChars.contains(Character.toString(ch)))
                    count++;
            }
            System.out.print(count);
            return count;
        }
        public String toString() {
            return str;
        }
    }

    public String[] sort(String[] list, String specialChars) {
        this.specialChars = specialChars;
        Arrays.sort(list);

        ArrayList<Word> alist = new ArrayList<>();

        for (String str: list)
            alist.add(new Word(str));

        Collections.sort(alist, Comparator.comparing(Word::getSpecChars).thenComparing(Word::toString));

        ArrayList<String> ret = new ArrayList<>();
        for (Word w : alist)
            ret.add(w.toString());
        return ret.toArray(new String[0]);
    }
}
