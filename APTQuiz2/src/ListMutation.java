import java.util.ArrayList;

public class ListMutation {
    public ListNode alter(ListNode list) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (list != null) {
            arr.add(list.info);
            list = list.next;
        }
        for (int i = 0 ; i < arr.size() ; i++) {
            if (arr.get(i) % 2 == 0) {
                arr.add(i, arr.get(i));
                i++;
            }
            if (arr.get(i) % 2 == 1) {
                arr.remove(i);
                i--;
            }
        }
        for (int i : arr)
            System.out.println(i);

        ListNode l = new ListNode(-1);
        ListNode first = l;
        for (int i : arr) {
            l.next = new ListNode(i);
            l = l.next;
        }
        return first.next;
    }
}
    /*ListNode first;
    public ListNode alter(ListNode list) {

        *//*ListNode first = list;
        while (list != null) {
            if (list.info % 2 == 0) {
                list.next = new ListNode(list.info, list.next);
                list = list.next.next;
            }
            else
                list = list.next;
        }
        list = first;
        while (list != null) {

            if (list.next.info % 2 == 1) {
                list.next = list.next.next;
            }
            list = list.next;
        }
        while (first != null && first.info % 2 == 1)
            first = first.next;

        if (first.info % 2 == 1)
            return null;
        return first;*//*
        this.first = list;
        helperEven(list);
        return first;
    }*/


    /*public void helperEven(ListNode list) {
        if (list == null)
            return;
        if (list.info % 2 == 0) {
            list.next = new ListNode(list.info, list.next);
            helperEven(list.next.next);
        }
        helperEven(list.next);
    }*/