package iterator;

public class IntSetIterator implements Iterator{
    private IntSet intSet;
    private int index;
    public IntSetIterator(IntSet intSet) {
        this.intSet = intSet;
        this.index = 0;
    }
    public boolean hasNext() {
        if (index < intSet.getLength()) {
            return true;
        } else {
            return false;
        }
    }
    public int next() {
        int i = intSet.getIntAt(index);
        index++;
        return i;
    }
}
