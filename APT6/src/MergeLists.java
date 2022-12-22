import java.util.ArrayList;

public class MergeLists {
    public ListNode weave (ListNode a, ListNode b) {
        /*//dumb way by converting everything to ArrayList first
        ArrayList<Integer> list = new ArrayList<>();
        while (a != null && b != null) {
            list.add(a.info);
            list.add(b.info);
            a = a.next;
            b = b.next;
        }

        ListNode first = new ListNode(list.get(0));
        ListNode llist = first;
        for (int i = 1 ; i < list.size() ; i++) {
            llist.next = new ListNode(list.get(i));
            llist = llist.next;
        }
        return first;*/

        //smart way by re-arranging pointers
        ListNode tempA, tempB, first;
        first = a;
        while (b != null) {
            tempA = a.next;
            a.next = b;
            tempB = b.next;
            b.next = tempA;
            a = tempA;
            b = tempB;
        }
        return first;
    }
}