import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class MedalTable {

    private class MedalCountry {
        int myGold, mySilver, myBronze;
        String name;
        public MedalCountry(String name, int myGold, int mySilver, int myBronze) {
            this.name = name;
            this.myGold = myGold;
            this.mySilver = mySilver;
            this.myBronze = myBronze;
        }

        public MedalCountry(String name) {
            this.name = name;
            myGold = 0;
            mySilver = 0;
            myBronze = 0;
        }

        public String getName() {
            return name;
        }

        public int getMyBronze() {
            return myBronze;
        }

        public int getMySilver() {
            return mySilver;
        }

        public int getMyGold() {
            return myGold;
        }

        public void addBronze(int x) {
            myBronze += x;
        }

        public void addSilver(int x) {
            mySilver += x;
        }

        public void addGold(int x) {
            myGold += x;
        }

        public String toString() {
            return name + " " + myGold + " " + mySilver + " " + myBronze;
        }
    }

    public String[] generate(String[] results) {
        HashMap<String, MedalCountry> map = new HashMap<>();
        for (String str : results) {
            String[] parse = str.split(" ");
            map.putIfAbsent(parse[0], new MedalCountry(parse[0]));
            map.putIfAbsent(parse[1], new MedalCountry(parse[1]));
            map.putIfAbsent(parse[2], new MedalCountry(parse[2]));
            map.get(parse[0]).myGold++;
            map.get(parse[1]).mySilver++;
            map.get(parse[2]).myBronze++;
        }
        ArrayList<MedalCountry> list = new ArrayList<>(map.values());
        Comparator<MedalCountry> gold = Comparator.comparing(MedalCountry::getMyGold).reversed();
        Comparator<MedalCountry> silver = Comparator.comparing(MedalCountry::getMySilver).reversed();
        Comparator<MedalCountry> bronze = Comparator.comparing(MedalCountry::getMyBronze).reversed();
        Comparator<MedalCountry> country = Comparator.comparing(MedalCountry::getName);
        Comparator<MedalCountry> comp = gold.thenComparing(silver.thenComparing(bronze.thenComparing(country)));
        Collections.sort(list, comp);

        ArrayList<String> ret = new ArrayList<>();
        for (MedalCountry c : list) {
            ret.add(c.toString());
        }
        return ret.toArray(new String[0]);
    }
}
