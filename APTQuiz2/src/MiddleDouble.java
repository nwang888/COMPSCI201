public class MiddleDouble {
    public ListNode change(ListNode list) {
        list = removeMid(list);
        return duplicate(list);
    }

    private ListNode duplicate(ListNode list) {
        ListNode first = list;
        ListNode last = list;
        while (last.next != null) {
            last = last.next;
        }
        ListNode half = last;
        while (list != half.next) {
            last.next = new ListNode(list.info);
            last = last.next;
            list = list.next;
        }
        return first;
    }

    private ListNode removeMid(ListNode list) {
        ListNode first = list;
        int half = count(list)/2;
        int i = 0;
        while (list != null) {
            if (i + 1 == half) {
                list.next = list.next.next;
            }
            i++;
            list = list.next;
        }
        return first;
    }

    private int count(ListNode list) {
        if (list == null)
            return 0;
        return 1 + count(list.next);
    }
}
