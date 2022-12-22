public class AccessLevel {
    public String canAccess(int[] rights, int minPermission) {
        String strreturn = "";
        for (int i = 0 ; i < rights.length ; i++)
        {
            if (rights[i] < minPermission)
                strreturn += "D";
            else
                strreturn += "A";
        }
        return strreturn;
    }
}