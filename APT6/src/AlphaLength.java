import java.util.Arrays;
import java.util.HashSet;

public class AlphaLength {
    public ListNode create (String[] words) {
        HashSet<String> set = new HashSet<String>(Arrays.asList(words));
        words = set.toArray(new String[0]);
        Arrays.sort(words);

        ListNode first = new ListNode(words[0].length());
        ListNode list = first;
        for (int i = 1 ; i < words.length ; i++) {
            list.next = new ListNode(words[i].length());
            list = list.next;
        }
        return first;
    }
}