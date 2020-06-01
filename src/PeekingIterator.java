import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer>{
    Integer last;
    Iterator<Integer> iter;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        last = iter.hasNext() ? iter.next() : null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return last;

    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer ans = last;
        last = iter.hasNext() ? iter.next() : null;
        return ans;
    }

    @Override
    public boolean hasNext() {
        return last != null;
    }
}
}
