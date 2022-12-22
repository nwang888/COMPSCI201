public class RemoveLast {
    public ListNode remove(ListNode list) {
        ListNode first = list;
        while (list != null && list.next.next != null) {
            list = list.next;
        }
        if (list != null)
            list.next = null;
        return first;
    }
}