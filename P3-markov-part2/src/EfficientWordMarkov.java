import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class EfficientWordMarkov extends BaseWordMarkov {
    private Map<WordGram, ArrayList<String>> myMap;

    public EfficientWordMarkov() {
        this(3);
    }

    public EfficientWordMarkov(int order) {
        super(order);
        myMap = new HashMap<>();
    }

    @Override
    public void setTraining(String text) {
        super.setTraining(text);
        myMap.clear();
        for (int i = 0 ; i < myWords.length - myOrder; i++) {
            WordGram key = new WordGram(myWords, i, myOrder);
            myMap.putIfAbsent(key, new ArrayList<>());
            if (i == myWords.length - myOrder)
                myMap.get(key).add(PSEUDO_EOS);
            else
                myMap.get(key).add(myWords[i + myOrder]);
        }
    }

    @Override
    public ArrayList<String> getFollows(WordGram kgram) {
        if (!myMap.containsKey(kgram))
            throw new NoSuchElementException(kgram.toString()+" not in map");
        return myMap.get(kgram);
    }
}
