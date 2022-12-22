public class TrueSpace {
    public long calculateSpace(int[] sizes, int clusterSize) {
        long space = 0;
        for (int size : sizes) {
            if (size % clusterSize != 0)
                space += clusterSize;
            space += size / clusterSize * clusterSize;
        }
        return space;
    }
}