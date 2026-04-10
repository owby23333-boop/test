package kotlin.k;

import java.util.Comparator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes3.dex */
final class f implements Comparator<Comparable<? super Object>> {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final f f20967s = new f();

    private f() {
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(@NotNull Comparable<Object> comparable, @NotNull Comparable<Object> comparable2) {
        return comparable2.compareTo(comparable);
    }

    @Override // java.util.Comparator
    @NotNull
    public final Comparator<Comparable<? super Object>> reversed() {
        return e.f20966s;
    }
}
