import java.util.Iterator;
import java.util.NoSuchElementException;

public class PredicateIterator<T extends String> implements Iterator {
    private Iterator iter;
    private Predicate predicate;
    private T nextElement;
    private boolean hasNext;

    public PredicateIterator(Iterator iter, Predicate predicate) {
        this.iter = iter;
        this.predicate = predicate;
        nextMatch();
    }
    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public T next() {
        if (!hasNext) throw new NoSuchElementException();
        return nextMatch();
    }

    private T nextMatch() {
        T oldMatch = nextElement;
        while(iter.hasNext()) {
            T o = (T) iter.next();

            if (predicate.test(o)) {
                hasNext = true;
                nextElement = o;
                return oldMatch;
            }
        }
        hasNext = false;
        return oldMatch;
    }
}

