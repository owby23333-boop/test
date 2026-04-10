package io.rx_cache2.internal.cache.memory.apache;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
abstract class AbstractEmptyIterator<E> {
    protected AbstractEmptyIterator() {
    }

    public void add(E e2) {
        throw new UnsupportedOperationException("addOrUpdate() not supported for empty Iterator");
    }

    public boolean hasNext() {
        return false;
    }

    public boolean hasPrevious() {
        return false;
    }

    public E next() {
        throw new NoSuchElementException("Iterator contains no elements");
    }

    public int nextIndex() {
        return 0;
    }

    public E previous() {
        throw new NoSuchElementException("Iterator contains no elements");
    }

    public int previousIndex() {
        return -1;
    }

    public void remove() {
        throw new IllegalStateException("Iterator contains no elements");
    }

    public void reset() {
    }

    public void set(E e2) {
        throw new IllegalStateException("Iterator contains no elements");
    }
}
