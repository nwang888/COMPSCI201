public class SoccerLeagues {
    public int[] points(String[] matches) {
        int[] ret = new int[matches.length];
        for (int r = 0 ; r < matches.length ; r++)
            for (int c = 0 ; c < matches[r].length() ; c++)
                if (matches[r].substring(c,c+1).equals("W")) {
                    ret[r] += 3;
                }
                else if (matches[r].substring(c,c+1).equals("D")) {
                    ret[c]++;
                    ret[r]++;
                }
                else if (matches[r].substring(c,c+1).equals("L")) {
                    ret[c] += 3;
                }
        return ret;
    }
}