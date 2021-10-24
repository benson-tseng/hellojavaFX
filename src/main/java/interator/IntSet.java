package interator;

public class IntSet implements Set{
    private int[] intSet;
    private int last = 0;
    public IntSet(int maxsize) {
        this.intSet = new int[maxsize];
    }

    public int getIntAt(int index) {
        return intSet[index];
    }

    public void appendInt(int i) {
        this.intSet[last] = i;
        last++;
    }
    public int getLength() {
        return last;
    }
    public Iterator iterator() {
        return new IntSetIterator(this);
    }
}
