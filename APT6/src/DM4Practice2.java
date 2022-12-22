public class DM4Practice2 {

    private static class ListNode {
        int info;
        ListNode next;
        ListNode(int x){
            info = x;
        }
        ListNode(int x, ListNode node){
            info = x;
            next = node;
        }
    }

    public static ListNode addOne(ListNode list) {
        if (list == null)
            return null;
        return new ListNode(list.info, list);
    }

    public static ListNode addMany(ListNode list) {
        if (list == null)
            return null;
        String tabs = addTabs(list.info);
        System.out.println(tabs + "list: " + print(list));
        ListNode afterMe = addMany(list.next);
        System.out.println(tabs + "afterMe: " + print(afterMe));
        ListNode first = addOne(list);
        System.out.println(tabs + "first: " + print(first));
        list.next = afterMe;
        System.out.println(tabs + "list: " + print(list));
        System.out.println(tabs + "first: " + print(first));
        return first;
    }

    public static ListNode create(int n) {
        ListNode first = null;
        while (n > 0) {
            first = new ListNode(n, first);
            n--;
        }
        return first;
    }

    public static ListNode fromArray(int[] values) {
        ListNode first = null;
        for (int k = values.length - 1; k >= 0 ; k--)
            first = new ListNode(values[k], first);
        return first;
    }

    public static int sumArray(ListNode[] array) {
        int sum = 0;
        for (ListNode list : array)
            sum += sumRec(list);
        return sum;
    }

    public static int sumRec(ListNode list) {
        if (list == null)
            return 0;
        return list.info + sumRec(list.next);
    }

    public static int valueOf() {
        int[] a = {2,4,6,8};
        ListNode list = fromArray(a);
        ListNode[] array = new ListNode[10];

        for (int k = 0 ; k < array.length ; k++)
            array[k] = list;
        return sumArray(array);
    }

    public static ListNode splicer(ListNode list, int spliceVal) {
        ListNode first = list;
        System.out.println(count(first));
        while (list != null) {
            list.next = new ListNode(spliceVal, list.next);
            list = list.next.next;
        }
        System.out.println(count(first));
        return first;
    }

    public static int count (ListNode list) {
        int count = 0;
        while (list != null) {
            count++;
            list = list.next;
        }
        return count;
    }

    public static String print(ListNode list) {
        String ret = "";
        while (list != null) {
            ret += list.info + " -> ";
            list = list.next;
        }
        ret += "null";
        return ret;
    }

    public static String addTabs(int x) {
        String ret = "";
        for (int i = 0 ; i < x ; i++)
            ret += "\t";
        return ret;
    }

    public static void main(String[] args) {
        ListNode test = new ListNode(1, new ListNode(2, new ListNode( 3)));
        //addMany(test);
        ListNode[] testArr = {new ListNode(15, new ListNode(12, new ListNode( 8))),
                              null,
                              new ListNode(8, new ListNode( 2))};
        /*System.out.println(sumRec(testArr[0]));
        System.out.println(sumArray(testArr));
        int sum[] = {2,4,6,8};
        System.out.println(print(fromArray(sum)));
        System.out.println(valueOf());
        System.out.println(print(create(10))); */
        ListNode list1 = create(10);
        count(splicer(list1,99));
        System.out.println("\n");
        ListNode list2 = create(10);
        count(splicer(splicer(list2,99),99));
    }
}
