package com.duokan.common;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes12.dex */
public class FixedOrderComparator<T> implements Comparator<T>, Serializable {
    private static final long serialVersionUID = 82794675842863201L;
    private final Map<T, Integer> map = new HashMap();
    private int counter = 0;
    private boolean isLocked = false;
    private UnknownObjectBehavior unknownObjectBehavior = UnknownObjectBehavior.EXCEPTION;

    public enum UnknownObjectBehavior {
        BEFORE,
        AFTER,
        EXCEPTION
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2733a;

        static {
            int[] iArr = new int[UnknownObjectBehavior.values().length];
            f2733a = iArr;
            try {
                iArr[UnknownObjectBehavior.BEFORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2733a[UnknownObjectBehavior.AFTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2733a[UnknownObjectBehavior.EXCEPTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public FixedOrderComparator() {
    }

    public boolean add(T t) {
        checkLocked();
        Map<T, Integer> map = this.map;
        int i = this.counter;
        this.counter = i + 1;
        return map.put(t, Integer.valueOf(i)) == null;
    }

    public boolean addAsEqual(T t, T t2) {
        checkLocked();
        Integer num = this.map.get(t);
        if (num != null) {
            return this.map.put(t2, num) == null;
        }
        throw new IllegalArgumentException(t + " not known to " + this);
    }

    public void checkLocked() {
        if (isLocked()) {
            throw new UnsupportedOperationException("Cannot modify a FixedOrderComparator after a comparison");
        }
    }

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        this.isLocked = true;
        Integer num = this.map.get(t);
        Integer num2 = this.map.get(t2);
        if (num != null && num2 != null) {
            return num.compareTo(num2);
        }
        int i = a.f2733a[this.unknownObjectBehavior.ordinal()];
        if (i == 1) {
            if (num == null) {
                return num2 == null ? 0 : -1;
            }
            return 1;
        }
        if (i == 2) {
            if (num == null) {
                return num2 == null ? 0 : 1;
            }
            return -1;
        }
        if (i != 3) {
            throw new UnsupportedOperationException("Unknown unknownObjectBehavior: " + this.unknownObjectBehavior);
        }
        if (num != null) {
            t = t2;
        }
        throw new IllegalArgumentException("Attempting to compare unknown object " + t);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FixedOrderComparator fixedOrderComparator = (FixedOrderComparator) obj;
        Map<T, Integer> map = this.map;
        if (map != null ? map.equals(fixedOrderComparator.map) : fixedOrderComparator.map == null) {
            UnknownObjectBehavior unknownObjectBehavior = this.unknownObjectBehavior;
            if (unknownObjectBehavior != null) {
                UnknownObjectBehavior unknownObjectBehavior2 = fixedOrderComparator.unknownObjectBehavior;
                if (unknownObjectBehavior == unknownObjectBehavior2 && this.counter == fixedOrderComparator.counter && this.isLocked == fixedOrderComparator.isLocked && unknownObjectBehavior == unknownObjectBehavior2) {
                    return true;
                }
            } else if (fixedOrderComparator.unknownObjectBehavior == null) {
                return true;
            }
        }
        return false;
    }

    public UnknownObjectBehavior getUnknownObjectBehavior() {
        return this.unknownObjectBehavior;
    }

    public int hashCode() {
        int iHashCode = (MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME + this.map.hashCode()) * 37;
        UnknownObjectBehavior unknownObjectBehavior = this.unknownObjectBehavior;
        return ((((iHashCode + (unknownObjectBehavior == null ? 0 : unknownObjectBehavior.hashCode())) * 37) + this.counter) * 37) + (!this.isLocked ? 1 : 0);
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    public void setUnknownObjectBehavior(UnknownObjectBehavior unknownObjectBehavior) {
        checkLocked();
        Objects.requireNonNull(unknownObjectBehavior, "unknownObjectBehavior");
        this.unknownObjectBehavior = unknownObjectBehavior;
    }

    public FixedOrderComparator(T... tArr) {
        Objects.requireNonNull(tArr, "items");
        for (T t : tArr) {
            add(t);
        }
    }

    public FixedOrderComparator(List<T> list) {
        Objects.requireNonNull(list, "items");
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }
}
