public class CirclesCountry {
  public int leastBorders(int[] x, int[] y, int[] r, int x1, int y1, int x2, int y2) {
    int sum = 0;
    for (int i = 0 ; i < x.length ; i++)
    {
      if (isInside(x[i],y[i],r[i],x1,y1) ^ isInside(x[i],y[i],r[i],x2,y2))
        sum++;
    }
    return sum;
  }
  public boolean isInside(int x, int y, int r, int x1, int y1)
  {
    return r >= Math.hypot(x-x1,y-y1);
  }
}
