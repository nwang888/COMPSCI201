import java.util.*;

public class Thesaurus {
    public String[] edit(String[] entry) {
        ArrayList<TreeSet<String>> list = convert(entry);

        while (true) {
            int size = list.size();
            list = combine(list);
            if (list.size() == size)
                break;
        }

        ArrayList<String> ret = new ArrayList<>();
        for (TreeSet<String> set : list) {
            String s = String.join(" ", set);
            ret.add(s);
        }

        Collections.sort(ret);
        return ret.toArray(new String[0]);
    }

    /**
     * Combine goes throughout the entire arraylist and looks for arraylists that contain two similar words
     * and combines them and returns the arraylist with a singular combined array
     */
    private ArrayList<TreeSet<String>> combine(ArrayList<TreeSet<String>> list) {
        ArrayList<TreeSet<String>> newList = new ArrayList<>();
        TreeSet<String> ret = new TreeSet<>();
        int index1 = -1;
        int index2 = -1;

        for (int i = 0; i < list.size(); i++) {
            boolean flag = false;
            for (int j = i; j < list.size(); j++) {
                TreeSet<String> temp = new TreeSet<>(list.get(i));
                temp.retainAll(list.get(j));
                if (temp.size() >= 2) {
                    //save the i and j
                    index1 = i;
                    index2 = j;
                    //assign ret with the combined version of i and j
                    ret.addAll(list.get(i));
                    ret.addAll(list.get(j));
                    flag = true;
                    break;
                }
            }
            if (flag)
                break;
        }

        for (int i = 0 ; i < list.size() ; i++)
            if (i == index1)
                newList.add(ret);
            else if (i != index2)
                newList.add(list.get(i));
        return newList;
    }

    private ArrayList<TreeSet<String>> convert(String[] entry) {
        ArrayList<TreeSet<String>> ret = new ArrayList<>();
        for (String e : entry)
            ret.add(new TreeSet(Arrays.asList(e.split(" "))));
        return ret;
    }
}
