import java.util.ArrayList;

/**
 * @ author N Wang
 * @ author Andrew Sun
 */


public class LinkStrand implements IDnaStrand{

    private class Node {
        String info;
        Node next;

        public Node(String s, Node n) {
            info = s;
            next = n;
        }
    }

    private Node myFirst, myLast;
    private long mySize;
    private int myAppends;
    private int myIndex;
    private Node myCurrent;
    private int myLocalIndex;

    public LinkStrand() {
        this("");
    }

    public LinkStrand(String strand) {
        initialize(strand);
    }

    @Override
    public long size() {
        return mySize;
    }

    @Override
    public void initialize(String source) {
        myFirst = new Node(source, null);
        myCurrent = myFirst;
        myLast = myFirst;
        mySize = source.length();
        myIndex = 0;
        myLocalIndex = 0;
        myAppends = 0;
    }

    @Override
    public IDnaStrand getInstance(String source) {
        return new LinkStrand(source);
    }

    @Override
    public IDnaStrand append(String dna) {
        myLast.next = new Node(dna, null);
        myLast = myLast.next;
        mySize += dna.length();
        myAppends++;
        return this;
    }

    @Override
    public IDnaStrand reverse() {
        ArrayList<String> nodeInfos = new ArrayList<>();
        //add all the node infos, reversed, into the arraylist
        Node n = myFirst;
        while (n != null) {
            nodeInfos.add(reverseString(n.info));
            n = n.next;
        }

        //create new LinkStrand and add all reversed values in backward order
        LinkStrand ret = new LinkStrand(nodeInfos.get(nodeInfos.size() - 1));
        for (int i = nodeInfos.size() - 2 ; i >= 0 ; i--)
            ret.append(nodeInfos.get(i));

        return ret;
    }

    private String reverseString(String str) {
        StringBuilder copy = new StringBuilder(str);
        copy.reverse();
        return copy.toString();
    }

    @Override
    public int getAppendCount() {
        return myAppends;
    }

    @Override
    public char charAt(int index) {
        if (index > mySize - 1 || index < 0)
            throw new IndexOutOfBoundsException();

        int count = 0;
        int localIndex = 0;
        Node list = myFirst;

        if (index >= myIndex) {
            count = myIndex;
            localIndex = myLocalIndex;
            list = myCurrent;
        }

        while (count != index) {
            count++;
            localIndex++;
            if (localIndex == list.info.length()) {
                localIndex = 0;
                list = list.next;
            }
        }
        myIndex = index;
        myCurrent = list;
        myLocalIndex = localIndex;
        return list.info.charAt(localIndex);
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        Node n = myFirst;
        while (n != null) {
            ret.append(n.info);
            n = n.next;
        }
        return ret.toString();
    }
}
