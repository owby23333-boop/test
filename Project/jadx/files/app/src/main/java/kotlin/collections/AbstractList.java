package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.anythink.core.api.ATAdConst;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: kotlin.collections.a, reason: from Kotlin metadata */
/* JADX INFO: compiled from: AbstractList.kt */
/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.1")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\b\b'\u0018\u0000 \u001c*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004\u001c\u001d\u001e\u001fB\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\u0016\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u0006H¦\u0002¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0096\u0002J\u0015\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0016R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006 "}, d2 = {"Lkotlin/collections/AbstractList;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractCollection;", "", "()V", ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "", "getSize", "()I", "equals", "", "other", "", MonitorConstants.CONNECT_TYPE_GET, "index", "(I)Ljava/lang/Object;", TTDownloadField.TT_HASHCODE, "indexOf", "element", "(Ljava/lang/Object;)I", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "Companion", "IteratorImpl", "ListIteratorImpl", "SubList", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E>, kotlin.jvm.internal.o.a {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: kotlin.collections.a$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: AbstractList.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void a(int i2, int i3) {
            if (i2 < 0 || i2 >= i3) {
                throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + i3);
            }
        }

        public final void b(int i2, int i3) {
            if (i2 < 0 || i2 > i3) {
                throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + i3);
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final void a(int i2, int i3, int i4) {
            if (i2 < 0 || i3 > i4) {
                throw new IndexOutOfBoundsException("fromIndex: " + i2 + ", toIndex: " + i3 + ", size: " + i4);
            }
            if (i2 <= i3) {
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i2 + " > toIndex: " + i3);
        }

        public final int a(@NotNull Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            int iHashCode = 1;
            while (it.hasNext()) {
                Object next = it.next();
                iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
            }
            return iHashCode;
        }

        public final boolean a(@NotNull Collection<?> collection, @NotNull Collection<?> collection2) {
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator<?> it = collection2.iterator();
            Iterator<?> it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!kotlin.jvm.internal.i.a(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.a$b */
    /* JADX INFO: compiled from: AbstractList.kt */
    private class b implements Iterator<E>, kotlin.jvm.internal.o.a {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f20944s;

        public b() {
        }

        protected final int a() {
            return this.f20944s;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f20944s < AbstractList.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            AbstractList abstractList = AbstractList.this;
            int i2 = this.f20944s;
            this.f20944s = i2 + 1;
            return (E) abstractList.get(i2);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        protected final void a(int i2) {
            this.f20944s = i2;
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.a$c */
    /* JADX INFO: compiled from: AbstractList.kt */
    private class c extends AbstractList<E>.b implements ListIterator<E>, kotlin.jvm.internal.o.a {
        public c(int i2) {
            super();
            AbstractList.INSTANCE.b(i2, AbstractList.this.size());
            a(i2);
        }

        @Override // java.util.ListIterator
        public void add(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return a() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return a();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            AbstractList abstractList = AbstractList.this;
            a(a() - 1);
            return (E) abstractList.get(a());
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return a() - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.a$d */
    /* JADX INFO: compiled from: AbstractList.kt */
    private static final class d<E> extends AbstractList<E> implements RandomAccess {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f20947s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final AbstractList<E> f20948t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final int f20949u;

        /* JADX WARN: Multi-variable type inference failed */
        public d(@NotNull AbstractList<? extends E> abstractList, int i2, int i3) {
            this.f20948t = abstractList;
            this.f20949u = i2;
            AbstractList.INSTANCE.a(this.f20949u, i3, this.f20948t.size());
            this.f20947s = i3 - this.f20949u;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public E get(int i2) {
            AbstractList.INSTANCE.a(i2, this.f20947s);
            return this.f20948t.get(this.f20949u + i2);
        }

        @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.f20947s;
        }
    }

    protected AbstractList() {
    }

    @Override // java.util.List
    public void add(int i2, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i2, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof List) {
            return INSTANCE.a(this, (Collection<?>) other);
        }
        return false;
    }

    @Override // java.util.List
    public abstract E get(int index);

    @Override // kotlin.collections.AbstractCollection
    public abstract int getSize();

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return INSTANCE.a(this);
    }

    @Override // java.util.List
    public int indexOf(Object element) {
        Iterator<E> it = iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (kotlin.jvm.internal.i.a(it.next(), element)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<E> iterator() {
        return new b();
    }

    @Override // java.util.List
    public int lastIndexOf(Object element) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (kotlin.jvm.internal.i.a(listIterator.previous(), element)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<E> listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public E remove(int i2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i2, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    @NotNull
    public List<E> subList(int fromIndex, int toIndex) {
        return new d(this, fromIndex, toIndex);
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<E> listIterator(int index) {
        return new c(index);
    }
}
