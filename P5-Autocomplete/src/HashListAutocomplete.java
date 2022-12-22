import java.util.*;

public class HashListAutocomplete implements Autocompletor{

    private static final int MAX_PREFIX = 10;
    private Map<String, List<Term>> myMap;
    private int mySize;

    public HashListAutocomplete(String[] terms, double[] weights) {
        if (terms == null || weights == null) {
            throw new NullPointerException("One or more arguments null");
        }

        initialize(terms,weights);
    }

    @Override
    public List<Term> topMatches(String prefix, int k) {
        if (prefix == null)
            throw new NullPointerException("Prefix is null");
        if (!(myMap.containsKey(prefix)))
            return new ArrayList<Term>();
        if (k == 0)
            return new ArrayList<Term>();
        if (k < 0)
            throw new IllegalArgumentException("Illegal value of k: " + k);

        List<Term> all = myMap.get(prefix);
        List<Term> list = all.subList(0, Math.min(k, all.size()));
        return list;
    }

    @Override
    public void initialize(String[] terms, double[] weights) {
        myMap = new HashMap<String, List<Term>>();
        for (int i = 0 ; i < terms.length ; i++) {
            String t = terms[i];
            for (int j = 0 ; j <= Math.min(MAX_PREFIX, t.length()) ; j++) {
                if (t.length() >= j) {
                    myMap.putIfAbsent(t.substring(0, j), new ArrayList<Term>());
                    myMap.get(t.substring(0, j)).add(new Term(terms[i], weights[i]));
                }
            }
        }
        for (String key : myMap.keySet())
            Collections.sort(myMap.get(key), Comparator.comparing(Term::getWeight).reversed());
    }

    @Override
    public int sizeInBytes() {
        if (mySize == 0) {
            for (String key : myMap.keySet()) {
                mySize += key.length() * BYTES_PER_CHAR;
                List<Term> list = myMap.get(key);
                for (Term t : list) {
                    mySize += BYTES_PER_DOUBLE + BYTES_PER_CHAR * t.getWord().length();
                }
            }
        }
        return mySize;
    }
}
