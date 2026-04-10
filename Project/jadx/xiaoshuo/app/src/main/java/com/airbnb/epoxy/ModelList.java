package com.airbnb.epoxy;

import androidx.annotation.NonNull;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
class ModelList extends ArrayList<EpoxyModel<?>> {
    private boolean notificationsPaused;
    private ModelListObserver observer;

    public class Itr implements Iterator<EpoxyModel<?>> {
        int cursor;
        int expectedModCount;
        int lastRet;

        private Itr() {
            this.lastRet = -1;
            this.expectedModCount = ((ArrayList) ModelList.this).modCount;
        }

        public final void checkForComodification() {
            if (((ArrayList) ModelList.this).modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != ModelList.this.size();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.lastRet < 0) {
                throw new IllegalStateException();
            }
            checkForComodification();
            try {
                ModelList.this.remove(this.lastRet);
                this.cursor = this.lastRet;
                this.lastRet = -1;
                this.expectedModCount = ((ArrayList) ModelList.this).modCount;
            } catch (IndexOutOfBoundsException unused) {
                throw new ConcurrentModificationException();
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public EpoxyModel<?> next() {
            checkForComodification();
            int i = this.cursor;
            this.cursor = i + 1;
            this.lastRet = i;
            return ModelList.this.get(i);
        }
    }

    public class ListItr extends Itr implements ListIterator<EpoxyModel<?>> {
        public ListItr(int i) {
            super();
            this.cursor = i;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.cursor != 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.cursor;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.cursor - 1;
        }

        @Override // java.util.ListIterator
        public void add(EpoxyModel<?> epoxyModel) {
            checkForComodification();
            try {
                int i = this.cursor;
                ModelList.this.add(i, epoxyModel);
                this.cursor = i + 1;
                this.lastRet = -1;
                this.expectedModCount = ((ArrayList) ModelList.this).modCount;
            } catch (IndexOutOfBoundsException unused) {
                throw new ConcurrentModificationException();
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.ListIterator
        public EpoxyModel<?> previous() {
            checkForComodification();
            int i = this.cursor - 1;
            if (i < 0) {
                throw new NoSuchElementException();
            }
            this.cursor = i;
            this.lastRet = i;
            return ModelList.this.get(i);
        }

        @Override // java.util.ListIterator
        public void set(EpoxyModel<?> epoxyModel) {
            if (this.lastRet < 0) {
                throw new IllegalStateException();
            }
            checkForComodification();
            try {
                ModelList.this.set(this.lastRet, epoxyModel);
            } catch (IndexOutOfBoundsException unused) {
                throw new ConcurrentModificationException();
            }
        }
    }

    public interface ModelListObserver {
        void onItemRangeInserted(int i, int i2);

        void onItemRangeRemoved(int i, int i2);
    }

    public static class SubList extends AbstractList<EpoxyModel<?>> {
        private final ModelList fullList;
        private int offset;
        private int size;

        public static final class SubListIterator implements ListIterator<EpoxyModel<?>> {
            private int end;
            private final ListIterator<EpoxyModel<?>> iterator;
            private int start;
            private final SubList subList;

            public SubListIterator(ListIterator<EpoxyModel<?>> listIterator, SubList subList, int i, int i2) {
                this.iterator = listIterator;
                this.subList = subList;
                this.start = i;
                this.end = i + i2;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.iterator.nextIndex() < this.end;
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.iterator.previousIndex() >= this.start;
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.iterator.nextIndex() - this.start;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                int iPreviousIndex = this.iterator.previousIndex();
                int i = this.start;
                if (iPreviousIndex >= i) {
                    return iPreviousIndex - i;
                }
                return -1;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                this.iterator.remove();
                this.subList.sizeChanged(false);
                this.end--;
            }

            @Override // java.util.ListIterator
            public void add(EpoxyModel<?> epoxyModel) {
                this.iterator.add(epoxyModel);
                this.subList.sizeChanged(true);
                this.end++;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public EpoxyModel<?> next() {
                if (this.iterator.nextIndex() < this.end) {
                    return this.iterator.next();
                }
                throw new NoSuchElementException();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.ListIterator
            public EpoxyModel<?> previous() {
                if (this.iterator.previousIndex() >= this.start) {
                    return this.iterator.previous();
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.ListIterator
            public void set(EpoxyModel<?> epoxyModel) {
                this.iterator.set(epoxyModel);
            }
        }

        public SubList(ModelList modelList, int i, int i2) {
            this.fullList = modelList;
            ((AbstractList) this).modCount = ((ArrayList) modelList).modCount;
            this.offset = i;
            this.size = i2 - i;
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int i, Collection<? extends EpoxyModel<?>> collection) {
            if (((AbstractList) this).modCount != ((ArrayList) this.fullList).modCount) {
                throw new ConcurrentModificationException();
            }
            if (i < 0 || i > this.size) {
                throw new IndexOutOfBoundsException();
            }
            boolean zAddAll = this.fullList.addAll(i + this.offset, collection);
            if (zAddAll) {
                this.size += collection.size();
                ((AbstractList) this).modCount = ((ArrayList) this.fullList).modCount;
            }
            return zAddAll;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        @NonNull
        public Iterator<EpoxyModel<?>> iterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractList, java.util.List
        @NonNull
        public ListIterator<EpoxyModel<?>> listIterator(int i) {
            if (((AbstractList) this).modCount != ((ArrayList) this.fullList).modCount) {
                throw new ConcurrentModificationException();
            }
            if (i < 0 || i > this.size) {
                throw new IndexOutOfBoundsException();
            }
            return new SubListIterator(this.fullList.listIterator(i + this.offset), this, this.offset, this.size);
        }

        @Override // java.util.AbstractList
        public void removeRange(int i, int i2) {
            if (i != i2) {
                if (((AbstractList) this).modCount != ((ArrayList) this.fullList).modCount) {
                    throw new ConcurrentModificationException();
                }
                ModelList modelList = this.fullList;
                int i3 = this.offset;
                modelList.removeRange(i + i3, i3 + i2);
                this.size -= i2 - i;
                ((AbstractList) this).modCount = ((ArrayList) this.fullList).modCount;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            if (((AbstractList) this).modCount == ((ArrayList) this.fullList).modCount) {
                return this.size;
            }
            throw new ConcurrentModificationException();
        }

        public void sizeChanged(boolean z) {
            if (z) {
                this.size++;
            } else {
                this.size--;
            }
            ((AbstractList) this).modCount = ((ArrayList) this.fullList).modCount;
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i, EpoxyModel<?> epoxyModel) {
            if (((AbstractList) this).modCount != ((ArrayList) this.fullList).modCount) {
                throw new ConcurrentModificationException();
            }
            if (i < 0 || i > this.size) {
                throw new IndexOutOfBoundsException();
            }
            this.fullList.add(i + this.offset, epoxyModel);
            this.size++;
            ((AbstractList) this).modCount = ((ArrayList) this.fullList).modCount;
        }

        @Override // java.util.AbstractList, java.util.List
        public EpoxyModel<?> get(int i) {
            if (((AbstractList) this).modCount != ((ArrayList) this.fullList).modCount) {
                throw new ConcurrentModificationException();
            }
            if (i < 0 || i >= this.size) {
                throw new IndexOutOfBoundsException();
            }
            return this.fullList.get(i + this.offset);
        }

        @Override // java.util.AbstractList, java.util.List
        public EpoxyModel<?> remove(int i) {
            if (((AbstractList) this).modCount != ((ArrayList) this.fullList).modCount) {
                throw new ConcurrentModificationException();
            }
            if (i < 0 || i >= this.size) {
                throw new IndexOutOfBoundsException();
            }
            EpoxyModel<?> epoxyModelRemove = this.fullList.remove(i + this.offset);
            this.size--;
            ((AbstractList) this).modCount = ((ArrayList) this.fullList).modCount;
            return epoxyModelRemove;
        }

        @Override // java.util.AbstractList, java.util.List
        public EpoxyModel<?> set(int i, EpoxyModel<?> epoxyModel) {
            if (((AbstractList) this).modCount != ((ArrayList) this.fullList).modCount) {
                throw new ConcurrentModificationException();
            }
            if (i < 0 || i >= this.size) {
                throw new IndexOutOfBoundsException();
            }
            return this.fullList.set(i + this.offset, epoxyModel);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(@NonNull Collection<? extends EpoxyModel<?>> collection) {
            if (((AbstractList) this).modCount == ((ArrayList) this.fullList).modCount) {
                boolean zAddAll = this.fullList.addAll(this.offset + this.size, collection);
                if (zAddAll) {
                    this.size += collection.size();
                    ((AbstractList) this).modCount = ((ArrayList) this.fullList).modCount;
                }
                return zAddAll;
            }
            throw new ConcurrentModificationException();
        }
    }

    public ModelList(int i) {
        super(i);
    }

    private void notifyInsertion(int i, int i2) {
        ModelListObserver modelListObserver;
        if (this.notificationsPaused || (modelListObserver = this.observer) == null) {
            return;
        }
        modelListObserver.onItemRangeInserted(i, i2);
    }

    private void notifyRemoval(int i, int i2) {
        ModelListObserver modelListObserver;
        if (this.notificationsPaused || (modelListObserver = this.observer) == null) {
            return;
        }
        modelListObserver.onItemRangeRemoved(i, i2);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends EpoxyModel<?>> collection) {
        notifyInsertion(size(), collection.size());
        return super.addAll(collection);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (isEmpty()) {
            return;
        }
        notifyRemoval(0, size());
        super.clear();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @NonNull
    public Iterator<EpoxyModel<?>> iterator() {
        return new Itr();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    @NonNull
    public ListIterator<EpoxyModel<?>> listIterator() {
        return new ListItr(0);
    }

    public void pauseNotifications() {
        if (this.notificationsPaused) {
            throw new IllegalStateException("Notifications already paused");
        }
        this.notificationsPaused = true;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> collection) {
        Iterator<EpoxyModel<?>> it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.ArrayList, java.util.AbstractList
    public void removeRange(int i, int i2) {
        if (i == i2) {
            return;
        }
        notifyRemoval(i, i2 - i);
        super.removeRange(i, i2);
    }

    public void resumeNotifications() {
        if (!this.notificationsPaused) {
            throw new IllegalStateException("Notifications already resumed");
        }
        this.notificationsPaused = false;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> collection) {
        Iterator<EpoxyModel<?>> it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public void setObserver(ModelListObserver modelListObserver) {
        this.observer = modelListObserver;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    @NonNull
    public List<EpoxyModel<?>> subList(int i, int i2) {
        if (i < 0 || i2 > size()) {
            throw new IndexOutOfBoundsException();
        }
        if (i <= i2) {
            return new SubList(this, i, i2);
        }
        throw new IllegalArgumentException();
    }

    public ModelList() {
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    @NonNull
    public ListIterator<EpoxyModel<?>> listIterator(int i) {
        return new ListItr(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public EpoxyModel<?> remove(int i) {
        notifyRemoval(i, 1);
        return (EpoxyModel) super.remove(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public EpoxyModel<?> set(int i, EpoxyModel<?> epoxyModel) {
        EpoxyModel<?> epoxyModel2 = (EpoxyModel) super.set(i, epoxyModel);
        if (epoxyModel2.id() != epoxyModel.id()) {
            notifyRemoval(i, 1);
            notifyInsertion(i, 1);
        }
        return epoxyModel2;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(EpoxyModel<?> epoxyModel) {
        notifyInsertion(size(), 1);
        return super.add(epoxyModel);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends EpoxyModel<?>> collection) {
        notifyInsertion(i, collection.size());
        return super.addAll(i, collection);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        notifyRemoval(iIndexOf, 1);
        super.remove(iIndexOf);
        return true;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public void add(int i, EpoxyModel<?> epoxyModel) {
        notifyInsertion(i, 1);
        super.add(i, epoxyModel);
    }
}
