import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;


public class ArraySet<E>
        implements Set<E> {

    public transient int changeCount;

    private final int DEFAULT_CAPACITY = 5;
    private E[] array;
    int size = 0;

    public ArraySet() {
        array = (E[]) (new Object[DEFAULT_CAPACITY]);

    }

    public ArraySet(int initialCapacity) {
        array = (E[]) (new Object[initialCapacity]);

    }

    public int size() {
        return array.length;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public boolean contains(Object o) {
        for (int i = 0; i < array.length; i++)
            if (o.equals(array[i])) {
                return true;
            }
        return false;
    }

    public Iterator iterator() {
        return new ArraySetIterator();
    }

    public Object[] toArray() {
        Object[] objArray = new Object[size];
        System.arraycopy(array, 0, objArray, 0, size);
        return objArray;
    }

    public boolean add(Object o) {
        ensureCapacity(size + 1);
        if (!contains(o)) {
            array[size++] = (E) o;
            return true;
        } else return false;
    }

    public boolean remove(Object o) {
        if (!isEmpty()) {
            for (int i = 0; i < size(); i++)
                if (o.equals(array[i])) {
                    fastRemove(i);
                    return true;
                }

        }
        return false;
    }

    private void fastRemove(int index) {
        changeCount++;
        int lengthToMove = size - index - 1;
        if (lengthToMove > 0)
            System.arraycopy(array, index + 1, array, index,
                    lengthToMove);
        array[--size] = null;
    }

    public boolean addAll(Collection c) {
        Object[] inputColl = c.toArray();
        int newSize = inputColl.length;
        Object[] uniqueInput = new Object[newSize];
        int k = 0;
        ensureCapacity(size + newSize);
        for (int i = 0; i < newSize; i++)
            if (!contains(inputColl[i])) {
                uniqueInput[k] = inputColl[i];
                k++;
            }
        System.arraycopy(uniqueInput, 0, array, size, uniqueInput.length);
        size += newSize;
        return newSize != 0;
    }

    public void clear() {
        changeCount++;
        array = null;
    }

    @Override
    public String toString() {
        return "ArraySet{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public boolean removeAll(Collection c) {
        Object[] a = c.toArray();
        int newSize = a.length;
        if (!isEmpty()) {
            for (int i = 0; i < newSize; i++) {
                if (contains(a[i])) {
                    fastRemove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean retainAll(Collection c) {
        Object[] a = c.toArray();
        int newSize = a.length;
        if (!isEmpty()) {
            for (int i = 0; i < newSize; i++) {
                if (!contains(a[i])) {
                    fastRemove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsAll(Collection c) {
        Object[] a = c.toArray();
        int newSize = a.length;
        for (int i = 0; i < newSize; i++) {
            if (!contains(a[i])) {
                return false;
            }
        }
        return true;
    }

    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity >= size()) {
            E[] tempArray = array;

            array = (E[]) new Object[size() * 2];

            System.arraycopy(tempArray, 0, array, 0, tempArray.length);
            changeCount++;
        }
    }


    public class ArraySetIterator<E> implements Iterator<E> {
        private int index;
        int expectedChangeCount = changeCount;
        int lastNextRet = -1;

        public ArraySetIterator() {
            index = 0;
        }

        public boolean hasNext() {
            return size() > index;
        }

        public E next() {
            checkForComodification();
            if (index >= size()) {
                throw new NoSuchElementException();
            }
            lastNextRet = index++;
            return (E) array[lastNextRet];
        }

        public void remove() {
            if (lastNextRet < 0)
                throw new IllegalStateException();
            checkForComodification();
            ArraySet.this.fastRemove(lastNextRet);
        }

        final void checkForComodification() {
            if (changeCount != expectedChangeCount)
                throw new ConcurrentModificationException();
        }
    }


}