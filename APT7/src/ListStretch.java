import java.util.ArrayList;

public class ListStretch {
    public ListNode stretch (ListNode list, int amount){
        //dumb way by converting everything to ArrayList first - takes too long
        /*ArrayList<Integer> alist = new ArrayList<>();
        while (list != null) {
            alist.add(list.info);
            list = list.next;
        }

        ArrayList<Integer> dupList = new ArrayList<>();
        for (int i = 0 ; i < alist.size() ; i++)
            for (int j = 0 ; j < amount ; j++)
                dupList.add(alist.get(i));


        ListNode first = new ListNode(dupList.get(0));
        ListNode llist = first;
        for (int i = 1 ; i < dupList.size() ; i++) {
            llist.next = new ListNode(dupList.get(i));
            llist = llist.next;
        }
        return first;*/

        //smart way by re-arranging pointers
    }
}