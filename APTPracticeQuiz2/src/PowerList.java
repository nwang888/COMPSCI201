public class PowerList {
    public ListNode create(int n) {
        if (n == 1)
            return null;
        int x = 1;
        ListNode list = new ListNode(x);
        ListNode first = list;
        while (x*2 < n) {
            x *= 2;
            list.next = new ListNode(x);
            list = list.next;
        }
        return first;
    }
}
